<?php
class stack_test extends PHPUnit_Framework_TestCase
{
	/**
	 * test_empty 
	 * 
	 * @access public
	 * @return void
	 */
	public function test_empty()
	{
		$stack = array();
		$this->assertEmpty($stack);
		
		return $stack;	
	}

	/**
	 * test_push 
	 * 
	 * @access public
	 * @depends test_empty
	 * @return void
	 */
	public function test_push(array $stack)
	{
		array_push($stack, 'foo');	
		$this->assertEquals('foo', $stack[count($stack) - 1]);
		$this->assertNotEmpty($stack);

		return $stack;
	}		

	/**
	 * test_pop 
	 * 
	 * @access public
	 * @depends test_push
	 * @return void
	 */
	public function test_pop(array $stack)
	{
		$this->assertEquals('foo', array_pop($stack));
		$this->assertEmpty($stack);

		return $stack;
	}		
}
