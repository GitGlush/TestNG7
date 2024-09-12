package com.neotech.lesson03;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;

public class DataProviderDemo extends CommonMethods{

	//we added @BeforeMethod and @AfterMethod in BaseClass at the top of
	//setUp() and tearDown() methods directly. They alread apply
	//since I am extending the Common Methods
	//so no need to call them here again
	
	@Test(dataProvider="userData")
	public void LoginFunctionality(String userName, String password) {
		sendText(driver.findElement(By.id("txtUsername")),userName);
		sendText(driver.findElement(By.id("txtPassword")),password);
		
		click(driver.findElement(By.xpath("//button[text()='Login']")));
					}
	
	//to create data driven tests in TestNG we use @DataProvider annotation
	@DataProvider(name="userData")
		public Object [][] getData() {
		//1st test: Admin, Admin123 {"Admin","Admin123"}
		//2d test: Mona, Mona123    {"Mona", "Mona123"}
		//3d test: Nazli, Nazli123  {"Nazli", "Nazli123"}
		
		Object [][] credentials= 
			       {{"Admin","Admin123"},
					{"Mona", "Mona123"},
					{"Nazli", "Nazli123"}};
		
		return credentials;
	}
}
