package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtils;

public class Organization extends WebDriverUtils  
{
	//step1:Declaration
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement createOrgLookUpImg;
	
	//step2:Initialization
	public Organization(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
//step3:Utilization
	public WebElement getCreateOrgLookUpImg() {
		return createOrgLookUpImg;
	}
	
	//Business library
	public void ClickOnCreateOrgImg()
	{
		createOrgLookUpImg.click();
	}

}
