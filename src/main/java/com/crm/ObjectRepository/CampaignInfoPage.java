package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignInfoPage {
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement headerText;

	public void createCampaignInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getHeaderText() {
		return headerText;
	}

	public String CampaignNameInfo()
	{
		String CampaignInfo = headerText.getText();
		return CampaignInfo;
	}
}
