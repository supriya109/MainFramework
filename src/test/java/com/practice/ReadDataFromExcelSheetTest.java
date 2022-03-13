package com.practice;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class ReadDataFromExcelSheetTest {
@Test
public void ReadDataFromExcel() throws Throwable
{
	FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Data.xlsx");
	Workbook wb= WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet("Sheet1");
	Row ro = sh.getRow(0);
	Cell ce = ro.getCell(0);
	String val = ce.getStringCellValue();
	System.out.println(val);
	
}
}
