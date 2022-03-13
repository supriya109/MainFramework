package com.crm.OrganizationTest;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtils;
import com.crm.ObjectRepository.CreateOrgPage;
import com.crm.ObjectRepository.Homepage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.Organization;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationTest extends BaseClass {
	@Test
	public void createOrgTest() throws Throwable
	{
		
		String Org = eLib.readDataFromExcel("Sheet1", 1, 2)+jLib.getRandomNumber();

		
		/*Step 3: login to application*/
		Homepage hp=new Homepage(driver);
		hp.ClickonOrgLnk();
		
		Organization op=new Organization(driver);
		op.ClickOnCreateOrgImg();
		
		CreateOrgPage cop=new CreateOrgPage(driver);
		cop.createNewOrg(Org);
		/*Step 7: logout of application*/
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		
		
		/*Step 8: close the browser*/
		driver.quit();
}
}