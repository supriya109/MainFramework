package com.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class GoibiboCalender {
	@Test
	public void calender()
	{
	String date="12";
	String monthAndYear="June 2022";
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get("https://www.goibibo.com/");
	
	Actions act=new Actions(driver);
	act.moveByOffset(10, 10).click().perform();
	
	driver.findElement(By.xpath("//span[.='Departure']")).click();
	String arrow = "//span[@aria-label='Next Month']";
	String datexpath = "//div[.='"+monthAndYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[.='"+date+"']";
	for(;;)
	{
		try {
			driver.findElement(By.xpath(datexpath)).click();
			driver.findElement(By.xpath("//span[.='Done']")).click();
			break;
		}
			catch (Exception e) {
				driver.findElement(By.xpath(arrow)).click();
			}
		}
	}
}

