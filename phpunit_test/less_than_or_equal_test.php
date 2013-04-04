<?php
class less_than_or_equal_test extends PHPUnit_FrameWork_TestCase
{
	/**
	 * test_failure 
	 * 
	 * @access public
	 * @return void
	 */
	public function test_failure()
	{
		$this->assertLessThanOrEqual(2, 3);	
	}	
}
