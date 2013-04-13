<?php
require_once './csv_file_iterator.class.php';
class data_test_iterator extends PHPUnit_Framework_TestCase
{
	/**
	 * test_add
	 * 
	 * @dataProvider provider
	 * @access public
	 * @return void
	 */
	public function test_add($a, $b, $c)
	{
		$this->assertEquals($c, $a + $b);
	}

	/**
	 * provider 
	 * 
	 * @access public
	 * @return array
	 */
	public function provider()
	{
		return new csv_file_iterator('a.csv');
	}
}
