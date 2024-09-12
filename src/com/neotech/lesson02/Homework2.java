package com.neotech.lesson02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;

public class Homework2 extends CommonMethods{
//	HW2: OrangeHRM Add Employee:
//
//	    Open chrome browser
//	    Go to "https://hrm.neotechacademy.com/"
//	    Login into the application
//	    Click on Add Employee
//	    Verify labels: Employee Full Name*, Employee Id, Location* are displayed
//	    Provide Employee First and Last Name
//	    Select a Location
//	    Verify Employee has been added successfully
//	    Close the browser
	
	
	
	@Test
	public void test() {
	sendText(driver.findElement(By.id("txtUsername")),ConfigsReader.getProperty("username"));
	sendText(driver.findElement(By.id("txtPassword")),"Neotech@123");
	click(driver.findElement(By.xpath("//button[text()='Login']")));
	wait(2);
	
    //Click on Add Employee
	click(driver.findElement(By.xpath("//span[contains(text(), 'PIM')]")));
	click(driver.findElement(By.id("menu_pim_addEmployee")));
	
	//verify labels
	boolean actualEmployee=driver.findElement(By.xpath("//label[text()='Employee Full Name']")).isDisplayed();
	Assert.assertEquals(actualEmployee, true);
	
	boolean actualID=driver.findElement(By.xpath("//label[text()='Employee Id']")).isDisplayed();
	Assert.assertEquals(actualID, true);
	
	boolean actualLocation=driver.findElement(By.xpath("//label[text()='Location']")).isDisplayed();
	Assert.assertEquals(actualLocation, true);
	
	
    //Provide Employee First and Last Name
	sendText(driver.findElement(By.id("first-name-box")),"Leonardo");
	sendText(driver.findElement(By.id("last-name-box")),"DiCaprio");
	
    //Select a Location
	Select location=new Select(driver.findElement(By.id("location")));
	location.selectByVisibleText("Canadian Development Center");

    //Verify Employee has been added successfully
	click(driver.findElement(By.id("modal-save-button")));
	
	
	WebElement savedDetails=driver.findElement(By.xpath("//h4[text()='Personal Details']"));
	if(savedDetails.isDisplayed()) {System.out.println("Employee has been added successfully");}
	
	System.out.println("the employee added successfully");
	
	}
	
	
		
	
}
