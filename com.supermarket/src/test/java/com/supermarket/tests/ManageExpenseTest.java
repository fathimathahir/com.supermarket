package com.supermarket.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;



import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.base.DataProviderSuperMarket;
import com.supermarkets.pages.LogInPage;
import com.supermarkets.pages.ManageExpensePage;


public class ManageExpenseTest extends Base {
	LogInPage loginPage;
	ManageExpensePage manageexpensepage;
	DataProviderSuperMarket dataprovidersupermarket;

	@Test
	public void verify_AddedItemToExpenseCategory() {
		loginPage = new LogInPage(driver);
		loginPage.logIn();
		manageexpensepage = new ManageExpensePage(driver);
		manageexpensepage.click_OnManageExpenseLink();
		manageexpensepage.click_OnExpenseCategory();
		manageexpensepage.click_OnNew();
		manageexpensepage.enter_Title("Chocolates");
		manageexpensepage.click_OnSave();

		System.out.println(manageexpensepage.getText_OfAddTitle());
		String expectedtitle = "Chocolates";
		String actualtitle = manageexpensepage.getText_OfAddTitle();
		assertEquals(actualtitle, expectedtitle);
	}

	@Test
	public void verify_DeleteOption() {
		loginPage = new LogInPage(driver);
		loginPage.logIn();
		manageexpensepage = new ManageExpensePage(driver);
		manageexpensepage.click_OnManageExpenseLink();
		manageexpensepage.click_OnExpenseCategory();
		manageexpensepage.click_OnNew();
		manageexpensepage.enter_Title("Biscuits");
		manageexpensepage.click_OnSave();
		manageexpensepage.click_OnDelete();

		String alert = driver.switchTo().alert().getText();
		System.out.println("Alert for conforming the delete option:" + alert);
		driver.switchTo().alert().accept();

	}

	@Test(dataProvider = "searchcategory", dataProviderClass = com.supermarket.base.DataProviderSuperMarket.class)
	public void verify_SearchOption(String data) throws InterruptedException {
		loginPage = new LogInPage(driver);
		loginPage.logIn();
		manageexpensepage = new ManageExpensePage(driver);
		manageexpensepage.click_OnManageExpenseLink();
		manageexpensepage.click_OnExpenseCategory();
		manageexpensepage.click_OnSearch();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='un']")).sendKeys(data);
		// manageexpensepage.click_OnSearchTitle( data);
		manageexpensepage.click_OnSearchButton();
		assertTrue(manageexpensepage.searchButton_IsEnabled());
	}
	@Test
	public void verify_AddManageExpenseDetails()
	{
		loginPage = new LogInPage(driver);
		loginPage.logIn();
		manageexpensepage = new ManageExpensePage(driver);
		manageexpensepage.click_OnManageExpenseLink();
		manageexpensepage.click_ManageExpense();
		manageexpensepage.click_OnNew();
		manageexpensepage.enter_UserTitleField();
		manageexpensepage.enter_Category();
		manageexpensepage.enter_OrderId();
		manageexpensepage.enter_PurchaseId();
		manageexpensepage.enter_ExpenseType();
		manageexpensepage.enter_AmountField("4520");
		manageexpensepage.enter_RemarkField("Good Service");
		manageexpensepage.upload_File("C:\\Users\\lenovo\\Desktop//sele.docx");
		manageexpensepage.ScrollDown();
		manageexpensepage.saveButton_IsEnabled();
	}
	
}