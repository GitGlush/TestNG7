package com.neotech.review01;

import org.testng.annotations.*;
import org.testng.annotations.Test;

import com.neotech.utils.ExcelUtility;

public class DataDrivenTest {

	@Test(dataProvider="data2")
	public void loginTest(String name, String company, String jobPosition) {
		System.out.println("----------------");
		System.out.println(name+" "+company);
		System.out.println("he/she works as "+jobPosition);
	}

    //@DataProvider (name="data1")
    public Object[][] createData() {
    	Object [][] data= {{"Paul","Neotech","student"},
    			          {"Fasry","Google","QA"},
    			          {"Umut","Facebook","Scrum Master"}};
    	return data;
    }
    
    @DataProvider (name="data2")
    public Object[][] cteateFromExcel(){
    	String filePath=System.getProperty("user.dir")+"/testData/Employees.xlsx";
    	String sheet="Position";
    	return ExcelUtility.excelIntoArray(filePath,sheet);
    	
    	
    	}

}
