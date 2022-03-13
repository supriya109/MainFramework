package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtils;


public class CampaignPage extends WebDriverUtils {
	@FindBy(linkText="More")
	private WebElement MoreLnk;
	
	
	@FindBy(xpath="//img[@alt='Create Campaign...']")
	private WebElement createCampaignImg;
	
	//step2:Initialization
		public CampaignPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		//step3:Utilization
		public WebElement getcreateCampaignImg() {
			return createCampaignImg;
		}
		public WebElement getMoreLnk() {
			return MoreLnk;
		}
		//Business library
		public void createCampaignImg()
		{
			createCampaignImg.click();
		}

	}
