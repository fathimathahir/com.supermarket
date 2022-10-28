package com.supermarket.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarkets.pages.DashBoardPage;
import com.supermarkets.pages.LogInPage;

public class DashBoardTest extends Base {
	LogInPage loginPage;
	DashBoardPage dashBoardPage;

	@Test
	public void verify_BackGroundColor() {
		loginPage = new LogInPage(driver);
		loginPage.logIn();
		dashBoardPage = new DashBoardPage(driver);
		System.out.println("Background color of managepages :" + dashBoardPage.get_BackGroundColor());
		String expectedcolor = "rgba(233, 30, 99, 1)";
		String actualcolor = dashBoardPage.get_BackGroundColor();
		assertEquals(expectedcolor, actualcolor);
	}

	@Test
	public void verify_FontSize() {
		loginPage = new LogInPage(driver);
		loginPage.logIn();
		dashBoardPage = new DashBoardPage(driver);
		System.out.println("Font size  :" + dashBoardPage.get_FontSize());
		String expectedfontsize = "16px";
		String actualfontsize = dashBoardPage.get_FontSize();
		assertEquals(expectedfontsize, actualfontsize);
	}
	@Test
	public void verify_IConIsDisplayedOrNot() {
		loginPage = new LogInPage(driver);
		loginPage.logIn();
		dashBoardPage = new DashBoardPage(driver);
		dashBoardPage.check_IConIsDisplayed();
		assertTrue(dashBoardPage.check_IConIsDisplayed());
}
}