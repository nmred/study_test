<?php
class class_has_static_attribute_test extends PHPUnit_FrameWork_TestCase
{
	/**
	 * test_failure 
	 * 
	 * @access public
	 * @return void
	 */
	public function test_failure()
	{
		$this->assertClassHasStaticAttribute('__file1', 'test');	
	}	

	/**
	 * test_failure 
	 * 
	 * @access public
	 * @return void
	 */
	public function test_no_attribute()
	{
		$this->assertClassNotHasStaticAttribute('__test_static', 'test');	
	}	
}

class test
{
	protected $__file;

	protected static $__test_static;
}
