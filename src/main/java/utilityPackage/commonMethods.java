package utilityPackage;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.Color;
import org.testng.Assert;

import com.DemoQA.TestBase.TestBase;

public class commonMethods extends TestBase {

	public static void titleValidation (String expectedTitle) {
		String actualTitle = driver.getTitle();

		Assert.assertEquals(actualTitle, expectedTitle);

		if (actualTitle.equals(expectedTitle)) {
			System.out.println("Tab Title Validated");
		}
		else {
			System.out.println("Tab Title not matching with expected title");
		}
	}

	public static void colorValidation(WebElement desiredElement, String expectedColor ) {

		System.out.println("Expected Color Code =" + expectedColor);

		String rgbaColor = desiredElement.getCssValue("background-color");

		Color formatColor = Color.fromString(rgbaColor);

		String actualColor = formatColor.asHex();

		System.out.println("Actual Color Code =" + actualColor);

		if (expectedColor.equals(actualColor)) {
			System.out.println("Color validation successfully done");
		}
	}

	public static void takeScreenShot()  {
		try {
			// Cast WebDriver to TakesScreenshot
			TakesScreenshot screenshot = (TakesScreenshot) driver;

			// Capture screenshot as File
			File srcFile = screenshot.getScreenshotAs(OutputType.FILE);

			// Get the current date and time for Dynamic File Name 
			LocalDateTime currentDateTime = LocalDateTime.now();

			// Define the date-time format
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");

			// Format the current date and time as a string using the defined format
			String dyanamicFileName = currentDateTime.format(formatter);

			// Specify the destination directory and file name
			File destFile = new File("C:\\Users\\ASHISH\\eclipse-workspace\\DemoSiteAutomationE2E\\screenShots\\"+dyanamicFileName+".jpg");

			// Copy file to destination
			FileHandler.copy(srcFile, destFile);

			System.out.println("Screenshot captured and saved at: " + destFile.getAbsolutePath());

		} catch (Exception e) {
			System.out.println("Failed to capture screenshot: " + e.getMessage());
		}
	}

}
