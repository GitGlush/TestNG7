package com.neotech.review01;

import org.testng.annotations.*;

public class GroupsDemo {

	@Test (groups="smoke")
	public void smokeTest() {System.out.println("smoke test");}
	
	@BeforeMethod (alwaysRun=true)
	public void beforeSmokeTest() {System.out.println("just before smoke test");}
}
