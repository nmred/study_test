<?php
class expected_error_test extends PHPUnit_Framework_TestCase
{
	/**
	 * test_failing_include 
	 * 
	 * @expectedException PHPUnit_Framework_Error
	 * @access public
	 * @return void
	 */
	public function test_failing_include()
	{
		include 'aaa.php';
	}	
}
