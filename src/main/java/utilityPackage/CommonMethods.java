package utilityPackage;

import static org.testng.Assert.assertFalse;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.NoSuchElementException;

import javax.imageio.ImageIO;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import com.DemoQA.TestBase.TestBase;
import com.aventstack.extentreports.Status;

import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class CommonMethods extends TestBase {

	public static void titleValidation (String expectedTitle) {
		
		wait.until(ExpectedConditions.titleIs(expectedTitle));
		
		String actualTitle = driver.getTitle();

		//	Assert.assertEquals(actualTitle, expectedTitle);

		if (actualTitle.equals(expectedTitle)) {
			extentTest.get().log(Status.PASS, "Tab title validated successfully");
		}
		else {
			extentTest.get().log(Status.WARNING, "Tab title validation failed : Not matching with expected title");
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

	public static void beforeActionSuccessMessage(WebElement txt_toasterSuccessMessage_employeePage) {

		try {
			if (!txt_toasterSuccessMessage_employeePage.isDisplayed()) {
				extentTest.get().log(Status.PASS, "Toastr success message is not displayed before performing action, as expected");
			}
			else {
				extentTest.get().log(Status.FAIL, "Unexpected : Toastr success message is already displayed before performing action");
			}
		} catch (Exception e) {
			// If the element is not found in the DOM, it means it's not present, which is what we expect here
			extentTest.get().log(Status.PASS, "Toastr success message element is not present before performing action, as expected");
		}

	}

	public static void afterActionSuccessMessage(WebElement txt_toasterSuccessMessage_employeePage) {

		try {
			if (txt_toasterSuccessMessage_employeePage.isDisplayed()) {
				extentTest.get().log(Status.PASS, "Toastr success message is now displayed after performing action");
			} 

			//			else {
			//				extentTest.get().log(Status.FAIL, "Unexpected: Toastr success message is still not displayed after performing action");
			//			}

		} catch (Exception e) {
			// If the element is still not found, something went wrong
			extentTest.get().log(Status.FAIL, "Failed: Toastr success message element is not present even after performing action");
			throw e;
		}
	}

	public static void colorValidation(WebElement desiredElement, String expectedColor ) {

		System.out.println("Expected Color Code =" + expectedColor);

		String rgbaColor = desiredElement.getCssValue("background-color");

		Color formatColor = Color.fromString(rgbaColor);

		String actualColor = formatColor.asHex();

		if (expectedColor.equals(actualColor)) {
			extentTest.get().log(Status.PASS, "Color Validation : Actual color code matches with expected");
		}
		else {
			extentTest.get().log(Status.WARNING, "Color Validation : Actual color code does NOT matched with expected");
		}
	}

	public static void imageComparison(String expectedImage, String actualImage) {
		try {

			BufferedImage expectedFile = ImageIO.read(new File(expectedImage));		

			BufferedImage actualFile = ImageIO.read(new File(actualImage));

			ImageDiffer imgDiffer = new ImageDiffer();

			ImageDiff difference = imgDiffer.makeDiff(expectedFile, actualFile);


			if (difference.hasDiff()==false) {

				extentTest.get().log(Status.PASS, "Image Comparison : Actual image matches with expected");
			}
			else {
				extentTest.get().log(Status.ERROR, "Image Comparison : Actual image NOT matches with expected");
			}

		}
		catch (IOException e) {

			extentTest.get().log(Status.WARNING, "An error occurred during image comparison : " + e.getMessage());

			throw new RuntimeException("Image comparison failed due to an IOException : ", e);
		}
	}

	public static String readExcelData (String sheetPath, int rowNum, int cellNum) {
		
		try {
			//Create object file to set file
			File exfile = new File(sheetPath);
			
			//Create object file input stream
			FileInputStream infile = new FileInputStream(exfile);

			//Create object of XSSFWorkBook
			XSSFWorkbook new_book = new XSSFWorkbook(infile);
			
			//Create object for sheet
			XSSFSheet exsheet = new_book.getSheetAt(0);	//Sheet index should set as 0 

			//Row1
			XSSFRow exrow = exsheet.getRow(rowNum);			//Row index starts from 0

			//Column
			String cellValue = exrow.getCell(cellNum).getStringCellValue();
			
			extentTest.get().log(Status.PASS, "Successfully taken inputs from excel file");
		
			return cellValue;
		}
		catch(IOException e){

			extentTest.get().log(Status.WARNING, "An error occurred during reading excel data : " + e.getMessage());

			throw new RuntimeException("Read excel data failed due to an IOException : ", e);
		}
	}
	
public static void writeExcelData (String sheetPath, int rowNum, int cellNum, String desiredInput) {
		
		try {
			//Create object file to set file
			File exfile = new File(sheetPath);
			
			//Create object file input stream
			FileInputStream infile = new FileInputStream(exfile);

			//Create object of XSSFWorkBook
			XSSFWorkbook new_book = new XSSFWorkbook(infile);
			
			//Create object for sheet
			XSSFSheet exsheet = new_book.getSheetAt(0);	//Sheet index should set as 0 

			//To set the data in excel file
			exsheet.getRow(rowNum).createCell(cellNum).setCellValue(desiredInput);
			
			FileOutputStream fos = new FileOutputStream(exfile);
			
			new_book.write(fos);
			
			new_book.close();
		}
		catch(IOException e){

			extentTest.get().log(Status.WARNING, "An error occurred during writing excel data : " + e.getMessage());

			throw new RuntimeException("Write excel data failed due to an IOException : ", e);
		}
	}


//Class brace	
}

