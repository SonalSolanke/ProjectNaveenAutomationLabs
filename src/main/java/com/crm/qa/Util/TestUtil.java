package com.crm.qa.Util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class TestUtil {

	//public static WebDriver driver;
	public static long PAGE_LOAD_TIMEOUT= 20;
	public static long IMPLICIT_WAIT_TIME =20;
	
	
	public static void selectByIndexMethod(WebElement selectAccType, int index) {
		Select sel= new Select(selectAccType);
		sel.selectByIndex(index);
		
		
	}
	
	
	public static void CaptureScreenShot(WebDriver driver) throws IOException {
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File Source =ts.getScreenshotAs(OutputType.FILE);
		File Target= new File(System.getProperty("user.dir") + "/Screenshots/" + System.currentTimeMillis() + ".png");		
		FileUtils.copyFile(Source, Target);
		
	}


	

		
}
