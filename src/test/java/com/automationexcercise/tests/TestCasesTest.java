package com.automationexcercise.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.automationexcercise.listeners.MainListeners;
import com.automationexcercise.pages.LoginPage;
import com.automationexcercise.pages.TestCasesPage;
import com.automationexcercise.utilities.UserActions;

@Listeners(MainListeners.class)
public class TestCasesTest {

	@Test
	public static void verifyTestCasesTitle() {
		TestCasesPage tp = new TestCasesPage(MainListeners.getDriver());
		LoginPage lp = new LoginPage(MainListeners.getDriver());

		UserActions.clickElement(lp.testcasesBtn);
		UserActions.isVisible(tp.testCasesTitle);

	}
}
