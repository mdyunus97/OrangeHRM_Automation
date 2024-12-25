package com.orangehrm.tests;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.orangehrm.listeners.MainListeners;
import com.orangehrm.pages.Admin_UserManagementPage;
import com.orangehrm.pages.HomePage;
import com.orangehrm.utilities.HelperClass;
import com.orangehrm.utilities.UserActions;

@Listeners(MainListeners.class)
public class VerifyQualificationTest {

	@Test
	public static void verifyAddandDeleteEducation() throws InterruptedException, IOException {

		// Add education
		HelperClass.login();

		Admin_UserManagementPage adminPage = new Admin_UserManagementPage(MainListeners.getDriver());
		HomePage homePage = new HomePage(MainListeners.getDriver());
		UserActions.clickElement(homePage.admin, "Clicked on admin option");
		UserActions.clickElement(adminPage.qualificationrpDwn, "Clicked on qualification dropdown");
		UserActions.clickElement(adminPage.educationOption, "Selected education option");
		UserActions.clickElement(adminPage.addEducation, "Clicked on add education button");

		System.out.println(adminPage.addEduTitle.isDisplayed());
		String s = RandomStringUtils.randomAlphabetic(4);
		adminPage.eduTextField.sendKeys("Bachelor's of " + s);
		System.out.println(adminPage.eduTextField.getText());
		UserActions.clickElement(adminPage.saveEduButton, "Clicked on save button");
		Thread.sleep(3000);

		// delete education
		UserActions.clickElement(adminPage.firstCheckbox, "Clicked on firstcheck box");
		UserActions.clickElement(adminPage.deleteSelectedBtn, "Clicked on delete selection button");
		UserActions.clickElement(adminPage.yesDeleteBtn, "Clicked on yes delete option");
		Thread.sleep(3000);
		HelperClass.logOut();
	}

}
