<?php
class incomplete_test extends PHPUnit_FrameWork_TestCase
{
	public function test_incomplete()	
	{
		$this->markTestIncomplete(
			'sssss'
		);
	}
}
