<?php
class data_test extends PHPUnit_Framework_TestCase
{
	/**
	 * test_push_and_pop 
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
		return array(
			array(0, 0, 0),
			array(0, 1, 1),
			array(1, 0, 1),
			array(1, 1, 3)
		);	
	}
}
