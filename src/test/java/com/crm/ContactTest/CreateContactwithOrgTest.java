package com.crm.ContactTest;

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
import com.crm.ObjectRepository.OrganizationInfoPage;

public class CreateContactwithOrgTest extends BaseClass {
	@Test
	public void createContact() throws Throwable
	{
		/*generate random number*/
		
		String OrgName = eLib.readDataFromExcel("Sheet1", 1, 2)+jLib.getRandomNumber();
		String indType1 = eLib.readDataFromExcel("Sheet1", 1, 3);
		
		/*Step 4: Navigate to Organizations Link*/
		Homepage hp=new Homepage(driver);
		hp.ClickonOrgLnk();
		
		//step5:click on create Organization btn
		Organization op=new Organization(driver);
		op.ClickOnCreateOrgImg();
		
		/*Step 6: enter mandatory fields and save*/
		CreateOrgPage cop=new CreateOrgPage(driver);
		cop.createNewOrg(OrgName,indType1);
		
		/*Step 7: verification*/
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String actHeader = oip.OrgNameInfo();
		if(actHeader.contains(OrgName))
		{
			System.out.println(actHeader +"------> organization created");
		}
		else
		{
			System.out.println("organization not created ");
		}
	}
}