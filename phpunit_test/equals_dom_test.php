<?php
class equals_dom_test extends PHPUnit_FrameWork_TestCase
{
	/**
	 * test_failure 
	 * 
	 * @access public
	 * @return void
	 */
	public function test_failure()
	{
		$expected = new DOMDocument;
		$expected->loadXML('<foo><bar/></foo>');

		$actual = new DOMDocument;
		$actual->loadXML('<bar><foo/></bar>');

		$this->assertEquals($expected, $actual);
	}	
}
