package com.supermarkets.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.Excel;
import com.supermarket.utilities.GeneralUtility;

public class LogInPage {
	WebDriver driver;

	Excel excel;

	@FindBy(xpath = "//input[@name='username']")
	private WebElement userName;
	@FindBy(xpath = "//input[@name='password']")
	private WebElement password;
	@FindBy(xpath = "//button[@class='btn btn-dark btn-block']")
	private WebElement signIn;
	@FindBy(xpath = "//img[@class='img-circle']")
	private WebElement profileImage;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement alertMessage;
	@FindBy(xpath = "//input[@id='remember']")
	private WebElement rememberMe;
	@FindBy(xpath = "//label[@for='remember']")
	private WebElement rememberMeLabel;
	
	@FindBy(xpath = "//i[@class='ace-icon fa fa-power-off']")
	private WebElement logOut;
	


	public LogInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterUserName(String UserName) {
		userName.sendKeys(UserName);

	}

	public void enterPassWord(String Password) {
		password.sendKeys(Password);

	}

	public void clickOnLogInButton() {

		signIn.click();
	}

	public void logIn(String UserName, String Password) {

		enterUserName(UserName);
		enterPassWord(Password);
		clickOnLogInButton();
	}

	public void logIn() {
		String UserName;
		String Password;
		excel = new Excel();
		excel.setExcelFile("Login", "validlogincredentials");
		UserName = excel.getCellData(0, 0);
		Password = excel.getCellData(1, 0);
		logIn(UserName, Password);

	}

	public boolean is_profileImageDisplayed() {
		GeneralUtility generalutility = new GeneralUtility(driver);
		return generalutility.is_Displayed(profileImage);

	}

	public String getTextOfAlert() {
		GeneralUtility generalutility = new GeneralUtility(driver);
		// return generalutility. get_Text(alertMessage);
		String text = generalutility.get_Text(alertMessage);
		System.out.println(text);
		return text;
	}

	public void Click_RememberMeCheckBox() {
		rememberMeLabel.click();

	}

	public boolean is_SelectedRememberMe() {
	
		GeneralUtility generalutility = new GeneralUtility(driver);
		return generalutility.is_Selected(rememberMe);

	}
	public void click_OnLogOut()
	{
		profileImage.click();
		 logOut.click();
	}
	
	
}
