package utilityPackage;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.Color;
import org.testng.Assert;

import com.DemoQA.TestBase.TestBase;
import com.aventstack.extentreports.Status;

public class CommonMethods extends TestBase {

	public static void titleValidation (String expectedTitle) {
		String actualTitle = driver.getTitle();

		//	Assert.assertEquals(actualTitle, expectedTitle);

		if (actualTitle.equals(expectedTitle)) {
		//	extentTest.log(LogStatus.PASS, "Tab title validated successfully");
		}
		else {
		//	extentTest.log(LogStatus.ERROR, "Tab title validation failed : Not matching with expected title");
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

	public static String takeScreenShot(WebDriver driver, String screenshotName)  {

		// Cast WebDriver to TakesScreenshot
		TakesScreenshot screenshot = (TakesScreenshot) driver;

		// Capture screenshot as File
		File srcFile = screenshot.getScreenshotAs(OutputType.FILE);

		// Format the current date and time as a string using the defined format
		String dynamicFileName = screenshotName+DetailsDataProvider.getCurrentTimeStamp();

		// Specify the destination directory and file name
		String directoryPath = userDirectory+"Screenshots\\";
		String filePathDestination = directoryPath + dynamicFileName + ".jpg";

		File destFile = new File(filePathDestination);			

		try {	// Copy file to destination
			FileHandler.copy(srcFile, destFile);

			extentTest.get().log(Status.PASS, "Screenshot captured and saved at : " + destFile.getAbsolutePath());
	

		} catch (Exception e) {
			extentTest.get().log(Status.ERROR,"Failed to capture screenshot : " + e.getMessage());
		}

		return filePathDestination;
	}

	public static void setDriver(WebDriver driverInstance) {
		driver = driverInstance;
	}

}
