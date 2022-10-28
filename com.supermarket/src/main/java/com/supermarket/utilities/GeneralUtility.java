package com.supermarket.utilities;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import net.bytebuddy.asm.Advice.This;

public class GeneralUtility {
	WebDriver driver;

	public GeneralUtility(WebDriver driver) {
		this.driver = driver;
	}

	public boolean is_Displayed(WebElement element) {
		return element.isDisplayed();
	}

	public boolean is_Selected(WebElement element) {
		return element.isSelected();
	}

	public boolean is_Enabled(WebElement element) {
		return element.isEnabled();
	}

	public String get_Text(WebElement element) {
		return element.getText();
	}

	public String get_Title(String title) {
		title = driver.getTitle();
		return title;
	}

	public String get_CurrentUrl(String currentUrl) {
		currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

	public List<String> get_TextOfElements(String xpath) {
		List<String> text = new ArrayList<String>();
		List<WebElement> elementList = driver.findElements(By.xpath(xpath));
		for (WebElement list : elementList) {
			text.add(list.getText());

		}
		return text;

	}

	public String get_CssValue(WebElement element, String value) {
		return element.getCssValue(value);
	}
}
