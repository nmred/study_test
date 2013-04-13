<?php
class attribute_less_than_or_equal_test extends PHPUnit_FrameWork_TestCase
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
		$foo->foo = 2;
		$this->assertAttributeLessThanOrEqual(1, 'foo', $foo);	
	}	
}
