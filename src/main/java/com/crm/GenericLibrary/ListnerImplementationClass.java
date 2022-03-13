package com.crm.GenericLibrary;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ListnerImplementationClass implements ITestListener {

	public void onTestStart(ITestResult result) {
	String MethodName=result.getMethod().getMethodName();
	Reporter.log(MethodName+"----testscript execution started");
	}

	public void onTestSuccess(ITestResult result) {
		String MethodName=result.getMethod().getMethodName();
		Reporter.log(MethodName+"----testscript execution sucessfull-PASS");
		
	}

	public void onTestFailure(ITestResult result) {
		String MethodName=result.getMethod().getMethodName();
		Reporter.log(MethodName+"----testscript execution failed,true");
		
		//step1:configure screenshoot name
		String screenShotName=MethodName+new JavaUtility().getSystemDateInFormat();
		System.out.println(screenShotName);
		
		//step2:using screenshot method from webdriverUtilit
		try {
			new WebDriverUtils().getScreenshot(BaseClass.sDriver, screenShotName);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		String MethodName=result.getMethod().getMethodName();
		Reporter.log(MethodName+"----testscript skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	public void onStart(ITestContext context) {
		
		
	}

	public void onFinish(ITestContext context) {
		
		
	}

}
