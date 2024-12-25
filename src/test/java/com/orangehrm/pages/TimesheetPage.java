package com.orangehrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TimesheetPage {

	static WebDriver driver;

	public TimesheetPage(WebDriver d) {
		driver = d;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@placeholder=\"Type for hints...\"]")
	public WebElement typeEmpName;

	@FindBy(xpath = "//div[@class='oxd-autocomplete-option']//span[text()=\"Orange  Test\"]")
	public WebElement selectOrngTest;

	@FindBy(xpath = "//button[@type=\"submit\"]")
	public WebElement viewBtn;

	@FindBy(xpath = "//div[@class='orangehrm-timesheet-footer--options']//button[@type=\"button\"]")
	public WebElement createTimeshtBtn;

	@FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
	public WebElement sbmtTmshtBtn;

	@FindBy(xpath = "//button[text()=\" Approve \"]")
	public WebElement approveTmshtBtn;

	@FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-text--subtitle-2']")
	public WebElement tmshtStatus;

	@FindBy(xpath = "//button[text()=\" Reset \"]")
	public WebElement restBtn;
}
