<?php
class equals_float_test extends PHPUnit_FrameWork_TestCase
{
	/**
	 * test_success 
	 * 
	 * @access public
	 * @return void
	 */
	public function test_success()
	{
		$this->assertEquals(1.0, 1.1, '', 0.2);	
	}	

	/**
	 * test_failure 
	 * 
	 * @access public
	 * @return void
	 */
	public function test_failure()
	{
		$this->assertEquals(1.0, 1.1);	
	}
}
