package com.supermarkets.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.GeneralUtility;
import com.supermarket.utilities.PageUtility;

public class ManageContentPage {
	WebDriver driver;

	@FindBy(xpath = "//p[contains(text(),' Manage Content')]")
	private WebElement manageContentLink;
	@FindBy(xpath = "//li[@class='nav-item']//a[@href='https://groceryapp.uniqassosiates.com/admin/list-page']")
	private WebElement managePage;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/pages/add']")
	private WebElement newoption;
	@FindBy(xpath = "//input[@name='title']")
	private WebElement titleField;
	@FindBy(xpath = "//div[@class='note-editable card-block']")
	private WebElement descriptionBox;
	@FindBy(xpath = "//input[@id='page']")
	private WebElement pageName;
	@FindBy(xpath = "//input[@id='main_img']")
	private WebElement UpLoadimage;
	@FindBy(xpath = "//button[text()='Save']")
	private WebElement saveOption;

	public ManageContentPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void clickOn_ManageContent() {
		manageContentLink.click();
	}

	public void clickOn_ManagePage() {
		managePage.click();
	}

	public void clickOn_NewOption() {
		newoption.click();
	}

	public void enter_Title(String title) {
		titleField.sendKeys(title);
	}

	public void enter_Description(String description) {
		descriptionBox.sendKeys(description);
	}

	public void enter_PageName(String name) {
		pageName.sendKeys(name);
	}

	public void upLoad_Image(String image) {
		UpLoadimage.sendKeys(image);
	}

	public void clickOn_SaveOption() {
		saveOption.click();
	}

}
