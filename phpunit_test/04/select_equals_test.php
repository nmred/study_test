<?php
class select_equals_test extends PHPUnit_FrameWork_TestCase
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
		$this->assertSelectEquals('foo bar', 'Baz', false, $this->xml);	
	}

	/**
	 * test_presence_failure 
	 * 
	 * @access public
	 * @return void
	 */
	public function test_presence_failure()
	{
		$this->assertSelectEquals('foo bar', 'Bat', true, $this->xml);	
	}

	/**
	 * test_exact_count_failure 
	 * 
	 * @access public
	 * @return void
	 */
	public function test_exact_count_failure()
	{
		$this->assertSelectEquals('foo bar', 'Baz', 5, $this->xml);	
	}

	/**
	 * test_range_failure 
	 * 
	 * @access public
	 * @return void
	 */
	public function test_range_failure()
	{
		$this->assertSelectEquals('foo bar', 'Baz', array('>' => 6, '<' => 8), $this->xml);
	}
}
