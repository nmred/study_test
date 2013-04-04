<?php
class attribute_same_test extends PHPUnit_FrameWork_TestCase
{
	/**
	 * test_failure 
	 * 
	 * @access public
	 * @return void
	 */
	public function test_failure()
	{
		$foo = new stdClass;
		$foo->foo = 2204;
		$this->assertAttributeSame('2204', 'foo', $foo);	
	}	

	/**
	 * test_success 
	 * 
	 * @access public
	 * @return void
	 */
	public function test_success()
	{
		$foo = new stdClass;
		$foo->foo = 2204;
		$this->assertAttributeNotSame('2204', 'foo', $foo);	
	}
}
