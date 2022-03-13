package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPage {
@FindBy(name="user_name")
private WebElement userNameEdt;

@FindBy(name="user_password")
private WebElement passwordEdt;

@FindBy(id="submitButton")
private WebElement SubmitBtn;

public LoginPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
public WebElement getUserNameEdt() {
	return userNameEdt;
}
public WebElement getpasswordEdt() {
	return passwordEdt;
}

public WebElement getSubmitBtn() {
	return SubmitBtn;
}
public void loginToApp(String username,String password)
{
	userNameEdt.sendKeys(username);
	passwordEdt.sendKeys(password);
	SubmitBtn.click();
}

	
}
