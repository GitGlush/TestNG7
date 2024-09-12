package com.neotech.lesson02;

import org.testng.annotations.Test;

public class EnableAndDisable {
	@Test(priority = 1)
	public void firstTest() throws Exception {System.out.println("firstTest");
	throw new Exception();}
	
	@Test(priority = 2, enabled=true)
	public void secondTest() {System.out.println("secondTest");}
	
	@Test(dependsOnMethods ={"firstTest","secondTest"})
	public void thirdTest() {System.out.println("thirdTest");}
	
	@Test (dependsOnMethods="firstTest")
	public void fourthTest() {System.out.println("fourthTest");}
	
	
	
}
