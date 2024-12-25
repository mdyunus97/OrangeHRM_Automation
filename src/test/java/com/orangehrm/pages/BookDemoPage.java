package com.orangehrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookDemoPage {
	static WebDriver driver;

	public BookDemoPage(WebDriver d) {
		driver = d;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name=\"FullName\"]")
	public WebElement fullNameField;

	@FindBy(xpath = "//input[@name=\"Contact\"]")
	public WebElement phoneNumberField;

	@FindBy(xpath = "//input[@name=\"Email\"]")
	public WebElement businessEmail;

	@FindBy(xpath = "//input[@name=\"CompanyName\"]")
	public WebElement companyName;

	@FindBy(xpath = "//select[@name=\"Country\"]")
	public WebElement countryDrpdwn;

	@FindBy(xpath = "//select[@name=\"NoOfEmployees\"]")
	public WebElement noOfEmployeesDrpdwn;

	@FindBy(xpath = "//*[@id=\"recaptcha-anchor-label\"]")
	public WebElement imNotRobot;

	@FindBy(xpath = "//input[@name=\"action_submitForm\"]")
	public WebElement getAFreeDemoBtn;
	
	@FindBy(css = ".thank-page-info")
	public WebElement confrmationMsg;
	

}
