<?php
class attribute_greater_than_or_equal_test extends PHPUnit_FrameWork_TestCase
{
	/**
	 * test_failure 
	 * 
	 * @access public
	 * @return void
	 */
	public function test_failure()
	{
		$this->assertAttributeGreaterThanOrEqual(2, 'foo', new foo);
	}	
}

class foo
{
	public $foo = 1;
}
