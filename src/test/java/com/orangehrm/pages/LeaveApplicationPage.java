package com.orangehrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeaveApplicationPage {
	static WebDriver driver;

	public LeaveApplicationPage(WebDriver d) {
		driver = d;
		PageFactory.initElements(driver, this);
	}

	// Leave Application
	@FindBy(xpath = "//div[@class='oxd-select-text oxd-select-text--active']")
	public WebElement leaveType;

	@FindBy(xpath = "//span[text()=\"CAN - FMLA\"]")
	public WebElement leaveTypeOption;

	@FindBy(xpath = "(//div/div/div/div//input[@class='oxd-input oxd-input--active'])[1]")
	public WebElement fromDate;

	@FindBy(xpath = "//div[text()=\"10\"]")
	public WebElement selectFromDate;

	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/div/div/input")
	public WebElement todate;

	@FindBy(xpath = "//div[text()=\"12\"]")
	public WebElement selectToDate;

	@FindBy(xpath = "(//div[@class='oxd-select-text oxd-select-text--active'])[2]")
	public WebElement partialDays;

	@FindBy(xpath = "//span[text()='All Days']")
	public WebElement selectAllDays;

	@FindBy(xpath = "(//div[@class='oxd-select-text-input'])[3]")
	public WebElement durationOption;

	@FindBy(xpath = "//span[text()='Specify Time']")
	public WebElement specifyTime;

	@FindBy(xpath = "//button[text()=' Apply ']")
	public WebElement applyBtn;

	@FindBy(xpath = "//div[@class=\"oxd-toast-content oxd-toast-content--success\"]")
	public WebElement succesLeaveApplimsg;

}
