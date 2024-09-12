package com.neotech.lesson02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.neotech.utils.CommonMethods;

public class AssertDemo extends CommonMethods{

	@BeforeMethod
	public void openAndNavigate() {setUp();}
	
	@AfterMethod
	public void quitBrowser() {tearDown();}
	
	@Test 
	public void titleValidation () {
		String expectedTitle="OrangeHRM";
		String actualTitle=driver.getTitle();
		
		//1st way
		//Assert.assertEquals(expectedTitle, actualTitle);
		
		//2d way
		Assert.assertEquals(expectedTitle, actualTitle, "Title does not match!");
		//if Assertion fails anything after will not run
		System.out.println("this is the end of test validation test");
	}
	
	
	@Test
	public void logoValidation() {
		WebElement logo=driver.findElement(By.xpath("//div[@class='orangehrm-logo']/img"));
		boolean logoExists=logo.isDisplayed();
		
		//SET IT TO FALSE ON PURPOSEbvfor failing the test
		//logoExists=false;
		
		//1st way
		//Assert.assertEquals(logoExists, true);
		
		//2d way
		Assert.assertEquals(logoExists, true, "Logo is not displayed!");
		
		//3d way
		Assert.assertTrue(logoExists, "Logo is not displayed!");
		
		
		
	}
	
	
	
	
}
