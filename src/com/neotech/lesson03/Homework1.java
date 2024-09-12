package com.neotech.lesson03;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.common.io.Files;
import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;
import com.neotech.utils.ExcelUtility;

public class Homework1 extends CommonMethods{
//	Open chrome browser
//	Go to "https://hrm.neotechacademy.com/"
//	Login to the application
//	Add 3 different Employees and Create Login Details by providing:
//	First Name
//	Last Name
//	Username
//	Password
//	Verify Employee has been added successfully and take screenshot 
//	(you must have 3 different screenshots)
//	Close the browser
//	Specify a group for this test case, add it into specific suite and 
//	execute from the xml file.
	
	@Test (dataProvider="excelData")
	public void addEmployee(String firstName,String lastName,String location, String userName, String password) {
		sendText(driver.findElement(By.id("txtUsername")),ConfigsReader.getProperty("username"));
		sendText(driver.findElement(By.id("txtPassword")),ConfigsReader.getProperty("password"));
		click(driver.findElement(By.xpath("//button[text()='Login']")));
		wait(2);
		
		   click(driver.findElement(By.xpath("//span[contains(text(), 'PIM')]")));
		   click(driver.findElement(By.id("menu_pim_addEmployee")));
		   
		   waitForVisibility(By.id("first-name-box"));
		   sendText(driver.findElement(By.id("first-name-box")), firstName);
		   sendText(driver.findElement(By.id("last-name-box")), lastName);
		   
		   //get the employee ID to verify that the mployee was added
		   String ID=driver.findElement(By.id("employeeId")).getAttribute("value");
		   
		   
		   selectDropDown(driver.findElement(By.id("location")),location);
		   wait(2);
		   
		   click(driver.findElement(By.xpath("//div[@class='custom-control custom-switch']")));
		  
		   wait(2);
		   sendText(driver.findElement(By.id("username")),userName);
		   wait(3);
		   sendText(driver.findElement(By.id("password")),password);
		   sendText(driver.findElement(By.id("confirmPassword")), password);
		   wait(2);
		   click(driver.findElement(By.id("modal-save-button")));
		   
		   waitForVisibility(By.id("firstName"));
		  String actualEmpID=driver.findElement(By.id("employeeId")).getAttribute("value");
		   Assert.assertEquals(actualEmpID, ID, "Employee ID's do not match");
	
//	TakesScreenshot ts=(TakesScreenshot) driver;
//	File sourse=ts.getScreenshotAs(OutputType.FILE);
//	
//		try {
//			Files.copy(sourse, new File("screenshots/"+firstName+".png"));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	
		   
		   //2d way
		   String fullName=firstName+" "+lastName;
		   takeScreenShot(fullName);
	
	}
	
	
	
//	@DataProvider(name="employees")
//	public Object[][] employeeData () {
//		Object [][]data= {{"Johny","Depp","Canadian Regional HQ","JohnyDepp","leo@1234567"},
//				            {"Jake","Jillenholl","Canadian Development Center","JakeJillen","al1@234567"},
//				            {"Maggy","Jillenholl","Canadian Development Center","MaggyJillen","rob@1234567"}
//				};
//		return data;
//	}
	
	
	@DataProvider (name="excelData")
	public Object[][]getExcelData(){
		String filePath=System.getProperty("user.dir")+"/testData/emp.xlsx";
		String sheetName="Employee";
		
		//read the data from the excel file
		return ExcelUtility.excelIntoArray(filePath, sheetName);
	}
	
	

	
	
}
