package com.neotech.review01;

import org.testng.Assert;
import org.testng.annotations.*;

public class DependsOnClass {

	@Test
	public void firstTest() {System.out.println("the first test method");
	Assert.assertEquals("a", "b");}//we are failing this test on purpose
	
	@Test (dependsOnMethods="firstTest")
	public void secondTest() {System.out.println("the second test method");}
	
	//the first test will be executed
	// the first test will fail
	//the second test will be skipped
	//result: one test fails, one test is skipped
}
