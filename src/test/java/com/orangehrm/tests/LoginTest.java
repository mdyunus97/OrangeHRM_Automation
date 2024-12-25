package com.orangehrm.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.orangehrm.listeners.MainListeners;
import com.orangehrm.pages.HomePage;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.utilities.HelperClass;
import com.orangehrm.utilities.UserActions;

@Listeners(MainListeners.class)
public class LoginTest {

	@Test(priority = 2,description = "To verify successfull Loggin into the OrangeHRM application")
	public static void successfullLogin() throws InterruptedException {

		HelperClass.login();
		HomePage hp = new HomePage(MainListeners.getDriver());

		String dashboardText = hp.dashboardTitle.getText();
		if (dashboardText.equals("Dashboard")) {
			System.out.println("The home page is visible");
		} else {
			System.out.println("The home page is not visible");
		}
		System.out.println(hp.dashboardTitle.isDisplayed());

		HelperClass.logOut();// logging off
	}

	@Test(priority = 1, description = "To verify Unsuccessfull Loggin into the OrangeHRM application")
	public static void verifyLoginError() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(MainListeners.getDriver());
		UserActions.setValue(lp.username, "Admin123", "Entered the username");
		UserActions.setValue(lp.password, "admin", "Entered the password");
		UserActions.clickElement(lp.loginButton, "Clicked on login button");
		Thread.sleep(3000);
		lp.loginError.isDisplayed();
		System.out.println(lp.loginError.getText());
		Assert.assertEquals(lp.loginError.getText(), "Invalid credentials");

	}

}
