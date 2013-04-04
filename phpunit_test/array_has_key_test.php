<?php
class array_has_key_test extends PHPUnit_FrameWork_TestCase
{
	/**
	 * test_failure 
	 * 
	 * @access public
	 * @return void
	 */
	public function test_failure()
	{
		$this->assertArrayHasKey('foo', array('bar' => 'barz'));	
	}	
}
