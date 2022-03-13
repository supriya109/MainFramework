package com.crm.ContactTest;

import static org.testng.Assert.assertEquals;

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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.GenericLibrary.BaseClass;
import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtils;
import com.crm.ObjectRepository.ContactsPage;
import com.crm.ObjectRepository.CreateContactInfoPage;
import com.crm.ObjectRepository.CreateContactPage;
import com.crm.ObjectRepository.Homepage;
import com.crm.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactTest extends BaseClass{
	@Test
	public void createContact() throws Throwable
	{
		
		String lastName = eLib.readDataFromExcel("Sheet1", 1, 4)+jLib.getRandomNumber();
	
		//Step 3: navigate to organizations link
		Homepage hp=new Homepage(driver);
		hp.ClickonContactLnk();
		String ExpData="Contacts";
		String ActData=driver.findElement(By.linkText("Contacts")).getText();
		Assert.assertEquals(ActData,ExpData);
		
		/*Step 4: Navigate to Organizations Link*/
		SoftAssert sa=new SoftAssert();
		ContactsPage cp=new ContactsPage(driver);
		cp.clickOnCreateContactImg();
		String ExpHeader="Creating New Contact";
		String ActHeader=driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		sa.assertEquals(ActHeader,ExpHeader);
		
		/*Step 6: enter mandatory fields and save*/
		CreateContactPage ccp=new CreateContactPage(driver);
		ccp.createNewContact(lastName);
		
		CreateContactInfoPage cip=new CreateContactInfoPage();
		String actName = cip.ContactNameInfo();
		Reporter.log(lastName+"lastName",true);
		
		sa.assertTrue(lastName.contains("abc"));
				
	}

}