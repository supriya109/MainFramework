package com.Organization;

import java.io.FileInputStream;
import java.util.Properties;
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
import org.testng.annotations.Test;

import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrgWithBilling {
	@Test
	public void Createshipping() throws Throwable
	{
		WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();
		PropertyFileUtility pLib = new PropertyFileUtility();
		JavaUtility jLib = new JavaUtility();
		ExcelFileUtility eLib = new ExcelFileUtility();
		WebDriverUtils wLib = new WebDriverUtils();
		
		/*Step 1: read all neccessary data*/
		//read data from property file
		String BROWSER = pLib.readDataFromPropertyFile("browser");
		String URL = pLib.readDataFromPropertyFile("url");
		String USERNAME = pLib.readDataFromPropertyFile("username");
		String PASSWORD = pLib.readDataFromPropertyFile("password");
		String ShippingAd = eLib.readDataFromExcel("Sheet1", 1, 2)+jLib.getRandomNumber();

		
		WebDriver driver=null;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("invalid browser");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Organizations")).click();
		
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		driver.findElement(By.xpath("//textarea[@name='ship_street']")).sendKeys(ShippingAd);
		WebElement ele = driver.findElement(By.xpath("//b[.='Copy Billing address']"));
		boolean Enabled = ele.isEnabled();
			
			if(Enabled)
			{
				System.out.println("CopyBilling Address is enabled");
			}
				else
				{
					System.out.println("Billing Adress is disabled");
				}
			}

		
		
	}


