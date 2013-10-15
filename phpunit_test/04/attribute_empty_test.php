<?php
class attribute_empty extends PHPUnit_FrameWork_TestCase
{
	/**
	 * test_failure 
	 * 
	 * @access public
	 * @return void
	 */
	public function test_failure()
	{
		$this->assertAttributeEmpty('foo', new footest);	
	}

	/**
	 * test_failure_1 
	 * 
	 * @access public
	 * @return void
	 */
	public function test_failure_1()
	{
		$this->assertAttributeNotEmpty('foo1', new footest);
	}
}

class footest
{
	public $foo = 'sss';	

	protected $foo1 = null;
}
