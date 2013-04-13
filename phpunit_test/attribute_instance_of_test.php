<?php
class attribute_instance_of_test extends PHPUnit_FrameWork_TestCase
{
	/**
	 * test_failure 
	 * 
	 * @access public
	 * @return void
	 */
	public function test_success()
	{
		$this->assertAttributeInstanceOf('RuntimeException','foo', new foo);
	}	
}

class foo
{
	public $foo ;	

	public function __construct()
	{
		$this->foo = new RuntimeException();	
	}
}
