<?php
class json_file_equals_json_file_test extends PHPUnit_FrameWork_TestCase
{
	/**
	 * test_failure 
	 * 
	 * @access public
	 * @return void
	 */
	public function test_failure()
	{
		$this->assertJsonFileEqualsJsonFile('a.json', 'b.json');	
	}	
}
