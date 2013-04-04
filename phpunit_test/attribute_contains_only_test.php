<?php
class attribute_contains_only_test extends PHPUnit_FrameWork_TestCase
{
	public function test_failure()
	{
		$this->assertAttributeContainsOnly('protected', '__file', 'test__1');	
	}	
}

class test__1
{
	public $testarr ="sas";	

	protected $__file = 'dsds';
}
