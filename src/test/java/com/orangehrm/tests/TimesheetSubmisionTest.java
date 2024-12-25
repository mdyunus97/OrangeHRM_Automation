package com.orangehrm.tests;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.orangehrm.listeners.MainListeners;
import com.orangehrm.pages.HomePage;
import com.orangehrm.pages.TimesheetPage;
import com.orangehrm.utilities.HelperClass;
import com.orangehrm.utilities.UserActions;

import junit.framework.Assert;

@Listeners(MainListeners.class)
public class TimesheetSubmisionTest {

	@Test
	public static void verifyTimeSheetSubmission() throws InterruptedException, IOException {
		HelperClass.login();
		TimesheetPage timeShtPage = new TimesheetPage(MainListeners.getDriver());
		HomePage homePage = new HomePage(MainListeners.getDriver());
		UserActions.clickElement(homePage.timeSheetbtn, "Clicked on timesheet button");
		UserActions.setValue(timeShtPage.typeEmpName, "Test", "Entered employe name");
		UserActions.clickElement(timeShtPage.selectOrngTest, "Select Orange test option");
		UserActions.clickElement(timeShtPage.viewBtn, "Clicked on view button");
		Thread.sleep(3000);

		try {
			if (timeShtPage.restBtn != null && timeShtPage.restBtn.isDisplayed()) {
				UserActions.clickElement(timeShtPage.restBtn, "Clicked on reset button");
			} else {
				if (timeShtPage.approveTmshtBtn != null && timeShtPage.approveTmshtBtn.isDisplayed()) {
					UserActions.clickElement(timeShtPage.approveTmshtBtn, "Clicked on approve timesheet button");
				}
			}
		} catch (Exception e) {
			System.out.println("An optional button is either missing or not clickable: " + e.getMessage());
		}

		String timeShtStatus = timeShtPage.tmshtStatus.getText();
		Assert.assertEquals(timeShtStatus, "Status: Approved");
		System.out.println(timeShtStatus);
		HelperClass.logOut();

	}
}
