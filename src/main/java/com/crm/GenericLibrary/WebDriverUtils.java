package com.crm.GenericLibrary;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;
import com.mysql.cj.jdbc.Driver;

public class WebDriverUtils {
public void maximizewindow(WebDriver driver)
{
	driver.manage().window().maximize();
}
public void waitForPageLoad(WebDriver driver)
{
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
}
public void waitForElementTobeClickable(WebDriver driver,WebElement element)
{
	WebDriverWait wait=new WebDriverWait(driver,10);
	wait.until(ExpectedConditions.elementToBeClickable(element));
}
public void waitForElementTobeVisible(WebDriver driver,WebElement element)
{
	WebDriverWait wait=new WebDriverWait(driver,20);
	wait.until(ExpectedConditions.visibilityOf(element));
}
public void select(WebElement element,String text)
{
	Select sel=new Select(element);
	sel.deselectByVisibleText(text);
	
}
public void select(String value,WebElement element)
{
	Select sel=new Select(element);
	sel.selectByValue(value);

}

	public void mouseHover(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	public void dragAndDrop(WebDriver driver,WebElement src,WebElement target)
	{
		Actions act=new Actions(driver);
		act.dragAndDrop(src, target).perform();
	}
	public void doubleClickAction(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.doubleClick().perform();
	}
	public void rightClick(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.contextClick().perform();
	}
	public void enterKeyPress(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}
	public void keyRelease(WebDriver driver) throws Throwable
	{
        Robot r=new Robot();
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	public void switchToframe(WebDriver driver,String nameOrID)
	{
		driver.switchTo().frame(nameOrID);
}
	public void switchToframe(WebDriver driver,WebElement address)
	{
		driver.switchTo().frame(address);
	}


public void acceptAlert(WebDriver driver)
{
	driver.switchTo().alert().accept();
}

public void cancelAlert(WebDriver driver)
{
	driver.switchTo().alert().dismiss();
}
/**
 * This method will switch to window depending on partial title
 * @param driver
 * @param partialwinTitle
 */
public void switchToWindow(WebDriver driver,String partialwinTitle)
{
	//use getwindowhandls to capture all window ids
	Set<String> windows = driver.getWindowHandles();
	//iterate through windows
	Iterator<String> it = windows.iterator();
	//check whether there is next window
	while(it.hasNext())
	{
		//capture current window id
		String winID = it.next();
	//switch to current window and capture title
	String currentWinTitle=driver.switchTo().window(winID).getTitle();
	//check whether the current window is expected
	if(currentWinTitle.contains(partialwinTitle))
	{
		break;
	}
	}
	}/**
	**/

	public void getScreenshot(WebDriver driver,String screenShotName) throws Throwable
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(".\\screenshot\\"+screenShotName+".png");
		Files.copy(src, dst);
	}
	/**
	 * this method perform random scroll
	 * @param driver
	 */
	public void scrollAction(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)","");
	}

public void scrollAction(WebDriver driver,WebElement element)
{
	JavascriptExecutor js=(JavascriptExecutor) driver;
	int y = element.getLocation().getY();
	
	js.executeScript("window.scrollBy(0,"+y+")", element);
	//js.executeScript("argument[0].scrollIntoView()",element);

}
public void sampleJDBC(WebDriver driver,String Url,String user,String password) throws Throwable
{
	Driver driverRef=new Driver();
	DriverManager.registerDriver(driverRef);
	Connection conn = DriverManager.getConnection(Url, user, password);
	Statement stat = conn.createStatement();
	ResultSet result = stat.executeQuery("select * from table_name");
	while(result.next())
	{
		System.out.println(result.getString(1)+" "+result.getString(2));
	}
}
}

