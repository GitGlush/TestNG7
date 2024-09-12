package com.neotech.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	private static Workbook book;
	private static Sheet sheet;
	
	
	/**
	 * this method will initialize a Workbook object given the file path
	 * @param filePath
	 */
	private static void openExcel(String filePath) {
		try {
			FileInputStream fis=new FileInputStream(filePath);
			book=new XSSFWorkbook(fis);
		} catch (IOException e) {
			e.printStackTrace();}}
	
	
	/**
	 * will load a sheet given a sheet name
	 * @param sheetName
	 */
	public static void loadSheet(String sheetName) {
		sheet=book.getSheet(sheetName);
	}
	
	
	/**
	 * this method will return a row count of the current sheet
	 * @return
	 */
	private static int rowCount() {
		return sheet.getPhysicalNumberOfRows();
	}
	
	
	/**
	 * this method will return the column count for the given row index in th current sheet
	 * @param rowIndex
	 * @return
	 */
	private static int colCount(int rowIndex) {
		return sheet.getRow(rowIndex).getLastCellNum();
	}
	
	
	/**
	 * this method will return the cell data given the row and column number as a String
	 * @param rowIndex
	 * @param colIndex
	 * @return
	 */
	private static String cellData(int rowIndex, int colIndex) {
		return sheet.getRow(rowIndex).getCell(colIndex).toString();
	}
	
	
	
	public static Object [][] excelIntoArray (String filePath, String sheetName){
		
		//open the file:filepath
		openExcel(filePath);
		
		//load the sheet: sheet name
		loadSheet(sheetName);
		
		//define the number of rows
		int rowNumber=rowCount();
		
		//define the number of columns
		int colNumber=colCount(0);
		
		//nested loop to go through each cell and get data from it
		
		Object [][] data=new Object[rowNumber-1][colNumber];
		for(int row=1;row<rowNumber;row++) //for each row (ignoring the first row(row with index 0)
		{
			for(int col=0; col<colNumber;col++) {//for eqch column of the row
				data[row-1][col]=cellData(row,col);
			}
		}
		return data;
	}
}
