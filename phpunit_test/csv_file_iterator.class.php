<?php
/* vim: set expandtab tabstop=4 shiftwidth=4 softtabstop=4 foldmethod=marker: */
// +---------------------------------------------------------------------------
// | SWAN [ $_SWANBR_SLOGAN_$ ]
// +---------------------------------------------------------------------------
// | Copyright $_SWANBR_COPYRIGHT_$
// +---------------------------------------------------------------------------
// | Version  $_SWANBR_VERSION_$
// +---------------------------------------------------------------------------
// | Licensed ( $_SWANBR_LICENSED_URL_$ )
// +---------------------------------------------------------------------------
// | $_SWANBR_WEB_DOMAIN_$
// +---------------------------------------------------------------------------
 
/**
+------------------------------------------------------------------------------
* csv_file_iterator 
+------------------------------------------------------------------------------
* 
* @uses Iterator
* @package 
* @version $_SWANBR_VERSION_$
* @copyright $_SWANBR_COPYRIGHT_$
* @author $_SWANBR_AUTHOR_$ 
+------------------------------------------------------------------------------
*/
class csv_file_iterator implements Iterator
{
	// {{{ members

	/**
	 * fp handler 
	 * 
	 * @var resource
	 * @access protected
	 */
	protected $__file;

	/**
	 * __key 
	 * 
	 * @var float
	 * @access protected
	 */
	protected $__key = 0;

	/**
	 * __current 
	 * 
	 * @var mixed
	 * @access protected
	 */
	protected $__current;

	// }}}
	// {{{ functions
	// {{{ public function __construct()

	/**
	 * __construct 
	 * 
	 * @param string $file 
	 * @access public
	 * @return void
	 */
	public function __construct($file)
	{
		$this->__file = fopen($file, 'r');
	}

	// }}}
	// {{{ public funciton __destruct()

	/**
	 * __destruct 
	 * 
	 * @access public
	 * @return void
	 */
	public function __destruct()
	{
		fclose($this->__file);	
	}

	// }}}
	// {{{ public function rewind()

	/**
	 * 重置迭代器 
	 * 
	 * @access public
	 * @return void
	 */
	public function rewind()
	{
		rewind($this->__file);
		$this->__current = fgetcsv($this->__file);
		$this->__key = 0;	
	}

	// }}}
	// {{{ public function valid()

	/**
	 * 判断是否合法当前 
	 * 
	 * @access public
	 * @return boolean
	 */
	public function valid()
	{
		return !feof($this->__file);	
	}

	// }}}
	// {{{ public function key()

	/**
	 * 获取迭代器的 KEY 
	 * 
	 * @access public
	 * @return int
	 */
	public function key()
	{
		return $this->__key;	
	}

	// }}}
	// {{{ public function current()
	
	/**
	 * 返回当前的信息 
	 * 
	 * @access public
	 * @return array
	 */
	public function current()
	{
		return $this->__current;	
	}

	// }}}
	// {{{ public function next()

	/**
	 * next 
	 * 
	 * @access public
	 * @return void
	 */
	public function next()
	{
		$this->__current = fgetcsv($this->__file);
		$this->__key++;	
	}

	// }}}
	// }}}
}
