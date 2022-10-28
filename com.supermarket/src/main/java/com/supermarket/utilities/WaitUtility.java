package com.supermarket.utilities;

import org.openqa.selenium.WebDriver;

public class WaitUtility {
	WebDriver driver;
	public WaitUtility(WebDriver driver)
	{
		this.driver=driver;
	}
	public static final long IMPLICIT_WAIT=10;
	public static final long PAGE_LOAD_WAIT=20;
}
