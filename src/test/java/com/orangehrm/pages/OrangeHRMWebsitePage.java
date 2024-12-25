package com.orangehrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRMWebsitePage {

	static WebDriver driver;

	public OrangeHRMWebsitePage(WebDriver d) {
		driver = d;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//button[@class='btn btn-ohrm btn-contact-sales'])[2]")
	public WebElement bookADemoBtn;
	
	

}
