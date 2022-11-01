package com.supermarket.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShot {
TakesScreenshot takesscreenshot;

public void take_ScreenShot(WebDriver driver,String imageName)
{
	try {
		takesscreenshot=(TakesScreenshot)driver;
		File screenshotfile=takesscreenshot.getScreenshotAs(OutputType.FILE);
		String timeStamp=new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
		String destination=System.getProperty("user.dir")+"\\ScreenShots\\"+imageName+" "+timeStamp+".png";
		File finalNewDestination=new File(destination);
		FileHandler.copy(screenshotfile,finalNewDestination);
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	
	
	
	}
}
