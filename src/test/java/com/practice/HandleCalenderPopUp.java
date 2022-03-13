package com.practice;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class HandleCalenderPopUp {
@Test
public void calender()
{
	String date="12";
	String monthAndYear="September 2022";
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get("https://www.makemytrip.com/");
	
	Actions act=new Actions(driver);
	act.moveByOffset(10, 10).click().perform();
	driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
	driver.findElement(By.xpath("//span[.='DEPARTURE']")).click();
	
			
			
		
			
		}
	}

