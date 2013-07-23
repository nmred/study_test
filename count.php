<?php
/* vim: set expandtab tabstop=4 shiftwidth=4 softtabstop=4 foldmethod=marker: */

/**
+------------------------------------------------------------------------------
* feedCount 
+------------------------------------------------------------------------------
* 
* @package 
* @version $_SWANBR_VERSION_$
* @author nmred 
+------------------------------------------------------------------------------
*/
class feedCount
{
	// {{{ members

	/**
	 * 用户列表文件 
	 * 
	 * @var string
	 * @access protected
	 */
	protected $__uidFilename = 'user_list.txt';

	/**
	 * Uid 迭代器 
	 * 
	 * @var SplFileObject
	 * @access protected
	 */
	protected $__uidIterator;

	/**
	 * 临时存储用户的话题 
	 * 
	 * @var array
	 * @access protected
	 */
	protected $__beforeText;

	// }}}
	// {{{ functions
	// {{{ public function __construct()

	/**
	 * __construct 
	 * 
	 * @access public
	 * @return void
	 */
	public function __construct()
	{
	}
	
	// }}}
	// {{{ public function run()

	/**
	 * 运行统计 
	 * 
	 * @access public
	 * @return void
	 */
	public function run()
	{
		$interator = $this->_getUidIterator($this->getUidFileName());
		foreach ($interator as $value) {
			$uid = $value->fgets();
			$this->__uidFeedNum[$uid] = $this->countFeedNum($uid);
			// 回收缓存
			unset($this->__beforeText[$uid]);
		}

		return $this->__uidFeedNum;
	}

	// }}}
	// {{{ public function countFeedNum()

	/**
	 * 统计某个用户的 24 小时 FEED 流数 
	 * 
	 * @param string $uid 
	 * @access public
	 * @return void
	 */
	public function countFeedNum($uid)
	{
		$endTime = time() - 864000;
		$count = 0;
		$page = 0;
		$bool = false;
		do {
			$uidTexts = getUserTimeLine($uid, $page, 1000);
			if (false === $uidTexts) {
				$bool = false;	
			}
			$endText = end($uidTexts);
			if (isset($endText['time']) 
				&& $endText['time'] < $endTime
				&& (count($uidTexts) == 1000)) {
				$bool = true;
				$page++;
			}

			// 开始统计
			foreach ($uidTexts as $value) {
				if (!isset($value['uid']) || !isset($value['text'])) {
					continue;	
				}

				$count += $this->_countFeed($value['uid'], $value['text']);
			}
			
		} while($bool);

		return $count;
	}

	// }}}
	// {{{ public function setUidFileName()
	
	/**
	 * 设置用户 UID 的文件路径 
	 * 
	 * @param string $filename 
	 * @access public
	 * @return feedCount
	 */
	public function setUidFileName($filename)
	{
		if (!file_exists($filename)) {
			return $this;	
		}
		$this->__uidFilename = $filename;

		return $this;
	}
	 
	// }}}
	// {{{ public function getUidFileName()

	/**
	 * 获取 UID 文件名 
	 * 
	 * @access public
	 * @return string
	 */
	public function getUidFileName()
	{
		return $this->__uidFilename;
	}

	// }}}
	// {{{ protected function _getUidIterator()

	/**
	 * 用户 ID 迭代器 
	 * 
	 * @param string $filename 
	 * @access protected
	 * @return SplFileObject
	 */
	protected function _getUidIterator($filename)
	{
		if (!file_exists($filename)) {
			return;	
		}

		$iterator = new SplFileObject($filename);
		$iterator->setFlags(SplFileObject::DROP_NEW_LINE|SplFileObject::SKIP_EMPTY);
		return $iterator;
	}

	// }}}
	// {{{ proteced function _countFeed()
	
	/**
	 * 统计 FEED 个数
	 * 
	 * @param int $uid 
	 * @param string $text 
	 * @access protected
	 * @return boolean  返回：符合的个数 
	 */
	protected function _countFeed($uid, $text)
	{
		// 目前只想到了正则，效率是个问题
		$pattern = '/\#[^\#]*\#/';
		$feedCount = 0;

		$topics = preg_split('@', $text);
		// 排除用户本身发送的信息
		unset($topics[0]);

		foreach ($topics as $topic) {
			if (preg_match_all($pattern, $text, $matches)) {
				if (!isset($matches[0] && isset($this->__beforeText[$uid])) {
					continue;
				}

				$array_diff = array_diff($matches[0], $this->__beforeText[$uid]);
				if ($matches[0] == $array_diff)) {// 排除重复的话题	
					continue;
				} else {
					$this->__beforeText[$uid] = array_merge($this->__beforeText[$uid], $array_diff);	
					$feedCount += count($array_diff);
				}
			}
		}

		return $feedCount;
	}

	// }}}
	// }}}
}

// {{{ function getUserTimeLine()

/**
 * 获取用户时间流信息 
 * 
 * @param string $uid 
 * @param int $page 
 * @param int $count 
 * @access public
 * @return array
 */
function getUserTimeLine($uid, $page = 1, $count = 10)
{
	// 返回用户微博feed流
	// 结构
	//array(
	//	array(
	//		'uid'  => 30222222, 
	//		'text' => 'xxxxx',
	//		'time' => 1371696773,
	//	),
	//);
}

// }}}

$countFeed = new feedCount();
$counts = $countFeed->setUidFileName('./user_list.txt')->run();

