package com.orangehrm.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.orangehrm.listeners.MainListeners;
import com.orangehrm.pages.HomePage;
import com.orangehrm.pages.LeaveApplicationPage;
import com.orangehrm.utilities.HelperClass;
import com.orangehrm.utilities.UserActions;

@Listeners(MainListeners.class)
public class ApplyLeaveTest {

	@Test
	public static void applyLeaveApplication() throws InterruptedException {
		HelperClass.login();
		LeaveApplicationPage leaveAppPage = new LeaveApplicationPage(MainListeners.getDriver());

		HomePage homePage = new HomePage(MainListeners.getDriver());
		UserActions.clickElement(homePage.applyLeaveOption, "Clicked on apply leave button");
		UserActions.clickElement(leaveAppPage.leaveType, "Clicked on leave type on leave application page");
		UserActions.clickElement(leaveAppPage.leaveTypeOption, "Clicked on leave type option");
		UserActions.clickElement(leaveAppPage.fromDate, "Clicked on from Date");
		UserActions.clickElement(leaveAppPage.selectFromDate, "Selected from date");
		UserActions.clickElement(leaveAppPage.todate, "Clicked on To date");
		Thread.sleep(2000);
		UserActions.clickElement(leaveAppPage.selectToDate, "Selected To date");
		Thread.sleep(2000);
		UserActions.clickElement(leaveAppPage.partialDays, "Clicked on partial days");
		Thread.sleep(2000);
		UserActions.clickElement(leaveAppPage.selectAllDays, "Selected the type as All days");
		Thread.sleep(2000);
		UserActions.clickElement(leaveAppPage.durationOption, "Clicked on duration option");
		UserActions.clickElement(leaveAppPage.specifyTime, "Clicked on specify time");
		UserActions.clickElement(leaveAppPage.applyBtn, "Clicked on apply leave button");

		HelperClass.logOut();

	}

}
