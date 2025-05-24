package com.automationexcercise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {

	static WebDriver driver;

	public ContactUsPage(WebDriver d) {
		driver = d;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"contact-page\"]/div[1]/div/div/h2")
	public WebElement contactUsTitle;

	@FindBy(xpath = "//input[@name=\"name\"]")
	public WebElement nameField;

	@FindBy(xpath = "//input[@name=\"email\"]")
	public WebElement emailField;

	@FindBy(xpath = "//input[@name=\"subject\"]")
	public WebElement subjectField;

	@FindBy(xpath = " //textarea[@name=\"message\"]")
	public WebElement messageField;

	@FindBy(xpath = "//input[@type=\"file\"]")
	public WebElement fileUpload;

	@FindBy(xpath = "//input[@type=\"submit\"]")
	public WebElement submibBtn;

}
