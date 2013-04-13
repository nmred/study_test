<?php
class exception_test_two extends PHPUnit_Framework_TestCase
{
	/**
	 * test_exception_has_right_message
	 * 
	 * @expectedException InvalidArgumentException
	 * @expectedExceptionMessage Right Message
	 * @access public
	 * @return void
	 */
	public function test_exception_has_right_message()
	{
		throw new InvalidArgumentException('Right Message', 10);
		//throw new InvalidArgumentException('Some Message', 10);
	}

	/**
	 * test_exception_has_right_code
	 * 
	 * @expectedException InvalidArgumentException
	 * @expectedExceptionCode 20
	 * @access public
	 * @return void
	 */
	public function test_exception_has_right_code()
	{
		throw new InvalidArgumentException('Some Message', 10);
	}

}
