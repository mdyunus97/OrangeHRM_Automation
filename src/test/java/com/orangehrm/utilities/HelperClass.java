package com.orangehrm.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.orangehrm.listeners.MainListeners;
import com.orangehrm.pages.HomePage;
import com.orangehrm.pages.LoginPage;

public class HelperClass {
	static WebDriver driver;

	public static void login() throws InterruptedException {
		Properties prop = MainListeners.getProp();
		String userName = readSpecificData("UserName");
		String password = readSpecificData("Password");

		LoginPage lp = new LoginPage(MainListeners.getDriver());
		UserActions.setValue(lp.username, userName, "Username entered succesfully");
		UserActions.setValue(lp.password, password, "Password entered successfully");
		UserActions.clickElement(lp.loginButton, "Clicked on login button");

		Thread.sleep(3000);
	}

	public static void logOut() {
		HomePage hp = new HomePage(MainListeners.getDriver());
		UserActions.clickElement(hp.profileIcon, "Clicked on profile icon");
		UserActions.clickElement(hp.logoutButton, "Clicked on logout button");

	}

	public static void takeSceenshot() throws IOException {

		TakesScreenshot scr = ((TakesScreenshot) MainListeners.getDriver());
		File sourceFile = scr.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./screenshots/OrangeHRM" + System.currentTimeMillis() + ".png");
		FileUtils.copyFile(sourceFile, destFile);
	}

	public static String capture(WebDriver driver) throws IOException {
		TakesScreenshot sc = (TakesScreenshot) driver;
		return sc.getScreenshotAs(OutputType.BASE64);

	}
//		String errssflpath = null;
//		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		File Dest = new File("./screenshots/Image" + System.currentTimeMillis() + ".png");
//		errssflpath = Dest.getAbsolutePath();
//		Files.copy(scrFile.toPath(), Dest.toPath());
//		return errssflpath;

	public static void screenshotForReport(String message) {
		ExtentTest test = MainListeners.getTest();
		try {
			test.log(Status.PASS, "STEP Passed: " + message, MediaEntityBuilder
					.createScreenCaptureFromBase64String(HelperClass.capture(MainListeners.getDriver())).build());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static String readSpecificData(String colName) {
		String testData = "";
		try {
			String filePath = "./dataFiles/testData.xlsx";
			FileInputStream inputStream = new FileInputStream(filePath);
			Workbook workbook = new XSSFWorkbook(inputStream);
			Sheet sheet = workbook.getSheetAt(0);

			int rowsCount = sheet.getLastRowNum();
			int cellCount = sheet.getRow(0).getLastCellNum();

			Row row = sheet.getRow(0);

			for (int i = 0; i < cellCount; i++) {
				Cell cellValue = row.getCell(i);
				if (cellValue.getStringCellValue().equalsIgnoreCase(colName)) {
					int cellnum = i;

					for (int j = 1; j <= rowsCount; j++) {
						Row rownum = sheet.getRow(j);
						Cell celldata = rownum.getCell(cellnum);
						if (celldata.getStringCellValue() != null) {
							testData = celldata.getStringCellValue();
						}
					}
				}
			}

			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return testData;
	}

}
