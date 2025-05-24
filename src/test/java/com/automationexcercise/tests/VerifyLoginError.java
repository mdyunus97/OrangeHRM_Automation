package com.automationexcercise.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.automationexcercise.listeners.MainListeners;
import com.automationexcercise.pages.LoginPage;
import com.automationexcercise.utilities.UserActions;

@Listeners(MainListeners.class)
public class VerifyLoginError {
	@Test
	public static void verifyErrorMsgForInvalidCredentials()

	{
		LoginPage lp = new LoginPage(MainListeners.getDriver());
		UserActions.setValue(lp.loginEmailField, "Invalid@gail.com");
		UserActions.setValue(lp.passwordField, "Invalidpassword");
		UserActions.clickElement(lp.loginButton);
		UserActions.verifyText(lp.loginErrorMsg, "Your email or password is incorrect!");

	}

}
