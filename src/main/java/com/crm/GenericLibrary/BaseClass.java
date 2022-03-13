package com.crm.GenericLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.crm.ObjectRepository.Homepage;
import com.crm.ObjectRepository.LoginPage;

public class BaseClass {
	public PropertyFileUtility pLib = new PropertyFileUtility();
	public ExcelFileUtility eLib = new ExcelFileUtility();
	public WebDriverUtils wLib = new WebDriverUtils();
	public JavaUtility jLib = new JavaUtility();
	public DatabaseUtility dbLib=new DatabaseUtility();
	public WebDriver driver=null;
	
	public static WebDriver sDriver;
	
	
	@BeforeSuite(groups= ("smokesuite,regressionsuite"))
	public void connectDataBase()
	{
		//dbLib.connectToDb();
		Reporter.log("====db connected sucessfully===",true);
	}
	@BeforeClass(groups= ("smokesuite,regressionsuite"))
	//@Parameters("BROWSER")
	//@BeforeTest
	public void launchTheBrowser() throws Throwable
	{
		//read data from property
		String BROWSER = pLib.readDataFromPropertyFile("browser");
		String URL = pLib.readDataFromPropertyFile("url");
		
		//create runtime polymorphism
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else
			
		{
			System.out.println("invalid browser");
		}
		sDriver=driver;
		wLib.maximizewindow(driver);
		wLib.waitForPageLoad(driver);
		driver.get(URL);
		Reporter.log("=====browser launch succesfull=======",true);
	}
	@BeforeMethod(groups= ("smokesuite,regressionsuite"))
	public void login() throws Throwable
	{
		String USERNAME = pLib.readDataFromPropertyFile("username");
		String PASSWORD = pLib.readDataFromPropertyFile("password");
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		Reporter.log("login successful",true);
	}
		@AfterMethod(groups= ("smokesuite,regressionsuite"))
		public void logout()
		{
			Homepage hp = new Homepage(driver);
			hp.signOutOfApp(driver);
			Reporter.log("logout sucessfull",true);
		}
		@AfterClass(groups= ("smokesuite,regressionsuite"))
		//@AfterTest
		public void closeBrowser()
		{
			driver.quit();
			Reporter.log("browser closed");
		}
		@AfterSuite(groups= ("smokesuite,regressionsuite"))
		public void closeDb()
		{
			Reporter.log("====database closed=====");
		}
	}
	
