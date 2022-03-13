package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtils;

public class CreateOrgPage extends WebDriverUtils {
@FindBy(name="accountname")
private WebElement OrgNameEdt;

@FindBy(name="industry")
private WebElement IndustryDropDown;

@FindBy(name="accounttype")
private WebElement typeDropDown;

@FindBy(xpath="//input[@title='Save [Alt+S]']")
private WebElement saveBtn;

public CreateOrgPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

public WebElement getOrgNameEdt() {
	return OrgNameEdt;
}

public WebElement getIndustryDropDown() {
	return IndustryDropDown;
}

public WebElement getTypeDropDown() {
	return typeDropDown;
}

public WebElement getSaveBtn() {
	return saveBtn;
}
public void createNewOrg(String orgName)
{
	OrgNameEdt.sendKeys(orgName);
	saveBtn.click();
	
}
public void createNewOrg(String orgName,String indType1)
{
	OrgNameEdt.sendKeys(orgName);
	select(indType1,IndustryDropDown);
	
	saveBtn.click();
}
public void createNewOrg(String orgName,String indType,String type)
{
	OrgNameEdt.sendKeys(orgName);
	select(indType,IndustryDropDown);
	select(type,typeDropDown);
	saveBtn.click();
}
}

