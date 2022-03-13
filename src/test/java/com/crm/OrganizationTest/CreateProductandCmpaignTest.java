package com.crm.OrganizationTest;

import java.io.FileInputStream;
import java.util.List;
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
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtils;
import com.crm.ObjectRepository.CampaignInfoPage;
import com.crm.ObjectRepository.CampaignPage;
import com.crm.ObjectRepository.CreateCampaign;
import com.crm.ObjectRepository.Homepage;
import com.crm.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProductandCmpaignTest {
	
	private static final String CampaignType = null;

	@Test
	public void createOrgwithhealthcareTest() throws Throwable
	{
	WebDriverManager.chromedriver().setup();
	WebDriverManager.firefoxdriver().setup();
	
	/*read data*/
	PropertyFileUtility pLib = new PropertyFileUtility();
	JavaUtility jLib = new JavaUtility();
	ExcelFileUtility eLib = new ExcelFileUtility();
	WebDriverUtils wLib = new WebDriverUtils();
	
	/*Step 1: read all neccessary data*/
	String BROWSER = pLib.readDataFromPropertyFile("browser");
	String URL = pLib.readDataFromPropertyFile("url");
	String USERNAME = pLib.readDataFromPropertyFile("username");
	String PASSWORD = pLib.readDataFromPropertyFile("password");
	
	String campName = eLib.readDataFromExcel("Sheet2",1,2)+"_"+jLib.getRandomNumber();
	
	String campType = eLib.readDataFromExcel("Sheet2",1,4);

	/*Step 2: launch the browser*/
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
		System.out.println("invalid browser name");
	}
	
	wLib.maximizewindow(driver);
	wLib.waitForPageLoad(driver);
	driver.get(URL);
	
	LoginPage lp=new LoginPage(driver);
	lp.loginToApp(USERNAME, PASSWORD);

	
	//Step 3: navigate to organizations link
	Homepage hp=new Homepage(driver);
	hp.ClickonMoreLnk();
	hp.ClickonCampaignsLnk();
	
	CampaignPage cp=new CampaignPage(driver);
	cp.createCampaignImg();
	
	CreateCampaign ccp=new CreateCampaign(driver);
	ccp.createNewCamp(campName);
	
	CampaignInfoPage cip=new CampaignInfoPage();
	String Header = cip.CampaignNameInfo();
	
	if(Header.contains(campName))
	{
		System.out.println(Header +"------> organization created");
	}
	else
	{
		System.out.println("organization not created ");
	}
	
	}
}