<?php
class internal_type_test extends PHPUnit_FrameWork_TestCase
{
	/**
	 * test_failure 
	 * 
	 * @access public
	 * @return void
	 */
	public function test_failure()
	{
		$this->assertInternalType('string', 42);	
	}	

	/**
	 * test_success 
	 * 
	 * @access public
	 * @return void
	 */
	public function test_success()
	{
		$this->assertNotInternalType('string', 42);
	}
}
