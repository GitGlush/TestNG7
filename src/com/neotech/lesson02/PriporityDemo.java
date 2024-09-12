package com.neotech.lesson02;

import org.testng.annotations.Test;

public class PriporityDemo {

	@Test(priority = 1)
	public void firstTest() {System.out.println("firstTest");}
	
	@Test(priority = 2)
	public void secondTest() {System.out.println("secondTest");}
	
	@Test//by default this will be priority 0-->will run the first one
	public void thirdTest() {System.out.println("thirdTest");}
	
	@Test(priority = 4)
	public void fourthTest() {System.out.println("fourthTest");}
	
	
	
	
	
	
	
	
}
