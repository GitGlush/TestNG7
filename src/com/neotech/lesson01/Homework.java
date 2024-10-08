package com.neotech.lesson01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;

public class Homework extends CommonMethods{
//	Homework 1: HRMS Application Negative Login: 
//
//	    1. Open chrome browser
//	    2. Go to "https://hrm.neotechacademy.com/"
//	    3. Enter valid username
//	    4. Leave password field empty
//	    5. Verify error message with text "Password cannot be empty" is displayed.
	
	@BeforeMethod
	public void openAndNavigate() {
		setUp();
	}
	
	
	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}
	
	@Test
	public void applicationNegativeLogin()  {
		sendText(driver.findElement(By.id("txtUsername")),ConfigsReader.getProperty("username"));
		sendText(driver.findElement(By.id("txtPassword")),"");
		click(driver.findElement(By.xpath("//button[text()='Login']")));
		wait(2);
		
	    String expectedMessage="Password cannot be empty";
			WebElement currentMessage=driver.findElement(By.id("txtPassword-error"));
			if(currentMessage.getText().equals(expectedMessage)) {
				System.out.println("test passed");
			}
			else {System.out.println("test failed");}
			
	}
	
	
	@Test
	public void loginValidation() {
		sendText(driver.findElement(By.id("txtUsername")),ConfigsReader.getProperty("username"));
		sendText(driver.findElement(By.id("txtPassword")),ConfigsReader.getProperty("password"));
		click(driver.findElement(By.xpath("//button[text()='Login']")));
		wait(2);
	}
	
}
