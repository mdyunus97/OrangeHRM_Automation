package com.automationexcercise.listeners;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.automationexcercise.utilities.HelperClass;

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

	private static WebDriver driver;

	public void onStart(ITestContext context) {
		extent = new ExtentReports();
		spark = new ExtentSparkReporter(
				"./reports/" + getCurrentDate() + "/AutomationPage_" + getDateAndTime() + ".html");
		spark.config().thumbnailForBase64(true);
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("Automation Excercise Page Report");
		spark.config().setReportName("Regression suites");
		spark.config().setTimeStampFormat("dd:MMM:yyyy");
		extent.attachReporter(spark);

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://automationexercise.com/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	public void onTestStart(ITestResult result) {
		System.out.println("The test is started and the method is " + result.getName());
		test = extent.createTest(result.getName(), result.getMethod().getDescription());

	}

	public void onTestSuccess(ITestResult result) {
		{
			try {
				test.log(Status.PASS, "STEP PASSED: ", MediaEntityBuilder
						.createScreenCaptureFromBase64String(HelperClass.capture(getDriver())).build());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
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

	public void onTestSkipped(ITestResult result) {
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		onTestFailure(result);
	}

	public void onFinish(ITestContext context) {
		driver.quit();
		extent.flush();
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
