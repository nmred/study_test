<?php
class json_string_equals_json_file extends PHPUnit_FrameWork_TestCase
{
	/**
	 * test_failure 
	 * 
	 * @access public
	 * @return void
	 */
	public function test_failure()
	{
		$expected = json_encode(array('footets', 'bar'));
		$this->assertJsonStringEqualsJsonFile($expected, 'a.json');	
	}	
}
