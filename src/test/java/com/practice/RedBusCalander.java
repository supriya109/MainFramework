package com.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class RedBusCalander {
@Test
public void calender()
{
	String day="20";
	String month="Apr 2022";
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get("https://www.redbus.in/");
	
	driver.findElement(By.xpath("//span[@class='fl icon-calendar_icon-new icon-onward-calendar icon']")).click();
	String arrow = "//button[.='>']";
	String date = "//td[.='"+month+"']/ancestor::table[@class='rb-monthTable first last']/descendant::td[.='"+day+"']";
	
	for(;;)
	{
		try {
			driver.findElement(By.xpath(date)).click();
			break;
		} catch (Exception e) {
			driver.findElement(By.xpath(arrow)).click();
		}
	}
}
}
