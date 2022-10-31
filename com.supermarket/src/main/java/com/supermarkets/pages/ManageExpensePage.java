package com.supermarkets.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.GeneralUtility;
import com.supermarket.utilities.PageUtility;

public class ManageExpensePage {
	WebDriver driver;

	@FindBy(xpath = "//p[contains(text(),'  Manage Expense  ')]  //i[@class='fas fa-angle-left right']")
	WebElement manageExpenseLink;
	@FindBy(xpath = "//li[@class='nav-item']//a[@href='https://groceryapp.uniqassosiates.com/admin/expense-category']")
	WebElement expenseCategory;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newOption;
	@FindBy(xpath = "//input[@id='name']")
	WebElement titleField;
	@FindBy(xpath = "//i[@class='fa fa-save']")
	WebElement saveOption;
	@FindBy(xpath = "//td[contains(text(),'Chocolates')]")
	WebElement title;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Expense/cat_delete?del=527&page_ad=1']")
	WebElement deleteOption;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement SearchField;
	@FindBy(xpath = "//input[@id='un']")
	WebElement SearchTitleField;
	@FindBy(xpath = "//button[@name='Search']")
	WebElement SearchButton;
	@FindBy(xpath = "//p[text()='Manage Expense']")
	WebElement ManageExpense;
	@FindBy(xpath = "//select[@name='user_id']")
	WebElement UserTitle;
	@FindBy(xpath = "//select[@id='ex_cat']")
	WebElement CategoryField;
	@FindBy(xpath = "//select[@name='order_id']")
	WebElement OrderId;
	@FindBy(xpath = "//select[@name='purchase_id']")
	WebElement PurchaseId;
	@FindBy(xpath = "//select[@id='ex_type']")
	WebElement ExpenseType;
	@FindBy(xpath = "//input[@id='amount']")
	WebElement EnterAmount;
	@FindBy(xpath = "//textarea[@id='content']")
	WebElement remarksField;
	@FindBy(xpath = "//input[@type='file']")
	WebElement inPutFile;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement SaveExpense;

	public ManageExpensePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void click_OnManageExpenseLink() {
		manageExpenseLink.click();
	}

	public void click_OnExpenseCategory() {
		expenseCategory.click();
	}

	public void click_OnNew() {
		newOption.click();
	}

	public void enter_Title(String title) {
		titleField.sendKeys(title);
	}

	public void click_OnSave() {
		saveOption.click();
	}

	public void click_OnDelete() {
		deleteOption.click();
	}

	public void click_OnSearch() {
		SearchField.click();
	}

	// public void click_OnSearchTitle(String data)
	// {
	// SearchTitleField.sendKeys(data);
//   }
	public void click_OnSearchButton() {
		SearchButton.click();
	}

	public boolean searchButton_IsEnabled() {
		GeneralUtility generalutility = new GeneralUtility(driver);
		return generalutility.is_Enabled(SearchButton);

	}

	public String getText_OfAddTitle() {

		GeneralUtility generalUtility = new GeneralUtility(driver);
		return generalUtility.get_Text(title);

	}

	public void click_ManageExpense() {
		ManageExpense.click();
	}

	public void enter_UserTitleField() {
		PageUtility pageUtility = new PageUtility(driver);
		pageUtility.select_ByValue("4", UserTitle);
	}

	public void enter_Category() {
		PageUtility pageUtility = new PageUtility(driver);
		pageUtility.select_ByValue("385", CategoryField);
	}

	public void enter_OrderId() {
		PageUtility pageUtility = new PageUtility(driver);
		pageUtility.select_ByValue("77", OrderId);
	}

	public void enter_PurchaseId() {
		PageUtility pageUtility = new PageUtility(driver);
		pageUtility.select_ByVisibleText("7", PurchaseId);
	}

	public void enter_ExpenseType() {
		PageUtility pageUtility = new PageUtility(driver);
		pageUtility.select_ByVisibleText("Credit Bank", ExpenseType);
	}

	public void enter_AmountField(String amount) {

		EnterAmount.sendKeys(amount);
	}

	public void enter_RemarkField(String remark) {

		remarksField.sendKeys(remark);
	}

	public void upload_File(String file) {

		inPutFile.sendKeys(file);
	}

	public void ScrollDown() {
		PageUtility pageutility = new PageUtility(driver);
		pageutility.scroll_Click(SaveExpense);
	}

	public boolean saveButton_IsEnabled() {
		GeneralUtility generalutility = new GeneralUtility(driver);
		return generalutility.is_Enabled(SaveExpense);

	}

}
