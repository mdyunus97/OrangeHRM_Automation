package com.orangehrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Admin_UserManagementPage {
	static WebDriver driver;

	public Admin_UserManagementPage(WebDriver d) {
		driver = d;
		PageFactory.initElements(driver, this);
	}

	
	//General information
	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[3]")
	public WebElement organization;

	@FindBy(xpath = "(//a[@class='oxd-topbar-body-nav-tab-link'])[1]")
	public WebElement generalInfo;

	@FindBy(xpath = "//div/h6")
	public WebElement generalPageTitle;

	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div/label/span")
	public WebElement editTogle;

	@FindBy(xpath = "(//div/h6/..//following-sibling::form//div/div/div/div/div//following-sibling::div/input[@class='oxd-input oxd-input--active'])[1]")
	public WebElement orgNameField;

	@FindBy(xpath = "(//div/h6/..//following-sibling::form//div/div/div/div/div//following-sibling::div/input[@class='oxd-input oxd-input--active'])[2]")
	public WebElement regNumField;

	@FindBy(xpath = "(//div/h6/..//following-sibling::form//div/div/div/div/div//following-sibling::div/input[@class='oxd-input oxd-input--active'])[3]")
	public WebElement taxIDField;

	@FindBy(xpath = "//div/h6/..//following-sibling::form//div/div/div/div/div//following-sibling::div/div[@class='oxd-select-text oxd-select-text--active']")
	public WebElement countryDropdown;

	@FindBy(xpath = "//button[@type=\"submit\"]")
	public WebElement saveButton;


	//Qualification
	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[4]")
	public WebElement qualificationrpDwn;

	@FindBy(xpath = "//ul[@class='oxd-dropdown-menu']//li[2]//a[@class='oxd-topbar-body-nav-tab-link']")
	public WebElement educationOption;

	@FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
	public WebElement addEducation;

	@FindBy(xpath = "//div/h6")
	public WebElement addEduTitle;

	@FindBy(xpath = "//div[@class='oxd-input-group oxd-input-field-bottom-space']/div[2]/input")
	public WebElement eduTextField;

	@FindBy(xpath = "//button[@type='submit']")
	public WebElement saveEduButton;

	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[3]/div/div[2]/div[1]/div/div[1]/div/div")
	public WebElement firstCheckbox;

	@FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-horizontal-margin']")
	public WebElement deleteSelectedBtn;

	@FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']")
	public WebElement yesDeleteBtn;
}
