package com.supermarkets.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.GeneralUtility;

public class PushNotificationPage {
  WebDriver driver;
  
  @FindBy(xpath="//p[text()='Push Notifications']")
	private WebElement pushNotification;
  @FindBy(xpath="//input[@id='title']")
	private WebElement titleField;
  @FindBy(xpath="//input[@id='description']")
	private WebElement descriptionField;
  @FindBy(xpath="//button[@class='btn btn-block-sm btn-info']")
	private WebElement sendButton;
  @FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
  private WebElement alertSuccessText;

  
  
  public PushNotificationPage( WebDriver driver)
  {
	this.driver=driver;
	PageFactory.initElements(driver, this);
  }
  
  public void clickOn_PushNotification()
  {
	  pushNotification.click();
  }
  public void enter_titleField (String title)
  {
	  titleField.sendKeys(title);
  }
  public void enter_descriptionField (String description)
  {
	  descriptionField.sendKeys(description);
  }
  public void click_SendButton ()
  {
	  sendButton.click();
	  
  }
  public String getTextSuccessAlert_PushNotification(String title,String description) {
	  enter_titleField(title);
	  enter_descriptionField(description);
	  click_SendButton();
	  GeneralUtility generalUtility=new GeneralUtility(driver);
	  return   generalUtility.get_Text(alertSuccessText);
	 
	}

}
