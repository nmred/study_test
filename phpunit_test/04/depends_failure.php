<?php
class dependency_failure_test extends PHPUnit_Framework_TestCase
{
	/**
	 * test_one 
	 * 
	 * @access public
	 * @return void
	 */
	public function test_one()
	{
		$this->assertTrue(false);	
	}

	/**
	 * test_two 
	 * 
	 * @access public
	 * @depends test_one
	 * @return void
	 */
	public function test_two()
	{
	}		
}
