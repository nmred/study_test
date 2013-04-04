<?php
class contains_only_instanceof_test extends PHPUnit_FrameWork_TestCase
{
	/**
	 * test_failure 
	 * 
	 * @access public
	 * @return void
	 */
	public function test_failure()
	{
		$this->assertContainsOnlyInstancesof('foo', array(new foo, new bar, new foo));	
	}	
}

class foo {}
class bar {}
