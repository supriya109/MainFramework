package com.crm.OraganizationTest;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtils;
import com.crm.ObjectRepository.ContactsPage;
import com.crm.ObjectRepository.CreateContactPage;
import com.crm.ObjectRepository.Homepage;
import com.crm.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationwithPropertyFileTest extends BaseClass {
	@Test
	public void createOrgTest() throws Throwable
	{
//Step 1: read data from property file 
				String lastName = eLib.readDataFromExcel("Sheet1", 1, 2)+jLib.getRandomNumber();
		
		//Step 2: launch the browser
		
		
		//Step 3: lon
       
		//Step 3: navigate to organizations link
		Homepage hp=new Homepage(driver);
		hp.ClickonContactLnk();
		
		
		ContactsPage cp=new ContactsPage(driver);
		cp.clickOnCreateContactImg();
		
		//Step 4: click on create Organization link I'm
		CreateContactPage ccp=new CreateContactPage(driver);
		ccp.createNewContact(lastName);
		
		
		
		
		
	}
  
  
  
}
