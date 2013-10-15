<?php
class string_equals_file_test extends PHPUnit_FrameWork_TestCase
{
	/**
	 * test_failure 
	 * 
	 * @access public
	 * @return void
	 */
	public function test_failure()
	{
		file_put_contents('a.file', 'expected');
		$this->assertStringEqualsFile('a.file', 'actual');	
	}	
}
