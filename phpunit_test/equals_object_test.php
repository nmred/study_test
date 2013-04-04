<?php
class equals_object_test extends PHPUnit_FrameWork_TestCase
{
	/**
	 * test_failure 
	 * 
	 * @access public
	 * @return void
	 */
	public function test_failure()
	{
		$expected = new stdClass;
		$expected->foo = 'foo';
		$expected->bar = 'bar';

		$actual = new stdClass;
		$actual->foo = 'bar';
		$actual->baz = 'bar';

		$this->assertEquals($expected, $actual);
	}	
}
