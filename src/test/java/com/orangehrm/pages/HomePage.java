package com.orangehrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	static WebDriver driver;

	public HomePage(WebDriver d) {
		driver = d;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span/h6")
	public WebElement dashboardTitle;

	@FindBy(xpath = "//span[@class='oxd-userdropdown-tab']")
	public WebElement profileIcon;

	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/ul/li[4]/a")
	public WebElement logoutButton;

	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a")
	public WebElement admin;

	// Leave Application
	@FindBy(xpath = "//button[@title=\"Apply Leave\"]")
	public WebElement applyLeaveOption;

	// Timesheet Submision
	@FindBy(xpath = "//button[@title=\"Timesheets\"]")
	public WebElement timeSheetbtn;

	// Recruitment
	@FindBy(xpath = "//span[text()='Recruitment']")
	public WebElement recruitmentOption;

}
