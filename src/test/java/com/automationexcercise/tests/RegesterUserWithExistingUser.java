package com.automationexcercise.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.automationexcercise.listeners.MainListeners;
import com.automationexcercise.pages.LoginPage;
import com.automationexcercise.utilities.UserActions;

@Listeners(MainListeners.class)
public class RegesterUserWithExistingUser {

	@Test
	public static void verifyErrorMsgForExistingUser() {
		LoginPage lp = new LoginPage(MainListeners.getDriver());
		UserActions.setValue(lp.nameField, "Yunus");
		UserActions.setValue(lp.signUpEmailField, "regester7@mail.com");
		UserActions.clickElement(lp.signUpButton);
		UserActions.isVisible(lp.emailExistMsg);

	}

}
