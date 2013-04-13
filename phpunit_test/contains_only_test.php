<?php
class contains_only_test extends PHPUnit_FrameWork_TestCase
{
	/**
	 * test_failure 
	 * 
	 * @access public
	 * @return void
	 */
	public function test_failure()
	{
		$this->assertContainsOnly('string', array(0, 's', 'a'));	
	}	

	/**
	 * test_not_only_failure 
	 * 
	 * @access public
	 * @return void
	 */
	public function test_not_only_failure()
	{
		$this->assertNotContainsOnly('string', array('3', '4'));	
	}
}
