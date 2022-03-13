package com.crm.OraganizationTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.CreateOrgPage;
import com.crm.ObjectRepository.Homepage;
import com.crm.ObjectRepository.Organization;
import com.crm.ObjectRepository.OrganizationInfoPage;
@Listeners(com.crm.GenericLibrary.ListnerImplementationClass.class)
public class CreateOrganizationTest extends BaseClass {
	@Test(retryAnalyzer = com.crm.GenericLibrary.RetryAnalyzerImplementation.class)
	public void createOrganizationTest() throws Throwable
	{
		//Step 1: launch the browser
		
		String OrgName = eLib.readDataFromExcel("Sheet1", 1, 2)+jLib.getRandomNumber();
		

		//Step 3: navigate to organizations link
		Homepage hp=new Homepage(driver);
		hp.ClickonOrgLnk();
		Assert.fail();
		//Step 4: click on create Organization link
		Organization op=new Organization(driver);
		op.ClickOnCreateOrgImg();
		
		//Step 5:create org with mandatory fields
		CreateOrgPage cop=new CreateOrgPage(driver);
		cop.createNewOrg(OrgName);
		
		//varification
		OrganizationInfoPage or=new OrganizationInfoPage(driver);
		String actOrgName = or.OrgNameInfo();
		if(actOrgName.contains(OrgName))
		{
			System.out.println(actOrgName+"---> data verified");
			
		}else
		{
			System.out.println("data not verified");
		}
	
	}

}