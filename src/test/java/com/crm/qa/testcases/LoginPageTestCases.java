package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.crm.qa.Pages.LoginPage;
import com.crm.qa.base.BaseClass;
import com.crm.qa.Pages.ManagerPage;

public class LoginPageTestCases extends BaseClass {
	
	LoginPage loginPage;
	ManagerPage managerPage;
		
	public LoginPageTestCases() {
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		Initialize();
		loginPage = new LoginPage();
		
	}
	
	@Test(priority=1)
	public void validateLoginPageTitleTest()
	{		
		logger.info("***************Inside validateLoginPageTitleTest method**************");
		String title= loginPage.getLoginPageTitle();
		String loginPageTitle= "Guru99 Bank Home Page";
		Assert.assertEquals(title, loginPageTitle);
		logger.info("***************validateLoginPageTitleTest  Executed Successfully**************");
		
	}
	
	
	@Test(priority=2)
	public void loginTest()
	{
		managerPage = loginPage.loginApplication(pro.getProperty("userName"), pro.getProperty("password"));
		
	}
	

	
	@AfterMethod
	public void teadDown()
	{
		driver.quit();
		
	}
	
	
	

}
