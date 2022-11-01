package com.supermarket.base;


import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.ScreenshotException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.model.ITest;
import com.supermarket.constants.Constants;
import com.supermarket.utilities.ScreenShot;
import com.supermarket.utilities.WaitUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public WebDriver driver;
    Properties prop;
    FileInputStream ip;
    ScreenShot screenshot;
public Base() {
	prop = new Properties();
	try {
		ip = new FileInputStream(Constants.CONFIG_FILE_PATH);
		prop.load(ip);
	} catch (Exception e) {
		e.printStackTrace();
	}
}

public void initialize(String browser, String url) {
	if (browser.equals("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

	} else if (browser.equals("edge")) {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();

	} else if (browser.equals("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}
	driver.get(url);
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtility.IMPLICIT_WAIT));
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(WaitUtility.PAGE_LOAD_WAIT));
}
    @Parameters("browser")
	@BeforeMethod(enabled=false)
	public void setUp(String browser) {
	//	String browser;
		String  url;
	//	browser=prop.getProperty("browser");//for run cross browser make it true and setup()false
		url=prop.getProperty("url");
		initialize(browser,url);
	}
    @BeforeMethod(enabled=true,alwaysRun = true)
	public void setUp() {
		String browser;
		String  url;
		browser=prop.getProperty("browser");
		url=prop.getProperty("url");
		initialize(browser,url);
	}
    
	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult itestresult)//inbuild testcasename and screenshotname same
	{
	
		screenshot=new ScreenShot();
		if(itestresult.getStatus()==ITestResult.FAILURE)
		{
			String testcaseName=itestresult.getName();
		screenshot=new ScreenShot();
		screenshot.take_ScreenShot(driver,testcaseName);
		
		}
		driver.close();
	}

}
