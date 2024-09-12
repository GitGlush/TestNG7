package com.neotech.lesson01;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGAnnotations {

	@Test
	public void test1() {System.out.println("this is test 1");}
	
	@Test
	public void test2() {System.out.println("this is test 2");}
	
	@BeforeMethod
	public void beforeMethod() {System.out.println("this method runs before test methods");}
	
	@AfterMethod
	public void afterMethod() {System.out.println("this method runs after test methods");}
	
	@Test
	public void test3() {System.out.println("this is test 3");}
	
	
	//Expectation
	//before method
	//test1
	//test2
	//test3
	//afterMethod
	
	
	
	
}
