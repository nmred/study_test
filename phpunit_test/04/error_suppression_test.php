<?php
class error_suppression_test extends PHPUnit_Framework_TestCase
{
	/**
	 * test_file_writing 
	 * 
	 * @access public
	 * @return void
	 */
	public function test_file_writing()
	{
		$writer = new file_writer;
		$this->assertFalse(@$writer->write('dsdsdsdssds', 'stufff'));
	}
}

class file_writer
{
	public function write($file, $content)
	{
		$file = fopen($file, 'r');
		if (false == $file) {
			return false;	
		}	
	}	
}
