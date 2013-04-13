<?php
class same_test extends PHPUnit_FrameWork_TestCase
{
	/**
	 * test_failure 
	 * 
	 * @access public
	 * @return void
	 */
	public function test_failure()
	{
		$this->assertSame('2204', 2204);	
	}	

	/**
	 * test_success 
	 * 
	 * @access public
	 * @return void
	 */
	public function test_success()
	{
		$this->assertNotSame('2204', 2204);	
	}
}
