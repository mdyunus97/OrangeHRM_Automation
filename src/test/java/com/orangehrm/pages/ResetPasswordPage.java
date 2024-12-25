package com.orangehrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResetPasswordPage {
	static WebDriver driver;

	public ResetPasswordPage(WebDriver d) {
		driver = d;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='username']")
	public WebElement userName;

	@FindBy(xpath = "//button[@type=\"submit\"]")
	public WebElement resetPasswdBtn;

	@FindBy(xpath = "//h6[@class='oxd-text oxd-text--h6 orangehrm-forgot-password-title']")
	public WebElement resetPswdMsg;

}
