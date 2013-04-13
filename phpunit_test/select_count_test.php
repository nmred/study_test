<?php
class select_count_test extends PHPUnit_FrameWork_TestCase
{
	/**
	 * setUp 
	 * 
	 * @access protected
	 * @return void
	 */
	protected function setUp()
	{
		$this->xml = new DOMDocument;
		$this->xml->loadXML('<foo><bar/><bar/><bar/></foo>');	
	}	

	/**
	 * test_absence_failure 
	 * 
	 * @access public
	 * @return void
	 */
	public function test_absence_failure()
	{
		$this->assertSelectCount('foo bar', false, $this->xml);	
	}

	/**
	 * test_presence_failure 
	 * 
	 * @access public
	 * @return void
	 */
	public function test_presence_failure()
	{
		$this->assertSelectCount('foo baz', true, $this->xml);
	}

	/**
	 * test_exact_count_failure 
	 * 
	 * @access public
	 * @return void
	 */
	public function test_exact_count_failure()
	{
		$this->assertSelectCount('foo bar', 5, $this->xml);	
	}

	/**
	 * test_range_failure 
	 * 
	 * @access public
	 * @return void
	 */
	public function test_range_failure()
	{
		$this->assertSelectCount('foo bar', array('>' => 6, '<' => 8), $this->xml);	
	}
}
