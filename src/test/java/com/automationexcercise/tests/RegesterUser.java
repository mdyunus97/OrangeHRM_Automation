package com.automationexcercise.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.automationexcercise.listeners.MainListeners;
import com.automationexcercise.pages.LoginPage;
import com.automationexcercise.pages.SignUpPage;
import com.automationexcercise.utilities.UserActions;

@Listeners(MainListeners.class)
public class RegesterUser {

	@Test
	public static void regester() throws InterruptedException {

		LoginPage lp = new LoginPage(MainListeners.getDriver());
		SignUpPage sp = new SignUpPage(MainListeners.getDriver());

		UserActions.setValue(lp.nameField, "Man7");
		UserActions.setValue(lp.signUpEmailField, "regester7@mail.com");
		UserActions.clickElement(lp.signUpButton);

		String expectedTitle = sp.accountInfoTitle.getText();
		String actualitle = "ENTER ACCOUNT INFORMATION";
		Assert.assertEquals(actualitle, expectedTitle);

		UserActions.clickElement(sp.titleRadio);
		UserActions.setValue(sp.passwordField, "Password@97");

		UserActions.selectDropdownbyValue(sp.daySelection, "20");
		UserActions.selectDropdownbyValue(sp.monthSelection, "6");
		UserActions.selectDropdownbyValue(sp.yearSelection, "1997");

		UserActions.clickElement(sp.signUpCheckbox);
		UserActions.clickElement(sp.receiveCheckbox);
		UserActions.setValue(sp.firstNameField, "Mahammed");
		UserActions.setValue(sp.lastNameField, "yunus");

		UserActions.setValue(sp.addressField, "Bangalore");
		UserActions.selectDropdownbyValue(sp.countryDropdown, "India");
		UserActions.setValue(sp.stateField, "Karnataka");
		UserActions.setValue(sp.cityField, "Hassan");
		UserActions.setValue(sp.zipcodeField, "573134");
		UserActions.setValue(sp.mobileField, "9696969696");
		UserActions.clickElement(sp.createAccountbutton);

		boolean res = sp.accountCreatedMsg.isDisplayed();
		System.out.println(res);

	}

}
