package com.automationexcercise.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.automationexcercise.listeners.MainListeners;
import com.automationexcercise.pages.ContactUsPage;
import com.automationexcercise.pages.LoginPage;
import com.automationexcercise.utilities.UserActions;

@Listeners(MainListeners.class)
public class ContactUsTest {

	@Test
	public static void verifyContactUsPage() throws InterruptedException {

		LoginPage lp = new LoginPage(MainListeners.getDriver());
		ContactUsPage cp = new ContactUsPage(MainListeners.getDriver());
		UserActions.isVisible(lp.contactUsBtn);
		if (lp.contactUsBtn.isDisplayed()) {
			UserActions.clickElement(lp.contactUsBtn);
		}
		UserActions.isVisible(cp.contactUsTitle);
		UserActions.setValue(cp.nameField, "Yunus");
		UserActions.setValue(cp.emailField, "regester7@mail.com");
		UserActions.setValue(cp.subjectField, "Regarding login issue");
		UserActions.setValue(cp.messageField,
				"I am not able to login to muy account, plese help me to resolve this issue asap.");
		UserActions.setValue(cp.fileUpload, "./dataFiles/20200924_110341.jpg");
		Thread.sleep(10000);
	}
}
