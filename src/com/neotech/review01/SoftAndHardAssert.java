package com.neotech.review01;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAndHardAssert {

	@Test
	public void testHardAsser() {System.out.println("step1");
	System.out.println("step2");
	System.out.println("step3");
	
	String expectedAccount="Jacqueline";
	String actualAccount="Aaron";
	Assert.assertEquals("actualAccount","expectedAccount","The account is wrong");

	//after hard assert fails the test Method stops executing
	System.out.println("step4");
	
	}
	

@Test
public void testSoftAssert() {
	System.out.println("step1");
	SoftAssert soft=new SoftAssert();
	String expected="Ronaldo";
	String actual="Messi";
	
	soft.assertEquals(actual, expected);//this assertion will fail
	System.out.println("step2");
	
	soft.assertTrue(true);//this assertion will pass
	System.out.println("step3");
	
	//this assertAll() method will collect all soft assertions 
	//and will decide if the test method will pass or fail
	//if all assertions pass the test will pass
	//if one of the assertions fail-the test will fail
	soft.assertAll();
}

}
