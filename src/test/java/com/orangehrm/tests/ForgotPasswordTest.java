package com.orangehrm.tests;

import java.util.Properties;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.orangehrm.listeners.MainListeners;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.pages.ResetPasswordPage;
import com.orangehrm.utilities.UserActions;

import junit.framework.Assert;

@Listeners(MainListeners.class)
public class ForgotPasswordTest {

	@Test
	public static void verifyResetPasswordSuccessMsg() {

		Properties prop = MainListeners.getProp();
		String userName = prop.getProperty("username");

		LoginPage lp = new LoginPage(MainListeners.getDriver());
		ResetPasswordPage reset = new ResetPasswordPage(MainListeners.getDriver());

		UserActions.clickElement(lp.forgotPasswordLink, "Clicked on forgot password link");
		UserActions.setValue(reset.userName, userName, "entered username");
		UserActions.clickElement(reset.resetPasswdBtn, "clicked on reset password button");
		String resetMsg = reset.resetPswdMsg.getText();
		Assert.assertEquals(resetMsg, "Reset Password link sent successfully");

	}

}
