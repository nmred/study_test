<?php
class reg_exp_test extends PHPUnit_FrameWork_TestCase
{
	/**
	 * test_failure 
	 * 
	 * @access public
	 * @return void
	 */
	public function test_failure()
	{
		$this->assertRegExp('/foo/', 'bar');	
	}	

	/**
	 * test_success 
	 * 
	 * @access public
	 * @return void
	 */
	public function test_success()
	{
		$this->assertNotRegExp('/foo/', 'bar');	
	}
}
