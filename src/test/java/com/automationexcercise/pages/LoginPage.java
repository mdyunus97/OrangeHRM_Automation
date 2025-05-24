package com.automationexcercise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	static WebDriver driver;

	public LoginPage(WebDriver d) {
		driver = d;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//input[@name='email'])[1]")
	public WebElement loginEmailField;

	@FindBy(name = "password")
	public WebElement passwordField;

	@FindBy(xpath = "//input[@name='name']")
	public WebElement nameField;

	@FindBy(xpath = "(//input[@name='email'])[2]")
	public WebElement signUpEmailField;

	@FindBy(xpath = "//*[@id=\"form\"]/div/div/div[1]/div/form/button")
	public WebElement loginButton;

	@FindBy(xpath = "//*[@id=\"form\"]/div/div/div[3]/div/form/button")
	public WebElement signUpButton;

	@FindBy(xpath = "//*[@id=\"form\"]/div/div/div[1]/div/h2")
	public WebElement loginText;

	@FindBy(xpath = "//*[@id=\"form\"]/div/div/div[1]/div/form/p")
	public WebElement loginErrorMsg;
	
	@FindBy(xpath = "//*[@id=\"form\"]/div/div/div[3]/div/form/p")
	public WebElement emailExistMsg;
	
	@FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[8]/a")
	public WebElement contactUsBtn;
	
	@FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a")
	public WebElement testcasesBtn;
	
	@FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a")
	public WebElement productsBtn;
	

}
