<?php
class equals_array_test extends PHPUnit_FrameWork_TestCase
{
	/**
	 * test_failure 
	 * 
	 * @access public
	 * @return void
	 */
	public function test_failure()
	{
		$this->assertEquals(array('a', 'b', 'c'), array('a', 'c', 'd'));
	}	
}
