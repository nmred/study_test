<?php
class select_regexp_test extends PHPUnit_FrameWork_TestCase
{
	/**
	 * setUp 
	 * 
	 * @access protected
	 * @return void
	 */
	protected function setUp()
	{
		$this->xml = new DOMDocument;
		$this->xml->loadXML('<foo><bar>Baz</bar><bar>Baz</bar></foo>');
	}	

	/**
	 * test_absence_failure 
	 * 
	 * @access public
	 * @return void
	 */
	public function test_absence_failure()
	{
		$this->assertSelectRegExp('foo bar', '/Ba.*/', false, $this->xml);
	}

	/**
	 * test_presence_failure 
	 * 
	 * @access public
	 * @return void
	 */
	public function test_presence_failure()
	{
		$this->assertSelectRegExp('foo bar', '/B[oe]z/', true, $this->xml);	
	}

	/**
	 * test_exact_count_failure 
	 * 
	 * @access public
	 * @return void
	 */
	public function test_exact_count_failure()
	{
		$this->assertSelectRegExp('foo bar', '/Ba.*/', 5, $this->xml);	
	}

	/**
	 * test_range_failure 
	 * 
	 * @access public
	 * @return void
	 */
	public function test_range_failure()
	{	
		$this->assertSelectRegExp('foo bar', '/Ba.*/', array('>' => 6, '<' => 8), $this->xml);
	}
}
