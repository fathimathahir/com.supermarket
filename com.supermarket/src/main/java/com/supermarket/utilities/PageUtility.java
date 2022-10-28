package com.supermarket.utilities;



import java.util.concurrent.locks.Condition;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	WebDriver driver;
	JavascriptExecutor js;

	public PageUtility(WebDriver driver) {
		this.driver = driver;
	}

	public void select_ByIndex(int index, WebElement element) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public void select_ByValue(String value, WebElement element) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	public void select_ByVisibleText(String text, WebElement element) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	public void scroll_Down(int x, int y) {
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy,(" + x + "," + y + ")");
	}

	public void click_JavaScriptExecutor(WebElement element) {
		js = (JavascriptExecutor) driver;
		js.executeScript("argument[0].click();", element);
	}

	public void mouse_click(WebElement element) {
		Actions action = new Actions(driver);
		action.click(element).build().perform();
	}

	public void scroll_Click(WebElement element) {
		int x = 0;
		js = (JavascriptExecutor) driver;
		while (click_Status(element)) {
			js.executeScript("window.scrollBy(0," + x + ")");
			x = x + 50;

		}
	}

	public boolean click_Status(WebElement element) {
		try {
			element.click();
			return false;
		} catch (Exception e) {
			return true;
		}
	}
}
