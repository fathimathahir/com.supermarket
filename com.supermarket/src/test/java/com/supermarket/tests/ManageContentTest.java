package com.supermarket.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.base.DataProviderSuperMarket;
import com.supermarket.constants.Constants;

import com.supermarkets.pages.LogInPage;
import com.supermarkets.pages.ManageContentPage;

public class ManageContentTest extends Base {
	LogInPage loginPage;
	ManageContentPage managecontentPage;
	DataProviderSuperMarket dataprovidersupermarket;

	@Test
	public void verify_ManagePageAddList() {
		loginPage = new LogInPage(driver);
		loginPage.logIn();

		managecontentPage = new ManageContentPage(driver);
		managecontentPage.clickOn_ManageContent();
		managecontentPage.clickOn_ManagePage();
		managecontentPage.clickOn_NewOption();
		managecontentPage.enter_Title("Ice Cream");
		managecontentPage.enter_Description("Butterscotch ice cream..");
		managecontentPage.enter_PageName("2");
		managecontentPage.upLoad_Image(Constants.IMAGEUPLOAD_MANAGEPAGE);
		managecontentPage.clickOn_SaveOption();

	}

	@Test(groups = {"smoke","sanity"})
	public void verify_UpDateOptionForManageFooterPage() {
		loginPage = new LogInPage(driver);
		loginPage.logIn();

		managecontentPage = new ManageContentPage(driver);
		managecontentPage.clickOn_ManageContent();
		managecontentPage.clickOn_ManageFooterPage();
		managecontentPage.clickOn_UpDateLink();
		managecontentPage.clickOn_UpDateButton();
		String expectedtext = Constants.EXPECTED_COLOR_FOR_ALERT_TEXT;
		String actualtext = managecontentPage.get_BackGroundColorForSucessUpdateAlert();
		System.out.println(actualtext);
		assertEquals(actualtext, expectedtext);
	}

	@Test
	public void verify_ResetOptionForManageFooterPage() {
		loginPage = new LogInPage(driver);
		loginPage.logIn();

		managecontentPage = new ManageContentPage(driver);
		managecontentPage.clickOn_ManageContent();
		managecontentPage.clickOn_ManageFooterPage();
		managecontentPage.clickOn_UpDateLink();

		managecontentPage.clickOn_ResetButton();
	}

	@Test(dataProvider = "addnews", dataProviderClass = com.supermarket.base.DataProviderSuperMarket.class)
	public void verify_ManageNewsPage(String data) {
		loginPage = new LogInPage(driver);
		loginPage.logIn();

		managecontentPage = new ManageContentPage(driver);
		managecontentPage.clickOn_ManageContent();
		managecontentPage.clickOn_ManageNewsPage();
		managecontentPage.clickOn_NewNewsOption();
		driver.findElement(By.xpath("//textarea[@id= 'news']")).sendKeys(data);
		managecontentPage.clickOn_NewsSaveOption();
		assertTrue(managecontentPage.saveButton_Enabled());
	}
}
		