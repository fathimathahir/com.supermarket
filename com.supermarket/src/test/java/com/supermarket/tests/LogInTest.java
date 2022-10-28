package com.supermarket.tests;



import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;


import com.supermarket.base.Base;
import com.supermarket.constants.Constants;
import com.supermarket.utilities.GeneralUtility;
import com.supermarkets.pages.LogInPage;

import dev.failsafe.internal.util.Assert;

public class LogInTest extends Base {
	LogInPage loginPage;

	@Test
	public void verify_LogIn() {
		LogInPage loginPage = new LogInPage(driver);
		loginPage.logIn();
		loginPage.is_profileImageDisplayed();
		assertTrue(loginPage.is_profileImageDisplayed());

	}

	@Test
	public void verify_InvalidData() {
		LogInPage loginPage = new LogInPage(driver);
		loginPage.logIn("125", "admin");
		// loginPage. getTextOfAlert();

		String expectedtext = Constants.EXPECTED_ALERT_TEXT;
		String actualtext = loginPage.getTextOfAlert();
		System.out.println(actualtext);
		assertEquals(actualtext, expectedtext, "This is testcase failed");
	}

	@Test
	public void Verify_RememberMeCheckBox() {
		LogInPage loginPage = new LogInPage(driver);

		loginPage.Click_RememberMeCheckBox();
		loginPage.is_SelectedRememberMe();
		assertTrue(loginPage.is_SelectedRememberMe());
	}

	@Test
	public void verify_LogOut() {
		LogInPage loginPage = new LogInPage(driver);
		loginPage.logIn();
		loginPage.click_OnLogOut();

	}

	

}
