package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.Pages.AddAccountPage;
import com.crm.qa.Pages.LoginPage;
import com.crm.qa.Pages.ManagerPage;
import com.crm.qa.base.BaseClass;

public class AddAccountPageTestCases extends BaseClass{
	
	AddAccountPage addAccountPage;
	LoginPage loginPage;
	ManagerPage managerPage;
	
	public AddAccountPageTestCases() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp()
	{
		Initialize();
		loginPage = new LoginPage();
		addAccountPage= new AddAccountPage();
		managerPage= new ManagerPage() ;
		loginPage.loginApplication(pro.getProperty("userName"), pro.getProperty("password"));	
		addAccountPage= managerPage.newAccountLinkClick();
	}
	
	@Test(priority=1)
	public void verifyPageTitleTest()
	{
		String pageTitle= addAccountPage.getPageTitle();
		String expectedpageTitle= "Guru99 bank add new account";
		Assert.assertEquals(pageTitle, expectedpageTitle);
		
	}
	
	@Test(priority=2)
	public void verify_AddNewLinkAvailable_Test()
	{
		boolean flag= addAccountPage.verify_NewAccLinkAvailable();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void addNewAccountTest()
	{
		
		addAccountPage.createNewAccount("123456", 1, "10000");
				
	}

	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
