package com.automationexcercise.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.automationexcercise.listeners.MainListeners;
import com.automationexcercise.pages.SignUpPage;

public class UserActions {

	public static void clickElement(WebElement clickAction) {
		SignUpPage sp = new SignUpPage(MainListeners.getDriver());
		clickAction.click();

	}

	public static void setValue(WebElement setAction, String data) {
		SignUpPage sp = new SignUpPage(MainListeners.getDriver());
		setAction.sendKeys(data);

	}

	public static void selectDropdownbyValue(WebElement drpdown, String value) {
		SignUpPage sp = new SignUpPage(MainListeners.getDriver());
		Select select = new Select(drpdown);
		select.selectByValue(value);

	}

	public static void verifyText(WebElement textElement, String expectedText) {
		String actualText = textElement.getText();
		try {
			Assert.assertEquals(expectedText, actualText);

			System.out.println("the expected text is : " + expectedText + " and actual text is : " + actualText
					+ "  --- are matching");

		} catch (Exception e) {
		}
	}

	public static void isVisible(WebElement visibleElement) {
		try {
			visibleElement.isDisplayed();
			System.out.println("The expected element " + visibleElement + "is visible");
		} catch (Exception e) {
		}
	}

	public static void scrollTo(WebElement scrollElement) {
		((JavascriptExecutor) MainListeners.getDriver()).executeScript("arguments[0].scrollIntoView(true);",
				scrollElement);

	}
}
