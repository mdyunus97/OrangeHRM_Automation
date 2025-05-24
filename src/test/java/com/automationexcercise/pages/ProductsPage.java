package com.automationexcercise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {

	static WebDriver driver;

	public ProductsPage(WebDriver d) {
		driver = d;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "/html/body/section[2]/div/div/div[2]/div/h2")
	public WebElement productTitle;

	@FindBy(xpath = "/html/body/section[2]/div/div/div[2]/div")
	public WebElement productsList;

	@FindBy(xpath = "//a[@href=\"/product_details/1\"]")
	public WebElement firstProduct;

	@FindBy(xpath = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/h2")
	public WebElement productName;

	@FindBy(xpath = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[1]")
	public WebElement productCatogory;

	@FindBy(xpath = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[2]")
	public WebElement productAvaialability;

	@FindBy(xpath = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[3]")
	public WebElement productCondition;
	@FindBy(xpath = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[4]")
	public WebElement productBrand;
}
