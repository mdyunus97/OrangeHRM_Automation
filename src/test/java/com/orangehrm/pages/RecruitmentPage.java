package com.orangehrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RecruitmentPage {
	static WebDriver driver;

	public RecruitmentPage(WebDriver d) {
		driver = d;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//label[text()='Job Title']/../following-sibling::div")
	public WebElement jobTitleDrpdwn;

	@FindBy(xpath = "//div[text()='Account Assistant']")
	public WebElement selectAccountAssistant;

	// @FindBy(xpath="//label[text()='Vacancy']/../following-sibling::div")
	// public WebElement vacancyDrpdwn;

	@FindBy(xpath = "//div[@class='oxd-select-option']//span[text()='Junior Account Assistant']")
	public WebElement selectJuniorAccountAssistant;

	@FindBy(xpath = "//label[text()='Hiring Manager']/../following-sibling::div")
	public WebElement hiringManagerDrpdwn;

	@FindBy(xpath = "//div[@class='oxd-select-option']//span[text()='Rahul Patil']")
	public WebElement selectHiringManager;

	@FindBy(xpath = "//label[text()='Status']/../following-sibling::div")
	public WebElement statusDrpdwn;

	@FindBy(xpath = "//div[@class='oxd-select-option']//span[text()='Shortlisted']")
	public WebElement selectStatus;

	@FindBy(xpath = "//input[@placeholder=\"Type for hints...\"]")
	public WebElement candidateNameField;

	@FindBy(xpath = "//div[@class='oxd-autocomplete-option']//span[text()='KAREEM mohamed ABDELALEEM']")
	public WebElement selectCandidateName;

	@FindBy(xpath = "//label[text()='Date of Application']/../following-sibling::div")
	public WebElement fromDateDrpdwn;

	@FindBy(xpath = "//div[@class=\"--holiday-full oxd-calendar-date --selected --today\"]")
	public WebElement selectTodaysDate;

	@FindBy(xpath = "//div[@class='oxd-date-input']//input[@placeholder=\"To\"]")
	public WebElement toDatedrpdwn;

	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/div/div[4]/div/div[2]/div/div[2]/div/div[3]/div[31]/div")
	public WebElement selectToDate;

	@FindBy(xpath = "//label[text()='Method of Application']/../following-sibling::div")
	public WebElement methodOfappdrpdown;

	@FindBy(xpath = "//div/span[text()='Manual']")
	public WebElement selectManual;

	@FindBy(xpath = "//button[@type=\"submit\"]")
	public WebElement searchBtn;

	// AddingCandidate
	@FindBy(xpath = "//i[@class='oxd-icon bi-plus oxd-button-icon']")
	public WebElement addBtn;

	@FindBy(xpath = "//input[@placeholder=\"First Name\"]")
	public WebElement firstNameField;

	@FindBy(xpath = "//input[@placeholder=\"Last Name\"]")
	public WebElement lastNameField;

	@FindBy(xpath = "//label[text()='Vacancy']/../following-sibling::div")
	public WebElement vacancyDrpdwn;

	@FindBy(xpath = "(//div[@class='oxd-select-option'])[2]")
	public WebElement selectVacancy;

	@FindBy(xpath = "(//input[@placeholder=\"Type here\"])[1]")
	public WebElement emailField;

	@FindBy(xpath = "//input[@type=\"file\"]")
	public WebElement fileUploadBtn;

	@FindBy(xpath = "//button[@type=\"submit\"]")
	public WebElement saveBtn;

	@FindBy(xpath = "(//div[@class=\"oxd-form-row\"]/following-sibling::div)[3]/div/div/div/div/div/label")
	public WebElement resumeLabel;

	@FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text']")
	public WebElement successMsgText;

	@FindBy(xpath = "//button[@class=\"oxd-button oxd-button--medium oxd-button--success\"]")
	public WebElement shortListBtn;

	@FindBy(xpath = "//button[@class=\\\"oxd-button oxd-button--medium oxd-button--success\\\"]")
	public WebElement scheduleInterviewBtn;

	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input")
	public WebElement intervieverFiled;

	@FindBy(xpath = "(//div[@class=\"oxd-autocomplete-option\"])[1]")
	public WebElement selectInterviewver;

	@FindBy(xpath = "//input[@placeholder=\"yyyy-dd-mm\"]")
	public WebElement dateField;

	@FindBy(xpath = "//div[@class=\"oxd-calendar-date --selected --today\"]")
	public WebElement selectDate;
	@FindBy(xpath = "//input[@class=\"oxd-input oxd-input--active oxd-input--error\"]")
	public WebElement interviewTitle;

}
