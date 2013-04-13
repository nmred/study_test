<?php
class equal_xml_structure_test extends PHPUnit_FrameWork_TestCase
{
	/**
	 * test_failure_with_different_node_names 
	 * 
	 * @access public
	 * @return void
	 */
	public function test_failure_with_different_node_names()
	{
		$expected = new DOMElement('foo');
		$actual = new DOMElement('bar');
		
		$this->assertEqualXMLStructure($expected, $actual);	
	}	

	/**
	 * test_failure_with_different_node_attributes 
	 * 
	 * @access public
	 * @return void
	 */
	public function test_failure_with_different_node_attributes()
	{
		$expected = new DOMDocument;
		$expected->loadXML('<foo bar="true" />');

		$actual = new DOMDocument;
		$actual->loadXML('<foo/>');
		
		$this->assertEqualXMLStructure($expected->firstChild, $actual->firstChild, true);	
	}

	/**
	 * test_failure_with_difference_children_count 
	 * 
	 * @access public
	 * @return void
	 */
	public function test_failure_with_difference_children_count()
	{
		$expected = new DOMDocument;
		$expected->loadXML('<foo><bar/><bar/><bar/></foo>');

		$actual = new DOMDocument;
		$actual->loadXML('<foo><bar/></foo>');
		
		$this->assertEqualXMLStructure($expected->firstChild, $actual->firstChild);	
	}

	/**
	 * test_failure_with_difference_children 
	 * 
	 * @access public
	 * @return void
	 */
	public function test_failure_with_difference_children()
	{
		$expected = new DOMDocument;
		$expected->loadXML('<foo><bar/><bar/><bar/><bar/></foo>');

		$actual = new DOMDocument;
		$actual->loadXML('<foo><baz/><baz/><baz/></foo>');
		
		$this->assertEqualXMLStructure($expected->firstChild, $actual->firstChild);	
	}
}
