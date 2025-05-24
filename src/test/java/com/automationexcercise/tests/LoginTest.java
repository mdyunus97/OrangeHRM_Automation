package com.automationexcercise.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.automationexcercise.listeners.MainListeners;
import com.automationexcercise.utilities.HelperClass;

@Listeners(MainListeners.class)
public class LoginTest {

	@Test
	public static void login() {

		HelperClass.login();
		HelperClass.logOut();
		
	}
}
