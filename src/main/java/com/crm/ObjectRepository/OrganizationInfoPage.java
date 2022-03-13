package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
@FindBy(xpath="//span[@class='dvHeaderText']")
private WebElement headerText;

public OrganizationInfoPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

public WebElement getHeaderText() {
	return headerText;
}

public String OrgNameInfo()
{
	String OrgInfo = headerText.getText();
	return OrgInfo;
}
}
