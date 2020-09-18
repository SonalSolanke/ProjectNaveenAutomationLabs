package com.crm.qa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.BaseClass;

public class LoginPage extends BaseClass{
	
	//page factory= OR
	@FindBy(xpath="//input[@name='uid1']")
	WebElement txtUserName;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement txtPassword;
	
	@FindBy(name="btnLogin")
	WebElement btnLogin;
	
	@FindBy(name="btnReset")
	WebElement btnReset;
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
	WebElement logoutLink;
	
	//Initialize page objects
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	//Actions
	public String getLoginPageTitle()
	{
		return driver.getTitle();
		
	}
	
	public ManagerPage loginApplication(String uName, String pwd)
	{
		txtUserName.sendKeys(uName);
		txtPassword.sendKeys(pwd);
		btnLogin.click();
		
		return new ManagerPage();
		
	}
}
