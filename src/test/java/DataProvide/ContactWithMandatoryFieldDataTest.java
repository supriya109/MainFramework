package DataProvide;
import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.chrome.ChromeDriver;
		import org.openqa.selenium.firefox.FirefoxDriver;
		import org.testng.Reporter;
		import org.testng.annotations.DataProvider;
		import org.testng.annotations.Test;

		import com.crm.GenericLibrary.ExcelFileUtility;
		import com.crm.GenericLibrary.JavaUtility;
		import com.crm.GenericLibrary.PropertyFileUtility;
		import com.crm.GenericLibrary.WebDriverUtils;
import com.crm.ObjectRepository.ContactsPage;
import com.crm.ObjectRepository.CreateContactInfoPage;
import com.crm.ObjectRepository.CreateContactPage;
import com.crm.ObjectRepository.CreateOrgPage;
		import com.crm.ObjectRepository.Homepage;
		import com.crm.ObjectRepository.LoginPage;
		import com.crm.ObjectRepository.Organization;
		import com.crm.ObjectRepository.OrganizationInfoPage;
		import com.crm.OraganizationTest.CreateOrganizationTest;

import io.github.bonigarcia.wdm.WebDriverManager;

		public class ContactWithMandatoryFieldDataTest {
		
				
				//Create Obj for all utilities
				PropertyFileUtility pLib = new PropertyFileUtility();
				ExcelFileUtility eLib = new ExcelFileUtility();
				WebDriverUtils wLib = new WebDriverUtils();
				JavaUtility jLib = new JavaUtility();
				
				@Test(dataProvider = "testData")
				public void contactWithMandatoryFieldDataTest(String lastName) throws Throwable
				{
					WebDriverManager.chromedriver().setup();
					
					//read data 
					String BROWSER = pLib.readDataFromPropertyFile("browser");
					String URL = pLib.readDataFromPropertyFile("url");
					String USERNAME = pLib.readDataFromPropertyFile("username");
					String PASSWORD = pLib.readDataFromPropertyFile("password");
					
					String lastName1 = lastName+jLib.getRandomNumber();
					
					//launch the application
					WebDriver driver = null;
					if(BROWSER.equalsIgnoreCase("chrome"))
					{
						driver = new ChromeDriver();
					}
					else if(BROWSER.equalsIgnoreCase("FIREFOX"))
					{
						driver = new FirefoxDriver();
					}
					else
					{
						System.out.println("invalid browser");
					}
					
					wLib.maximizewindow(driver);
					wLib.waitForPageLoad(driver);
					driver.get(URL);
					
					//login to application
					LoginPage lp = new LoginPage(driver);
					lp.loginToApp(USERNAME, PASSWORD);
					Reporter.log("login successful",true);
					
					//navigate to organization
					Homepage hp = new Homepage(driver);
					hp.ClickonContactLnk();
					Reporter.log("navigated to contact link",true);
					
					//create Org
					ContactsPage cp=new ContactsPage(driver);
					cp.clickOnCreateContactImg();
					Reporter.log("click on create contact link",true);
					
					//create new org
					CreateContactPage ccp=new CreateContactPage(driver);
					
					ccp.createNewContact(lastName);
					Reporter.log("create org with insustry type",true);
					
					//validate
					CreateContactInfoPage ccip=new CreateContactInfoPage();
					String actHeader = ccip.ContactNameInfo();
					if (actHeader.contains(lastName)) {
						System.out.println("passed");
					}
					else
					{
						System.out.println("failed");
					}
					Reporter.log("verification successful",true);		
					
					//logout
					hp.signOutOfApp(driver);
					
					driver.quit();
				}
				
				@DataProvider(name = "testData")
				public Object[][] getData() throws Throwable
				{
					Object[][] data = eLib.readmultipleDataFromExcel("Sheet3");
					return data;
				}
		}



