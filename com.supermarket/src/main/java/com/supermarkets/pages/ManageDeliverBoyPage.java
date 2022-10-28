package com.supermarkets.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.Excel;
import com.supermarket.utilities.GeneralUtility;
import com.supermarket.utilities.PageUtility;

public class ManageDeliverBoyPage {

	WebDriver driver;
	Excel excel;
	
	@FindBy(xpath = "//li[@class='nav-item']//a[@href='https://groceryapp.uniqassosiates.com/admin/list-deliveryboy']")
	private WebElement manageDeliverBoyLink;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Deliveryboy/add']")
	private WebElement newClick;
	@FindBy(xpath="//input[@id='name']")
	private WebElement nameField ;
	@FindBy(xpath="//input[@id='email']")
	private  WebElement eMailField;
	@FindBy(xpath="//input[@id='phone']")
	private WebElement phoneNumber ;
	@FindBy(xpath="//textarea[@id='address']")
	private WebElement addressField ;
	@FindBy(xpath="//input[@id='username']")
	private WebElement userNameField;
	@FindBy(xpath="//input[@id='password']")
	private WebElement passWordField;
	@FindBy(xpath="//button[text()='Save']")
	private WebElement saveOption;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	private WebElement saveMessage;
	
	
	
	public ManageDeliverBoyPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void click_ManageDeliverBoy()
	{
		 manageDeliverBoyLink.click();
	}
	public void click_New()
	{
		newClick.click();
	}
	public void enter_Name(String name)
	{
		nameField.sendKeys(name);
	}
	public void enter_EMail(String email)
	{
		 eMailField.sendKeys(email);
	}
	
	public void enter_PhoneNumber(String number)
	{
		phoneNumber.sendKeys(number);
	}
	
	public void enter_Address(String address)
	{
		addressField.sendKeys(address);
	}
	public void enter_UserName(String username)
	{
		 userNameField.sendKeys(username);
	}
	public void enter_PassWord(String password)
	{
		passWordField.sendKeys(password);
	}
	public void click_SaveButton()
	{
		saveOption.click();
	}
	public void ScrollDown() 
	{
	PageUtility pageutility=new PageUtility(driver);
	pageutility.scroll_Click(saveOption);
	}
	
	public void create_DeliveryBoy(String name,String email,String number,String address,String username,String password) {
		enter_Name( name);
		enter_EMail(email);
		enter_PhoneNumber(number);
		enter_Address(address);
		enter_UserName(username);
		enter_PassWord(password);
		}
	
}

