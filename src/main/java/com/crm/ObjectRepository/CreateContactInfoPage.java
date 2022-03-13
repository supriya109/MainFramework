package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactInfoPage 
{
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement headerText;

	public void createContactInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getHeaderText() 
	{
		return headerText;
	}
	
	public String ContactNameInfo()
	{
		String ContactInfo = headerText.getText();
		return ContactInfo;
	}
	}
