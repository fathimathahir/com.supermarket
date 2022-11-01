package com.supermarkets.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.GeneralUtility;
import com.supermarket.utilities.PageUtility;
import com.supermarket.utilities.WaitUtility;

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
	@FindBy(xpath = "//li[@class='nav-item']//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext']")
	private WebElement ManageFooterPage;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Footertext/edit?edit=2']")
	private WebElement UpDateLink;
	@FindBy(xpath = "//button[@name='Update']")
	private WebElement UpDateButton;
	@FindBy(xpath = "//div[@class= 'alert alert-success alert-dismissible']")
	private WebElement UpDatesucessmessage;
	@FindBy(xpath = "//a[@class= 'btn btn-default btn-fix']")
	private WebElement ResetOption;
	@FindBy(xpath = "//li[@class='nav-item']//a[@href= 'https://groceryapp.uniqassosiates.com/admin/list-news']")
	private WebElement ManageNewsLink;
	@FindBy(xpath = "//a[@href= 'https://groceryapp.uniqassosiates.com/admin/news/add']")
	private WebElement NewOption;
	@FindBy(xpath = "//textarea[@id= 'news']")
	private WebElement NewsTitle;
	@FindBy(xpath = "//button[@class= 'btn btn-danger']")
	private WebElement NewsSaveOption;

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
		WaitUtility waitutility = new WaitUtility(driver);
		waitutility.element_ToBeClickable(10, "//button[text()='Save']");
		saveOption.click();
	}

	public void clickOn_ManageFooterPage() {
		ManageFooterPage.click();
	}

	public void clickOn_UpDateLink() {
		UpDateLink.click();
	}

	public void clickOn_UpDateButton() {
		UpDateButton.click();
	}

	public String get_BackGroundColorForSucessUpdateAlert() {
		GeneralUtility generalutility = new GeneralUtility(driver);
		return generalutility.get_CssValue(UpDatesucessmessage, "background-color");

	}

	public void clickOn_ResetButton() {
		ResetOption.click();
	}

	public void clickOn_ManageNewsPage() {
		ManageNewsLink.click();
	}

	public void clickOn_NewNewsOption() {
		NewOption.click();
	}

	public void clickOn_NewsSaveOption() {
		NewsSaveOption.click();
	}

	public boolean saveButton_Enabled() {
		GeneralUtility generalutility = new GeneralUtility(driver);
		return generalutility.is_Enabled(NewsSaveOption);
	}
}
