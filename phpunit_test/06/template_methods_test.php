<?php
class template_methods_test extends PHPUnit_FrameWork_TestCase
{
	/**
	 * setUpBeforeClass 
	 * 
	 * @static
	 * @access public
	 * @return void
	 */
	public static function setUpBeforeClass()
	{
		fwrite(STDOUT, __METHOD__ . "\n");	
	}	

	/**
	 * setUp 
	 * 
	 * @access protected
	 * @return void
	 */
	protected function setUp()
	{
		fwrite(STDOUT, __METHOD__ . "\n");
	}

	/**
	 * assertPreConditions 
	 * 
	 * @access protected
	 * @return void
	 */
	protected function assertPreConditions()
	{
		fwrite(STDOUT, __METHOD__ . "\n");
	}

	/**
	 * test_one 
	 * 
	 * @access public
	 * @return void
	 */
	public function test_one()
	{
		fwrite(STDOUT, __METHOD__ . "\n");
		$this->assertTrue(true);
	}

	/**
	 * test_two 
	 * 
	 * @access public
	 * @return void
	 */
	public function test_two()
	{
		fwrite(STDOUT, __METHOD__ . "\n");
		$this->assertTrue(true);
	}

	/**
	 * assertPostCondition 
	 * 
	 * @access protected
	 * @return void
	 */
	protected function assertPostConditions()
	{
		fwrite(STDOUT, __METHOD__ . "\n");
	}

	/**
	 * tearDown 
	 * 
	 * @access protected
	 * @return void
	 */
	protected function tearDown()
	{
		fwrite(STDOUT, __METHOD__ . "\n");
	}

	/**
	 * tearDownAfterClass 
	 * 
	 * @static
	 * @access public
	 * @return void
	 */
	public static function tearDownAfterClass()
	{
		fwrite(STDOUT, __METHOD__ . "\n");	
	}

	/**
	 * onNotSuccessfulTest 
	 * 
	 * @param Exception $e 
	 * @access protected
	 * @return void
	 */
	protected function onNotSuccessfulTest(Exception $e)
	{
		fwrite(STDOUT, __METHOD__ . "\n");	
		throw $e;
	}
}
