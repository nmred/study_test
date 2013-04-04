<?php
class attribute_greater_than_test extends PHPUnit_FrameWork_TestCase
{
	/**
	 * test_failure 
	 * 
	 * @access public
	 * @return void
	 */
	public function test_failure()
	{
		$this->assertAttributeGreaterThan('222', 'foo', new foo);
	}	
}

class foo
{
	public $foo = 1;	
}
