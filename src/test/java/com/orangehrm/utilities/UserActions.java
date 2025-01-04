package com.orangehrm.utilities;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.orangehrm.listeners.MainListeners;
import com.orangehrm.pages.BookDemoPage;

import junit.framework.Assert;

public class UserActions {

	public static void clickElement(WebElement element, String message) {
		element.click();
		try {
			Thread.sleep(2000);
			HelperClass.screenshotForReport(message);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void setValue(WebElement element, String data, String message) {
		element.sendKeys(data);
		try {
			HelperClass.screenshotForReport(message);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void elementExist(WebElement element, String message) {
		try {
			element.isDisplayed();
			HelperClass.screenshotForReport(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void verifyText(WebElement element, String expectedValue, String message) {

		String actualValue = element.getText();
		try {

			Assert.assertEquals(expectedValue, actualValue);
			HelperClass.screenshotForReport(message);
			System.out.println(
					"The expected value is: " + expectedValue + " matching with the actual value: " + actualValue);
		} catch (Error e) {
			HelperClass
					.screenshotForReport("expected: " + expectedValue + " is not matching with actual: " + actualValue);
		}
	}

	public static void verifyTextContains(WebElement element, String expValue, String message) {
		String actualValue = element.getText().toLowerCase();
		String expectedValue = expValue.toLowerCase();
		try {
			Boolean result = actualValue.contains(expectedValue);
			Assert.assertTrue(result);
			HelperClass.screenshotForReport(message);
			System.out.println(
					"The expected value is: " + expectedValue + " matching with the actual value: " + actualValue);
		} catch (Error e) {
			HelperClass.screenshotForReport(
					"expected: " + expectedValue + " is not present in the actual: " + actualValue);
		}
	}

	public static void windowHandling(int index) {
		ArrayList<String> tabs = new ArrayList<String>(MainListeners.getDriver().getWindowHandles());

		MainListeners.getDriver().switchTo().window(tabs.get(1));
	}

	public static void selectDropdownByValue(WebElement drpdownl, String value) {
		BookDemoPage pg = new BookDemoPage(MainListeners.getDriver());
		Select dropdown = new Select(pg.countryDrpdwn);
		dropdown.selectByValue(value);
	}
}
