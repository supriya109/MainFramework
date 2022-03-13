package com.practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PracticeRetry {
@Test(retryAnalyzer = com.crm.GenericLibrary.RetryAnalyzerImplementation.class)
public void practice()
{
	SoftAssert sa=new SoftAssert();
	
	System.out.println("tasecase1");
	
	System.out.println("passed");
	sa.assertAll();
	
}
}
