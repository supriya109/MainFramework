package com.crm.GenericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {

	public String readDataFromExcel(String SheetName,int rowNo,int cellNo) throws Throwable, InvalidFormatException, IOException
	{
		FileInputStream fis=new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		Row ro = sh.getRow(rowNo);
		Cell cel = ro.getCell(cellNo);
		String value1 = cel.getStringCellValue();
		return value1;
	}
	
	public void writeDataIntoExcel(String SheetName,int rowNo,int cellNo,String value) throws Throwable
	{
		FileInputStream fis=new FileInputStream(IPathConstants.ExcelPath);
        Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		Row ro = sh.getRow(rowNo);
		Cell cel = ro.getCell(cellNo);
		cel.setCellValue(value);
		FileOutputStream fos=new FileOutputStream(IPathConstants.ExcelPath);
		wb.write(fos);
}
	public int getRowCount(String SheetName) throws Throwable
	{
		FileInputStream fis=new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		int ro = sh.getLastRowNum();
		return ro;
		
	}
	public Object[][] readmultipleDataFromExcel(String SheetName) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		int lastRow = sh.getLastRowNum();
		int lastCell = sh.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[lastRow][lastCell];
		
		for(int i = 0;i<lastRow;i++)
		{
			for(int j=0;j<lastCell;j++)
			{
				data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		
		return data;
	
	}
	}
