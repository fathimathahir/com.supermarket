package com.supermarket.tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.constants.Constants;
import com.supermarket.utilities.PageUtility;
import com.supermarkets.pages.LogInPage;
import com.supermarkets.pages.ManageContentPage;

public class ManageContentTest extends Base {
	LogInPage loginPage;
	ManageContentPage managecontentPage;

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
		managecontentPage.enter_PageName("Icecream List");
		managecontentPage.upLoad_Image(Constants.IMAGEUPLOAD_MANAGEPAGE);
		managecontentPage.clickOn_SaveOption();

	}

}
