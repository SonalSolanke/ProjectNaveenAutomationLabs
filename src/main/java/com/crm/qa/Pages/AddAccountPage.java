package com.crm.qa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.Util.TestUtil;
import com.crm.qa.base.BaseClass;

public class AddAccountPage extends BaseClass {


	
	@FindBy(xpath="//a[text()='New Account']")
	WebElement addAccountlink;
	
	
	@FindBy(name="cusid")
	@CacheLookup
	WebElement customerID;
	
	@FindBy(name="selaccount")
	@CacheLookup
	WebElement selectAccType;
	
	@FindBy(name="inideposit")
	WebElement initialDeposit;
	
	@FindBy(name="button2")
	WebElement submitBtn;
	
	public AddAccountPage() {
		PageFactory.initElements(driver, this);
	}
	
	//methods
	public String getPageTitle()
	{
		return driver.getTitle();
		
	}
	
	public boolean verify_NewAccLinkAvailable()
	{
		return addAccountlink.isDisplayed();
		
	}
	
	
	public void createNewAccount(String custId, int index, String deposit )
	{
		customerID.sendKeys(custId);
		TestUtil.selectByIndexMethod(selectAccType, 1);
		initialDeposit.sendKeys(deposit);
		submitBtn.click();
		
	}
	public void setInitialDeposit(int initialDep) {
		initialDeposit.sendKeys(String.valueOf(initialDep));
	}
	
	
}
