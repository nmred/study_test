<?php
class json_string_equals_json_string extends PHPUnit_FrameWork_TestCase
{
	/**
	 * test_failure 
	 * 
	 * @access public
	 * @return void
	 */
	public function test_failure()
	{
		$expected = json_encode(array('foo' => 'foo'));
		$actual = json_encode(array('foo' => 'bar'));
		$this->assertJsonStringEqualsJsonString($expected, $actual);	
	}	
}
