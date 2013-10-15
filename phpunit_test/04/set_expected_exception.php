<?php
class set_expected_exception extends PHPUnit_Framework_TestCase
{
	/**
	 * test_exception
	 * 
	 * @access public
	 * @return void
	 */
	public function test_exception()
	{
		$this->setExpectedException('InvalidArgumentException');
	}

	/**
	 * test_exception_has_right_message
	 * 
	 * @access public
	 * @return void
	 */
	public function test_exception_has_right_message()
	{
		$this->setExpectedException('InvalidArgumentException', 'Right Message', 10);
		throw new InvalidArgumentException('Some Message', 10);
	}

	/**
	 * test_exception_has_right_code
	 * 
	 * @access public
	 * @return void
	 */
	public function test_exception_has_right_code()
	{
		$this->setExpectedException('InvalidArgumentException', 'Right Message', 20);
		throw new InvalidArgumentException('Some Message', 10);
	}

}
