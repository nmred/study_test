<?php
class output_test extends PHPUnit_Framework_TestCase
{
	/**
	 * test_exception_foo_actual_foo 
	 * 
	 * @access public
	 * @return void
	 */
	public function test_exception_foo_actual_foo()
	{
		$this->expectOutputString('foo');
		echo 'foo';	
	}

	/**
	 * test_exception_bar_actual_baz 
	 * 
	 * @access public
	 * @return void
	 */
	public function test_exception_bar_actual_baz()
	{
		$this->expectOutputString('bar');
		echo 'barz';	
	}
}
