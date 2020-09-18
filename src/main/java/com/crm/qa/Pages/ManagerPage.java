package com.crm.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.BaseClass;

public class ManagerPage extends BaseClass {

	@FindBy(xpath= "/html/body/table/tbody/tr/td/table/tbody/tr[2]/td/marquee")
	WebElement pageHeading;
	
	@FindBy(xpath= "//td[text()='Manger Id : mngr284369']")
	WebElement managerId;
	
	@FindBy(xpath="//a[text()='New Customer']")
	WebElement newCustomerLink;
	
	@FindBy(xpath="//a[text()='New Account']")
	WebElement addAccountlink;
	
	//Initialize page objects
	public ManagerPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String getPageHeadingText()
	{
		return pageHeading.getText();
		
	}
	
	public String getManagerID()
	{
		return managerId.getText();
	}
	
	
	public AddAccountPage newAccountLinkClick() {
		addAccountlink.click();
		return new AddAccountPage();
	}

	
	
}
