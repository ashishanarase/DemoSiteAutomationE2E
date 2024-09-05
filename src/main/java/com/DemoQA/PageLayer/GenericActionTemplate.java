package com.DemoQA.PageLayer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.DemoQA.TestBase.TestBase;
import com.aventstack.extentreports.Status;

public class GenericActionTemplate extends TestBase {

	public static final int maxWaitTime = 15;

	// Constructor to initialize WebDriver, WebDriverWait, and ExtentTest
	public GenericActionTemplate() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(maxWaitTime)); // You can adjust the timeout duration   
	}

	// Method to wait for an element to be visible only
	public void visibilityCheck(WebElement element) {

		String name = element.getText();  

		try {	        	
			wait.until(ExpectedConditions.visibilityOf(element));
			element.click();
			extentTest.get().log(Status.PASS, "Desired element visible : " + name +" ");
		} catch (Exception e) {
			extentTest.get().log(Status.FAIL, "Desired element not visible : " + name + " | Exception: " + e.getMessage());
			throw e;
		}
	}


	// Method to wait for an element to be clickable and then click
	public void clickButton(WebElement element) {
		String name = element.getText();  

		try {	        	
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
			extentTest.get().log(Status.PASS, "Clicked on element : " + name +" button");
		} catch (Exception e) {
			extentTest.get().log(Status.FAIL, "Failed to click on element : " + name + " | Exception: " + e.getMessage());
			throw e;
		}
	}



	// Method to validate checkbox be click 
	public void clickCheckBox(WebElement element) {
		String name = element.getText();  

		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			if (element.isSelected()) {
				extentTest.get().log(Status.WARNING, "CheckBox is selected already : " + name +" button");
			}

			else if (!element.isSelected()) {
				extentTest.get().log(Status.PASS, "Checkbox is available to select : " + name +" button");
				element.click();
				extentTest.get().log(Status.PASS, "Clicked on checkbox : " + name +" field");
			}
			else {
				extentTest.get().log(Status.WARNING, "CheckBox is selected neither selected nor available to select : " + name +" button");
			}

		} catch (Exception e) {
			extentTest.get().log(Status.FAIL, "Failed to click on element : " + name + " | Exception: " + e.getMessage());
			throw e;
		}
	} 


	// Method to wait for an element to be visible and then send keys, with logging
	public void enterText(WebElement element, String text) {
		String name = element.getText();   

		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			element.clear();
			element.sendKeys(text);
			//	extentTest.log(LogStatus.PASS, "Entered text '" + text + "' into the : " + name + " field");
		} catch (Exception e) {
			//	extentTest.log(LogStatus.FAIL, "Failed to enter text '" + text + "' into the : " + name + " | Exception : " + e.getMessage());
			throw e;
		}
	}

	//Method to read excel file
	public String readExcel(String path, int rowIndex, int cellIndex) {

		String cellInput = "";  // Initialize the variable
		try {
			//Create a object of file class
			File exfile = new File(path);

			//Create object file input stream
			FileInputStream infile = new FileInputStream(exfile);

			//Create object of XSSFWorkBook
			XSSFWorkbook new_book = new XSSFWorkbook(infile);
			//Create object for sheet
			XSSFSheet exsheet = new_book.getSheetAt(0);	//Sheet index starts from 0

			//Row1
			XSSFRow exrow = exsheet.getRow(rowIndex);			//Row index starts from 0

			//Column1
			cellInput = exrow.getCell(cellIndex).getStringCellValue();
		}

		catch(Exception e) {
			e.printStackTrace();
		}
		return cellInput;
	}

	//Method to fetch excel file
	public void writeExcel(String path, int rowIndex, int cellIndex, String input) {

		try {
			//Create a object of file class
			File exfile = new File(path);

			//Create object file input stream
			FileInputStream infile = new FileInputStream(exfile);

			//Create object of XSSFWorkBook
			XSSFWorkbook new_book = new XSSFWorkbook(infile);
			//Create object for sheet
			XSSFSheet exsheet = new_book.getSheetAt(0);	//Sheet index starts from 0

			///To set the data in excel file
			exsheet.getRow(rowIndex).createCell(cellIndex).setCellValue(input);
			FileOutputStream fos = new FileOutputStream(exfile);
			new_book.write(fos);
			new_book.close();
		}

		catch(Exception e) {
			e.printStackTrace();
		}

	}

}

