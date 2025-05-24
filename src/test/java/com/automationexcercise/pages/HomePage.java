package com.automationexcercise.pages;

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
	
	@FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a")
	public WebElement loggedInText;
	
	@FindBy(xpath ="//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")
	public WebElement logoutBtn;
	
}
