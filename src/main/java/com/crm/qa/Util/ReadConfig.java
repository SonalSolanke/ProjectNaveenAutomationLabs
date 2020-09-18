package com.crm.qa.Util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;
	
	public ReadConfig() {
		
		File src= new File("F:\\aaaaSelenium coaching\\SeleniumHybridAutomation Framework\\ProjectNaveenAutomationLabs\\src\\main\\java\\com\\crm\\qa\\config\\config.Properties");
		
		try {
			FileInputStream fis= new FileInputStream(src); //to open file in read mode
			pro=new Properties();
			pro.load(fis);
			
		} catch(Exception e) {
			
			System.out.println("Exception is " + e.getMessage());
		}
		
	}
	
	
	//create methods to read each element in client config file
	
	public String getApplicationURL() {
		return pro.getProperty("baseURL");
	}
	
	public String getUsername() {
		return pro.getProperty("userName");
	}
	
	public String getPassword() {
		return pro.getProperty("password");
	}
	
	public String getChromeBrowserPath() {
		return pro.getProperty("chromepath");
	}
	
	public String getBrowser() {
		return pro.getProperty("browser");
		
	}
}
