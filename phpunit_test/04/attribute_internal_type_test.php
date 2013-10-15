<?php
class attribute_internal_type_test extends PHPUnit_FrameWork_TestCase
{
	/**
	 * test_failure 
	 * 
	 * @access public
	 * @return void
	 */
	public function test_failure()
	{
		$this->assertAttributeInternalType('string', 'foo', new foo);	
	}	

	/**
	 * test_success 
	 * 
	 * @access public
	 * @return void
	 */
	public function test_success()
	{
		$this->assertAttributeNotInternalType('string', 'foo', new foo);	
	}	
}

class foo
{
	public $foo = 1;	
}
