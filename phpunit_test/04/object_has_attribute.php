<?php
class object_has_attribute extends PHPUnit_FrameWork_TestCase
{
	/**
	 * test_failure 
	 * 
	 * @access public
	 * @return void
	 */
	public function test_failure()
	{
		$this->assertObjectHasAttribute('foo', new stdClass);	
	}	

	/**
	 * test_failure_1 
	 * 
	 * @access public
	 * @return void
	 */
	public function test_failure_1()
	{
		$foo = new stdClass;
		$foo->foo = 'dsds';
		$this->assertObjectNotHasAttribute('foo', $foo);	
	}
}
