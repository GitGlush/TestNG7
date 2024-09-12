package com.neotech.lesson03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;

public class AddEmployeeWithDataProvider extends CommonMethods {

	//add 3 employees using data provider
	//open chrome browser and navigate to Orange HRM website
	//login with valid credentials
	//navigate to add employee tab
	//add 3 different employees using data provider
	
	
	
	
	
	@Test(dataProvider="employees")
	public void addEmployee(String firstName, String lastName, String location) {
		//you can check if the data is coming properly from the data provider
		System.out.println(firstName+" "+lastName);
		
		//login
		sendText(driver.findElement(By.id("txtUsername")),ConfigsReader.getProperty("username"));
		sendText(driver.findElement(By.id("txtPassword")),"Neotech@123");
		click(driver.findElement(By.xpath("//button[text()='Login']")));
		wait(2);
		
		//navigate to pim
		click(driver.findElement(By.xpath("//span[contains(text(), 'PIM')]")));
		
		
		//click on add employee
		click(driver.findElement(By.id("menu_pim_addEmployee")));
		
		//send employee data
		sendText(driver.findElement(By.id("first-name-box")), firstName);
		sendText(driver.findElement(By.id("last-name-box")), lastName);
		selectDropDown(driver.findElement(By.id("location")),location);
		wait(5);
		//save employee
		click(driver.findElement(By.id("modal-save-button")));
		
		//validate employee is there(no need to search in the list just check the personal details after save)
		WebElement persDetails=driver.findElement(By.id("personal_details_tab"));
		if(persDetails.isDisplayed()) {System.out.println("the employee " + firstName+" "+lastName+" added successfully");}
	
	}
	
	@DataProvider(name="employees")
	public Object[][]employeeData (){
		//first name, last  name
		
		Object [][] data= {{"Viktoria","Hlushanina", "Canadian Regional HQ"},
				         //  {"John", "Travolta", "Canadian Regional HQ"},
				          // {"Robert", "DeNiro", "Canadian Regional HQ"}
				};
		
		//fill out the data 2d
		return data;
	}
}



