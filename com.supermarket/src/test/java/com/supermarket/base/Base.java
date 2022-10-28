package com.supermarket.base;


import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

import com.supermarket.constants.Constants;
import com.supermarket.utilities.WaitUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public WebDriver driver;
    Properties prop;
    FileInputStream ip;
    
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

	@BeforeMethod
	public void setUp() {
		String browser;
		String  url;
		browser=prop.getProperty("browser");
		url=prop.getProperty("url");
		initialize(browser,url);
	}

}
