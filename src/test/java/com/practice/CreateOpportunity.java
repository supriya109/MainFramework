package com.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOpportunity extends BaseClass {
	@Test
	public void opportunity() throws Throwable
	{

	
	
	String OrgName = eLib.readDataFromExcel("Sheet1", 1, 2)+jLib.getRandomNumber();
	String campaignName = eLib.readDataFromExcel("Sheet1", 1, 3)+jLib.getRandomNumber();
	
	/*Step 2: launch the browser*/
	driver.findElement(By.linkText("Opportunities")).click();
	driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
	driver.findElement(By.xpath("//input[@name='potentialname']")).sendKeys(OrgName);
	WebElement ele = driver.findElement(By.xpath("//select[@name='related_to_type']"));
	Select sel =  new Select(ele);
	sel.selectByIndex(1);
	driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
	
	driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys("ENS");
	driver.findElement(By.xpath("//input[@type='button']")).click();
	
	driver.findElement(By.partialLinkText(OrgName)).click();
	
	WebElement ele1 = driver.findElement(By.xpath("//select[@name='leadsource']"));
	
	Select sel1=new Select(ele1);
	sel.selectByIndex(3);
	
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
	driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
	driver.findElement(By.xpath("//a[.='Sign Out']")).click();
	
	
	
	}
	
	
}
