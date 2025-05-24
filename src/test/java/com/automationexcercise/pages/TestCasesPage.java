package com.automationexcercise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestCasesPage {
	static WebDriver driver;

	public TestCasesPage(WebDriver d) {
		driver = d;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@id=\"form\"]/div/div[1]/div/h2/b")
	public WebElement testCasesTitle;
	
	
}
