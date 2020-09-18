package com.crm.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.crm.qa.Util.TestUtil;
import com.crm.qa.Util.WebEventListener;

public class BaseClass {

	
	public static WebDriver driver;
	public static Properties pro;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public static Logger logger;
	//public static ReadConfig rc;	

	public BaseClass()
	{
		File src= new File("F:\\aaaaSelenium coaching\\SeleniumHybridAutomation Framework\\ProjectNaveenAutomationLabs\\src\\main\\java\\com\\crm\\qa\\config\\config.Properties");
		
		try {
			FileInputStream fis= new FileInputStream(src); //to open file in read mode
			pro=new Properties();
			pro.load(fis);
			
		} catch(Exception e) {
			
			System.out.println("Exception is " + e.getMessage());
		}
		
	}
	
	//@Parameters ("browser")
	//@BeforeClass
	public static void Initialize() {
		
		String br= pro.getProperty("browser");
		logger = Logger.getLogger("FBN");
		//PropertyConfigurator.configure("log4j.properties");
		
		if(br.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver",pro.getProperty("chromepath"));
			driver= new ChromeDriver();	
		}  
		     
		else if(br.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", pro.getProperty("iepath"));  //set diff methods for IE and firefox
			driver= new InternetExplorerDriver();
		}
		
		else if(br.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", pro.getProperty("fitrefoxpath"));
			driver= new FirefoxDriver();
		}
		 
		
		
		//Fire event
		e_driver= new EventFiringWebDriver(driver);
		eventListener= new WebEventListener();
		e_driver.register(eventListener);
		driver=e_driver;
		
		
		
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.get(pro.getProperty("baseURL"));
		logger.info("********URL Launched*********");
	
	}
	
}
