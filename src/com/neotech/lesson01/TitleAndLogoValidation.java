package com.neotech.lesson01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;

public class TitleAndLogoValidation extends CommonMethods{

	//url=https://hrm.neotechacademy.com
	
	//commenting them out since we made the setUp() and tearDown() as BeforeMethod and AfterMethod and made
	//them in Base Class always run
//	@BeforeMethod
//	public void openAndNavigate() {
//		setUp();
//	}
//	
//	
//	@AfterMethod
//	public void quitBrowser() {
//		tearDown();
//	}
	
	@Test(priority=1, groups="smoke")
	public void titleValidation() throws Exception {
		String expectedTitle="OrangeHR";//intentionally failing this test, should be orangeHRM
		String actualTitle=driver.getTitle();
		if(expectedTitle.equals(actualTitle))
		{System.out.println("title validation passed");}
		else {System.out.println("title validation fails. The title is "+actualTitle);}
		throw new Exception();
		//later on we will use assertions
		//but for now we can show it as failed by throwing an exception
		}
	
		
	@Test
		public void logoValidation () {
			WebElement logo=driver.findElement(By.xpath("//div[@class='orangehrm-logo']/img"));
			if(logo.isDisplayed()) {
				System.out.println("logo validation passed");
			}
			else {System.out.println("logo validation failed");}
			}
	
	
	@Test
	public void loginValidation() {
		sendText(driver.findElement(By.id("txtUsername")),ConfigsReader.getProperty("username"));
		sendText(driver.findElement(By.id("txtPassword")),ConfigsReader.getProperty("password"));
	click(driver.findElement(By.xpath("//button")));
		
	WebElement userImg=driver.findElement(By.xpath("//div[@id='menu-profile']/img"));
	if(userImg.isDisplayed()) {
		System.out.println("login validation is passed");
	}
	else {System.out.println("login validation is failed");}
	
	}
	
	
	
	
	
	
	
	
	
	
}
