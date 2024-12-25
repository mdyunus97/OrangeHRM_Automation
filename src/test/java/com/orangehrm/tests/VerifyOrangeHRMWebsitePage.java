package com.orangehrm.tests;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.orangehrm.listeners.MainListeners;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.utilities.UserActions;

@Listeners(MainListeners.class)
public class VerifyOrangeHRMWebsitePage {

	@Test
	public static void verifyWebsitePage() throws InterruptedException {
		LoginPage lp = new LoginPage(MainListeners.getDriver());
		UserActions.clickElement(lp.websiteLink, "clicked on ornage hrom navigation link");
		Thread.sleep(3000);

		ArrayList<String> tabs = new ArrayList<String>(MainListeners.getDriver().getWindowHandles());

		MainListeners.getDriver().switchTo().window(tabs.get(1));
		String expTitle = MainListeners.getDriver().getTitle();
		System.out.println(expTitle);
		System.out.println(MainListeners.getDriver().getCurrentUrl());
		Assert.assertEquals("https://www.orangehrm.com/", MainListeners.getDriver().getCurrentUrl());

		Assert.assertEquals("Human Resources Management Software | OrangeHRM", expTitle);
	}
}
