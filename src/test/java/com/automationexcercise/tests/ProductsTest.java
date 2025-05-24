package com.automationexcercise.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.automationexcercise.listeners.MainListeners;
import com.automationexcercise.pages.LoginPage;
import com.automationexcercise.pages.ProductsPage;
import com.automationexcercise.utilities.UserActions;

@Listeners(MainListeners.class)
public class ProductsTest {
	@Test
	public static void VerifyProductDetailsPage() {

		LoginPage lp = new LoginPage(MainListeners.getDriver());
		ProductsPage pp = new ProductsPage(MainListeners.getDriver());

		UserActions.clickElement(lp.productsBtn);
		UserActions.isVisible(pp.productTitle);
		UserActions.isVisible(pp.productsList);

		UserActions.scrollTo(pp.firstProduct);
//		element.click();

		UserActions.clickElement(pp.firstProduct);
		UserActions.isVisible(pp.productAvaialability);
		UserActions.isVisible(pp.productBrand);
		UserActions.isVisible(pp.productCatogory);
		UserActions.isVisible(pp.productCondition);
		UserActions.isVisible(pp.productName);
	}
}
