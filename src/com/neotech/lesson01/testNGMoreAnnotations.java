package com.neotech.lesson01;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testNGMoreAnnotations {

	@AfterTest
	public void afterTest() {System.out.println("after test");}
	
	@BeforeTest
	public void beforeTest() {System.out.println("before test");}
	
	@Test
	public void testOne() {System.out.println("test 1");}
	
	@Test
	public void testTwo() {System.out.println("test 2");}
	
	@BeforeClass
	public void beforeClass() {System.out.println("before class");}
	
	@AfterClass
	public void afterClass() {System.out.println("after class");}
	
	@BeforeMethod
	public void beforeMethod() {System.out.println("before method");}
	
	@AfterMethod
	public void afterMethod() {System.out.println("after method");}
	
	//before Test-doesnt mean before Test method, it means before test batch
	   //before class
	     //before method
	        //test case 1
	     //after method
	     //before method
	       //test case 2
	     //after method
	   //after class
	//after test
	
}
