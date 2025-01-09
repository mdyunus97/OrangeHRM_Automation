package com.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.orangehrm.listeners.MainListeners;
import com.orangehrm.pages.BookDemoPage;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.pages.OrangeHRMWebsitePage;
import com.orangehrm.utilities.UserActions;

@Listeners(MainListeners.class)
public class BookingFreeDemoTest {
	@Test(description = "Verify booking a free demo")
	public static void verifyBookingFreeDemo() throws InterruptedException {

		LoginPage lp = new LoginPage(MainListeners.getDriver());
		UserActions.clickElement(lp.websiteLink, "clicked on ornage hrom navigation link");
		Thread.sleep(3000);

		UserActions.windowHandling(1);

		String expTitle = MainListeners.getDriver().getTitle();
		System.out.println(expTitle);
		System.out.println(MainListeners.getDriver().getCurrentUrl());
		Assert.assertEquals("https://www.orangehrm.com/", MainListeners.getDriver().getCurrentUrl());

		Assert.assertEquals("Human Resources Management Software | OrangeHRM", expTitle);

		OrangeHRMWebsitePage org = new OrangeHRMWebsitePage(MainListeners.getDriver());

		UserActions.clickElement(org.bookADemoBtn, "Clicked on Book a demo button");
		BookDemoPage bd = new BookDemoPage(MainListeners.getDriver());
		UserActions.setValue(bd.fullNameField, "David Thomas", "Entered the fullname");
		UserActions.setValue(bd.phoneNumberField, "0909090909", "Entered phone number");
		UserActions.setValue(bd.businessEmail, "david@rover.com", "Entered email");
		UserActions.setValue(bd.companyName, "Rover Technologies", "Entered company name");
		UserActions.clickElement(bd.countryDrpdwn, "Clicked on country dropdown");
		UserActions.selectDropdownByValue(bd.countryDrpdwn, "India");
		Thread.sleep(1000);

//		UserActions.clickElement(bd.imNotRobot, "clicked on I am not robot");
		UserActions.clickElement(bd.getAFreeDemoBtn, "cliccked on get a free demo button");
//		String confMsg = bd.confrmationMsg.getText();
//		System.out.println(confMsg);
		MainListeners.getDriver().get("https://opensource-demo.orangehrmlive.com/");

	}

}
