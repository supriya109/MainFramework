package com.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.ObjectRepository.Homepage;
import com.crm.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class POMPracticeForLogin {
@Test
public void pomPractice()
{
	WebDriverManager.firefoxdriver().setup();
	WebDriver driver=new FirefoxDriver();
	driver.get("http://localhost:8888");
	
	LoginPage lp=new LoginPage(driver);
	lp.loginToApp("admin","admin");
	
	Homepage hp=new Homepage(driver);
	hp.ClickonContactLnk();
	hp.signOutOfApp(driver);
}
}
