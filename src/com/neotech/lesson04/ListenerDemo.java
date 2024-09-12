package com.neotech.lesson04;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ListenerDemo {

	@BeforeMethod
	public void before() {
		System.out.println("before method");
	}
	
	@AfterMethod
	public void after() {
		System.out.println("after method");
	}
	
	@Test
	public void test1() {
		System.out.println("this is test 1");
		//pass this test
		Assert.assertTrue(true);
	}
	
	
	@Test
	public void test2() {
		System.out.println("this is test 2");
		//fail this test
		Assert.assertTrue(false);
	}
}
