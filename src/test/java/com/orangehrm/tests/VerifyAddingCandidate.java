package com.orangehrm.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.orangehrm.listeners.MainListeners;
import com.orangehrm.pages.HomePage;
import com.orangehrm.pages.RecruitmentPage;
import com.orangehrm.utilities.HelperClass;
import com.orangehrm.utilities.UserActions;

@Listeners(MainListeners.class)
public class VerifyAddingCandidate {

	@Test(description = "Verification of adding candidate test")
	public static void verifyAddCandidate() throws InterruptedException {

		HelperClass.login();
		HomePage home = new HomePage(MainListeners.getDriver());

		String projectPath = System.getProperty("user.dir");
		String fileUploadPath = "/dataFiles/fileuploadselenium.txt";

		RecruitmentPage rp = new RecruitmentPage(MainListeners.getDriver());

		UserActions.clickElement(home.recruitmentOption, "clicked on recruitement option");
		UserActions.clickElement(rp.addBtn, "Clicked on add button");
		UserActions.setValue(rp.firstNameField, "Testing", "entered firstname");
		UserActions.setValue(rp.lastNameField, "practice", "entered last name");
		UserActions.clickElement(rp.vacancyDrpdwn, "clicked on vacancy dropdown");
		UserActions.clickElement(rp.selectVacancy, "selected vacancy");
		UserActions.setValue(rp.emailField, "practice@gmail.com", "entered email address");
		UserActions.verifyText(rp.resumeLabel, "alter", "Verifying the resule label text");
		UserActions.setValue(rp.fileUploadBtn, projectPath + fileUploadPath, "File is uploaded");
		UserActions.clickElement(rp.saveBtn, "clicked on save button");

		UserActions.verifyText(rp.successMsgText, "Successfully Saved", "verified the success message");
		UserActions.verifyTextContains(rp.successMsgText, "Saved", "Verying if the success message contains text");
		UserActions.clickElement(rp.shortListBtn, "clicked on shortlist button");
		UserActions.clickElement(rp.saveBtn, "clicked on save button");

//		HelperClass.logOut();
	}

}
