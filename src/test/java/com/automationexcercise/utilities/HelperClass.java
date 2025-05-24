package com.automationexcercise.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.automationexcercise.listeners.MainListeners;
import com.automationexcercise.pages.HomePage;
import com.automationexcercise.pages.LoginPage;

public class HelperClass {
	static WebDriver driver;

	public static void login() {

		HomePage hp = new HomePage(MainListeners.getDriver());
		LoginPage lp = new LoginPage(MainListeners.getDriver());
		UserActions.verifyText(lp.loginText, "Login to your account");
		UserActions.setValue(lp.loginEmailField, "regester7@mail.com");
		UserActions.setValue(lp.passwordField, "Password@97");
		UserActions.clickElement(lp.loginButton);
		UserActions.isVisible(hp.loggedInText);
	}

	public static void takeSceenshot() throws IOException {

		TakesScreenshot scr = ((TakesScreenshot) MainListeners.getDriver());
		File sourceFile = scr.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./screenshots/AutomationPractice" + System.currentTimeMillis() + ".png");
		FileUtils.copyFile(sourceFile, destFile);
	}

	public static String capture(WebDriver driver) throws IOException {
		TakesScreenshot sc = (TakesScreenshot) driver;
		return sc.getScreenshotAs(OutputType.BASE64);

	}

	public static void logOut() {
		HomePage hp = new HomePage(MainListeners.getDriver());
		LoginPage lp = new LoginPage(MainListeners.getDriver());
		UserActions.clickElement(hp.logoutBtn);
		UserActions.isVisible(lp.loginText);

	}
}
