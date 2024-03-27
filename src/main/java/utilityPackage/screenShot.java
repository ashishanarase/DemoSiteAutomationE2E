package utilityPackage;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import com.DemoQA.TestBase.TestBase;

public class screenShot extends TestBase {

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
