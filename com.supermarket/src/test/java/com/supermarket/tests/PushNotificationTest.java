package com.supermarket.tests;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.utilities.PdfReader;
import com.supermarkets.pages.LogInPage;
import com.supermarkets.pages.PushNotificationPage;

public class PushNotificationTest extends Base {
 
	PushNotificationPage pushnotificationpage;
	LogInPage loginpage;
	PdfReader pdfreader;
	
	@Test
	public void verify_PushNotification()

	{
		HashMap<String, String> map = new HashMap<String, String>();

		loginpage = new LogInPage(driver);
		loginpage.logIn();
		pushnotificationpage = new PushNotificationPage(driver);
		pushnotificationpage.clickOn_PushNotification();
		pushnotificationpage.getTextSuccessAlert_PushNotification("abc", "defg");
		System.out.println(pushnotificationpage.getTextSuccessAlert_PushNotification("abc", "defg"));
		pdfreader = new PdfReader();

		map = pdfreader.Pdf_ReadData("pushnotificationdata");
		System.out.println(map.get("title 1"));

	}

}
