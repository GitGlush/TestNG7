package com.neotech.review01;

import org.testng.annotations.*;

public class DemoAnnotations {
	
	@Test (groups= {"smoke","regression"})
	public void test1() {System.out.println("review test 1");}
	
	
	@Test(groups={"regression"})
	public void test2() {System.out.println("review test 2");}
	
	@BeforeMethod
	public void beforeM() {System.out.println("Just before the test method");}

	@AfterMethod
	public void afterM() {System.out.println("Just after the test method");}

	@BeforeTest
	public void beforeT() {System.out.println("Just before the Functuality test");}

	@AfterTest
	public void afterT() {System.out.println("Just after the Functuality test");}
	
	
//	@BeforeTest
//	
////	@BeforeMethod
////	test1()	
////	@AfterMethod
////	
////	@BeforeMethod
////	test2()
////	@AfterMethod
//	
//	@AfterTest
	
	
	
}
