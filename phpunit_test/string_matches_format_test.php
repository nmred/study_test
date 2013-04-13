<?php
class string_matches_format_test extends PHPUnit_FrameWork_TestCase
{
	/**
	 * test_failure 
	 * 
	 * @access public
	 * @return void
	 */
	public function test_failure()
	{
		$this->assertStringMatchesFormat('%i', 'foo');	
	}	

	/**
	 * test_failure_1 
	 * 
	 * @access public
	 * @return void
	 */
	public function test_failure_1()
	{
		$this->assertStringNotMatchesFormat('%i', '22');	
	}	
}
