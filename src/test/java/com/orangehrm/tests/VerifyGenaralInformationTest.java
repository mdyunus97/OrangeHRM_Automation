package com.orangehrm.tests;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.orangehrm.listeners.MainListeners;
import com.orangehrm.pages.Admin_UserManagementPage;
import com.orangehrm.pages.HomePage;
import com.orangehrm.utilities.HelperClass;
import com.orangehrm.utilities.UserActions;

@Listeners(MainListeners.class)
public class VerifyGenaralInformationTest {

	@Test
	public static void verifyGenaralinfoPage() throws InterruptedException {
		HelperClass.login();

		Admin_UserManagementPage adminPage = new Admin_UserManagementPage(MainListeners.getDriver());
		HomePage homePage = new HomePage(MainListeners.getDriver());
		UserActions.clickElement(homePage.admin, "Clicked on admin");
		UserActions.clickElement(adminPage.organization, "Clicked on organization option");
		UserActions.clickElement(adminPage.generalInfo, "Clicked on general info");
		System.out.println(adminPage.generalPageTitle.isDisplayed());
		HelperClass.logOut();

	}

	@Test
	public static void verify_if_a_user_can_able_to_to_edit_and_save_the_general_information()
			throws InterruptedException, IOException {
		HelperClass.login();
		HomePage homePage = new HomePage(MainListeners.getDriver());
		Admin_UserManagementPage adminPage = new Admin_UserManagementPage(MainListeners.getDriver());

		WebElement hp = homePage.admin;
		UserActions.clickElement(hp, "Clicked on admin button");
		UserActions.clickElement(adminPage.organization, "Clicked on organization");
		UserActions.clickElement(adminPage.generalInfo, "clicked on General info");

		UserActions.clickElement(adminPage.editTogle, "Clicked on edit toggle");
		UserActions.setValue(adminPage.orgNameField, "Updated HRM", "Entered the org name");
		UserActions.setValue(adminPage.regNumField, "2222", "Entered the regestration number");
		UserActions.setValue(adminPage.taxIDField, "7865", "Entered the taxID number");

		UserActions.clickElement(adminPage.saveButton, "Clicked on save button");
		HelperClass.logOut();

	}

}
