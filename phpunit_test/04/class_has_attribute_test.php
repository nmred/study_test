<?php
class class_has_attribute_test extends PHPUnit_FrameWork_TestCase
{
	/**
	 * test_failure 
	 * 
	 * @access public
	 * @return void
	 */
	public function test_failure()
	{
		$this->assertClassHasAttribute('__file1', 'test');	
	}	

	/**
	 * test_failure 
	 * 
	 * @access public
	 * @return void
	 */
	public function test_no_attribute()
	{
		$this->assertClassNotHasAttribute('__file', 'test');	
	}	
}

class test
{
	protected $__file;	
}
