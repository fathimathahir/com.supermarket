package com.supermarkets.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.GeneralUtility;

public class DashBoardPage {
	WebDriver driver;

	@FindBy(xpath = "//div[@style='background-color:#E91E63 !important;']")
	private WebElement managePages;
	@FindBy(xpath = "//div[@class='small-box bg-info']//p[text()='Admin Users']")
	private WebElement adminUser;
	@FindBy(xpath = "//i[@class=' fa fa-cubes widget-stat-icon']")
	private WebElement manageOfferCodeICon;

	public DashBoardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public String get_BackGroundColor() {
		GeneralUtility generalutility = new GeneralUtility(driver);
		return generalutility.get_CssValue(managePages, "background-color");

	}

	public String get_FontSize() {
		GeneralUtility generalutility = new GeneralUtility(driver);
		return generalutility.get_CssValue(adminUser, "font-size");

	}
	public boolean check_IConIsDisplayed()
	{
		GeneralUtility generalutility = new GeneralUtility(driver);
		return generalutility.is_Displayed( manageOfferCodeICon);
	}

}
