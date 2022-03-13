package com.crm.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtils;

public class CreateContactPage extends WebDriverUtils {


//step1: Declaration
	@FindBy(name="lastname")
	private WebElement lastNameEdt;
	
	@FindBy(xpath="//input[@name='account_name']")
	private WebElement contactNameLookUpImg;
	
	@FindBy(name="leadSource")
	private WebElement leadsourceDropDown;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	@FindBy(name="search_text")
	private WebElement searchEdt;
	
	@FindBy(name="search")
	private WebElement SearchBtn;
	
	//initilization
	public  CreateContactPage(WebDriver driver)

	{
		PageFactory.initElements(driver, this);
	}
	

	//utilization
	public WebElement getLastNameEdt()
	{
		return lastNameEdt;
	}
	

	public WebElement getcontactNameLookUpImg() {
		return contactNameLookUpImg;
	}

	public WebElement getLeadsourceDropDown() {
		return leadsourceDropDown;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}

	//business library
	public void createNewContact(String lastName)
	{
		lastNameEdt.sendKeys(lastName);
		SaveBtn.click();
	}
	public void createNewContact(String lastName,String leadSource)
	{
		lastNameEdt.sendKeys(lastName);
		select(leadSource,leadsourceDropDown);
		SaveBtn.click();
	}
	
	public void createNewContact(WebDriver driver,String lastName,String OrgName)
	{
		lastNameEdt.sendKeys(lastName);
		WebElement contctNameLookUpImg = null;
		contctNameLookUpImg.click();
		switchToWindow(driver, "Accounts");
		searchEdt.sendKeys(OrgName);
		SearchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+OrgName+"']")).click();
		switchToWindow(driver, "Contacts");
		SaveBtn.click();
	}
	
	
}
