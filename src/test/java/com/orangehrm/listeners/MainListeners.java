package com.orangehrm.listeners;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.orangehrm.utilities.HelperClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MainListeners implements ITestListener {

	ExtentReports extent;
	ExtentSparkReporter spark;
	static ExtentTest test;
	static Properties prop;

	public static Properties getProp() {
		return prop;
	}

	public static ExtentTest getTest() {
		return test;
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static void setDriver(WebDriver driver) {
		MainListeners.driver = driver;
	}

	private static WebDriver driver;

	public void onStart(ITestContext context) {
		extent = new ExtentReports();
		spark = new ExtentSparkReporter("./reports/" + getCurrentDate() + "/OrangeHRM_" + getDateAndTime() + ".html");

		spark.config().thumbnailForBase64(true);
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("OrangeHRM Execution report");
		spark.config().setReportName("OrangeHRM Regression suites");
		spark.config().setTimeStampFormat("dd:MMM:yyyy");
		extent.attachReporter(spark);
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream("./src/test/resources/config.properties");

			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}

		String browser = prop.getProperty("browser");
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			if (prop.getProperty("headless").equalsIgnoreCase("true")) {

				options.addArguments("--headless");
			}

			driver = new ChromeDriver(options);

		}

		if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			EdgeOptions options = new EdgeOptions();
			if (prop.getProperty("headless").equalsIgnoreCase("true")) {

				options.addArguments("--headless");
			}
			driver = new EdgeDriver();

		}
		if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		}
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public void onTestStart(ITestResult result) {
		System.out.println("The test is started and the method is " + result.getName());
		test = extent.createTest(result.getName(), result.getMethod().getDescription());

		String browserName = prop.getProperty("browser").toUpperCase();
		Dimension dimension = driver.manage().window().getSize();
		test.info("Browser: " + browserName + ", Resolution: " + dimension);
		Reporter.log("Test: " + result.getName());

	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("The test is success and the method is " + result.getName());

	}

	public void onTestFailure(ITestResult result) {
		Throwable throwvar = result.getThrowable();
		System.out.println("The test is failed and the method is " + result.getName());
		try {
			test.log(Status.FAIL, "STEP FAILED: " + throwvar.getMessage(),
					MediaEntityBuilder.createScreenCaptureFromBase64String(HelperClass.capture(getDriver())).build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("The test is skipped and the method is " + result.getName());

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("The test is started and the method is " + result.getName());

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
		driver.quit();

	}

	public static String getCurrentDate() {

		LocalDate date = LocalDate.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
		String dateFormat = dtf.format(date);

		return dateFormat;
	}

	public static String getDateAndTime() {
		ZonedDateTime zdt = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM_HH_mm_ss");
		String datetimeFormat = dtf.format(zdt);
		return datetimeFormat;
	}

}
