package com.crm.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtils;

public class CreateCampaign extends WebDriverUtils {
	@FindBy(name="campaignname")
	private WebElement CampNameEdt;
	
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement ProductLookUpPage;
	
	@FindBy(name="search_text")
	private WebElement Searchtxt;
	
	@FindBy(name="search")
	private WebElement Searchbtn;
	
	
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public CreateCampaign(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCampNameEdt() {
		return CampNameEdt;
	}

	
	public WebElement getProductLookUpPage() {
		return ProductLookUpPage;
	}

	public WebElement getSearchtxt() {
		return Searchtxt;
	}

	public WebElement getSearchbtn() {
		return Searchbtn;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
public void createNewCamp(String campName)
{
	CampNameEdt.sendKeys(campName);
	saveBtn.click();
}

public void createNewCamp(WebDriver driver,String campName,String product,String prodname)
{
	CampNameEdt.sendKeys(campName);
	ProductLookUpPage.click();
	switchToWindow(driver, product);
	Searchtxt.sendKeys(prodname);
	driver.findElement(By.xpath("//a[.='']"));
	saveBtn.click();
	saveBtn.click();
}


}


