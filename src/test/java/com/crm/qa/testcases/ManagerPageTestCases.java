package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.Pages.LoginPage;
import com.crm.qa.Pages.ManagerPage;
import com.crm.qa.base.BaseClass;

public class ManagerPageTestCases extends BaseClass {

	
	ManagerPage managerPage;
	LoginPage loginPage;
	
	public ManagerPageTestCases() {
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		Initialize();
		loginPage = new LoginPage();
		managerPage= loginPage.loginApplication(pro.getProperty("userName"), pro.getProperty("password"));
	}
	
	
	@Test(priority=1)
	public void verifyManagerIDTest()
	{
		String mgrIdText= managerPage.getManagerID().substring(12);	
		Assert.assertEquals(mgrIdText, "mngr284369");
		
			
	}
	
	@Test(priority=2)
	public void verifyPageHeaderText()
	{
		String pageHeaderText= managerPage.getPageHeadingText();	
		Assert.assertEquals(pageHeaderText, "Welcome To Manager's Page of Guru99 Bank");
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
	
}
