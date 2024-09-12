package com.neotech.review01;

import org.testng.annotations.*;

public class TestParameters {

	@Test (priority=4, groups ="regression")
	public void testA() {System.out.println("running test method A");}
	
	@Test (priority=1, enabled=false, groups="regression")
	public void testB() {System.out.println("running test method B");}
	
	
	
}
