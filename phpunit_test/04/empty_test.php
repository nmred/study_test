<?php
class empty_test extends PHPUnit_FrameWork_TestCase
{
	/**
	 * test_failure 
	 * 
	 * @access public
	 * @return void
	 */
	public function test_failure()
	{
		$this->assertEmpty(array('foo'));	
	}
	
	/**
	 * test_failure1 
	 * 
	 * @access public
	 * @return void
	 */
	public function test_failure1()
	{
		$this->assertNotEmpty(array());
	}
}
