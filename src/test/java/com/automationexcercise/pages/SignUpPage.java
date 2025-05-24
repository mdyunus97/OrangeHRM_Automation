package com.automationexcercise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {
	static WebDriver driver;

	public SignUpPage(WebDriver d) {
		driver = d;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"form\"]/div/div/div/div[1]/h2/b")
	public WebElement accountInfoTitle;

	@FindBy(css = "#id_gender1")
	public WebElement titleRadio;

	@FindBy(css = "#password")
	public WebElement passwordField;

	@FindBy(css = "#days")
	public WebElement daySelection;

	@FindBy(css = "#months")
	public WebElement monthSelection;

	@FindBy(css = "#years")
	public WebElement yearSelection;

	@FindBy(css = "#newsletter")
	public WebElement signUpCheckbox;

	@FindBy(css = "#optin")
	public WebElement receiveCheckbox;

	@FindBy(css = "#first_name")
	public WebElement firstNameField;

	@FindBy(css = "#last_name")
	public WebElement lastNameField;

	@FindBy(css = "#address1")
	public WebElement addressField;

	@FindBy(css = "#country")
	public WebElement countryDropdown;

	@FindBy(css = "#state")
	public WebElement stateField;

	@FindBy(css = "#city")
	public WebElement cityField;

	@FindBy(css = "#zipcode")
	public WebElement zipcodeField;

	@FindBy(css = "#mobile_number")
	public WebElement mobileField;
	
	@FindBy(xpath = "//*[@id=\"form\"]/div/div/div/div[1]/form/button")
	public WebElement createAccountbutton;
	
	@FindBy(xpath = "//*[@id=\"form\"]/div/div/div/h2/b")
	public WebElement accountCreatedMsg;
	
	@FindBy(xpath = "//*[@id=\"form\"]/div/div/div/div/a")
	public WebElement countinueButton;
	
	@FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a")
	public WebElement loggedInUser;
	
	
	
}
