<?php
class attribute_equals_test extends PHPUnit_FrameWork_TestCase
{
	/**
	 * test_failure 
	 * 
	 * @access public
	 * @return void
	 */
	public function test_failure()
	{
		$this->assertAttributeEquals('222', 'foo', new foo);	
	}	


	/**
	 * test_failure_1 
	 * 
	 * @access public
	 * @return void
	 */
	public function test_failure_1()
	{
		$this->assertAttributeNotEquals('1', 'foo', new foo);	
	}
}

class foo
{
	public $foo = '1';
}
