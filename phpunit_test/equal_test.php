<?php
class equal_test extends PHPUnit_FrameWork_TestCase
{
	/**
	 * test_failure 
	 * 
	 * @access public
	 * @return void
	 */
	public function test_failure()
	{
		$this->assertEquals(1, 0);	
	}	

	/**
	 * test_failure_1 
	 * 
	 * @access public
	 * @return void
	 */
	public function test_failure_1()
	{
		$this->assertNotEquals(1, 1);	
	}

	/**
	 * test_failure_2 
	 * 
	 * @access public
	 * @return void
	 */
	public function test_failure_2()
	{
		$this->assertEquals('bar', 'baz');	
	}
	
	/**
	 * test_failure_3 
	 * 
	 * @access public
	 * @return void
	 */
	public function test_failure_3()
	{
		$this->assertEquals("foo\nbar\nbaz\n", "foo\nbah\nbaz\n");	
	}
}
