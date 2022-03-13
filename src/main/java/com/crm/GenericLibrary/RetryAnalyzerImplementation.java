package com.crm.GenericLibrary;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzerImplementation implements IRetryAnalyzer {
int count=1;
int retrycount=5;
public boolean retry(ITestResult result) {
	while(count<retrycount)
	{
		count++;
		return true;
	}
	return false;
}


}
