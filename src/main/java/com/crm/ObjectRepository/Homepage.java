package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtils;

public class Homepage extends WebDriverUtils {
	@FindBy(linkText="Organizations")
	private WebElement OrganizationLnk;
	
	@FindBy(linkText="Contacts")
	private WebElement ContactsLnk;
	
	@FindBy(linkText="Opportynities")
	private WebElement OpportunitiesLnk;
	
	@FindBy(linkText="Products")
	private WebElement ProductsLnk;
	
	@FindBy(linkText="More")
	private WebElement MoreLnk;
	
	
	@FindBy(linkText="Campaigns")
	private WebElement CampaignsLnk;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement signOutLnk;
	
	
	
	public  Homepage(WebDriver driver)
	{
	PageFactory.initElements(driver, this);	
	}
	
public WebElement getOrganizationLnk()
{
	return OrganizationLnk;
}
public WebElement getContactsLnk() {
	return ContactsLnk;
}
public WebElement getOpportunitiesLnk()
{
	return OpportunitiesLnk;
}
public WebElement getMoreLnk() {
	return MoreLnk;
}
public WebElement getCampaignsLnk() {
	return CampaignsLnk;
}
public WebElement getAdministratorLnk() {
	return administratorImg;
}
public WebElement getSignOutLnk() {
	return signOutLnk;
}
public void ClickonOrgLnk() {
	OrganizationLnk.click();
	
}
public WebElement getProductsLnk() {
	return ProductsLnk;
}
public WebElement getAdministratorImg() {
	return administratorImg;
}
public void ClickonContactLnk()
{
	ContactsLnk.click();
}
public void ClickonMoreLnk()
{
	MoreLnk.click();
}
public void ClickonCampaignsLnk()
{
	CampaignsLnk.click();
}
public void signOutOfApp(WebDriver driver)
{
	mouseHover(driver,administratorImg);
	signOutLnk.click();
}
}
