package com.DemoQA.PageLayer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.DemoQA.TestBase.TestBase;
import com.aventstack.extentreports.Status;

public class GenericActionTemplate extends TestBase {

	public static final int maxWaitTime = 30;

	JavascriptExecutor jScript = (JavascriptExecutor) driver;

	Actions performAction = new Actions(driver);

	// Constructor to initialize WebDriver, WebDriverWait, and ExtentTest
	public GenericActionTemplate() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(maxWaitTime)); // You can adjust the timeout duration   
	}


	/*All method Sequence
	 1. actionClick
	 2. actionMouseOver
	 1. alertAccept
	 2. alertDismiss
	 3. alertSendkeysAccept

	 2. jClickButton
	 3. jScrollToCoordinate
	 4. jScrollToView
	 5. visibilityCheck
	 6. internalUrlValidation    -- Add and Implement If Required
	 7. externalUrlValidation    -- Add and Implement If Required
	 8. urlValidation   
	 9. clickCheck
	10. clickButton
	11. clickCheckBox
	12. checkBoxEnabled
	13. enterText
	14. textValidation  -- implement
	15. readExcelData
	16. writeExcelData
	17. selectDropdownValue
	18. selectGetOptionsValidation  - implement
	19. titleValidation
	

	 */
	
	
	//Method to perform mouse over action on desired webelement
		public void actionClick(WebElement element) {	

			String name = element.getText();
			try {	        	
				wait.until(ExpectedConditions.visibilityOf(element));

				performAction.click(element).build().perform();

				extentTest.get().log(Status.PASS, "Clicked on element using Mouse (Actions Class) : " + name +" button");
			} catch (Exception e) {
				extentTest.get().log(Status.FAIL, "Failed to perform click action using Mouse (Actions Class) on element : : " + name + " | Exception: " + e.getMessage());
				throw e;
			}
		}
	

	//Method to perform mouse over action on desired webelement
	public void actionMouseOver(WebElement element) {	

		String name = element.getText();
		try {	        	
			wait.until(ExpectedConditions.visibilityOf(element));

			performAction.moveToElement(element).build().perform();

			extentTest.get().log(Status.INFO, "Mouse over on element using Mouse (Actions Class) : " + name +" button");
		} catch (Exception e) {
			extentTest.get().log(Status.FAIL, "Failed to perform mouse over action on element : : " + name + " | Exception: " + e.getMessage());
			throw e;
		}
	}
	
	
	//Method to perform mouse over action on desired webelement
		public void actionRightClick(WebElement element) {	

			String name = element.getText();
			try {	        	
				wait.until(ExpectedConditions.visibilityOf(element));

				performAction.contextClick(element).build().perform();

				extentTest.get().log(Status.PASS, "Right clicked on element using Mouse (Actions Class) : " + name +" button");
			} catch (Exception e) {
				extentTest.get().log(Status.FAIL, "Failed to perform right click action on element : : " + name + " | Exception: " + e.getMessage());
				throw e;
			}
		}
	
	//Method to wait for an alert presence and print alert message in report logs and Accept
	public String alertAccept() {		
		String alertMessage;
		try {

			wait.until(ExpectedConditions.alertIsPresent());

			alertMessage = driver.switchTo().alert().getText();

			driver.switchTo().alert().accept();

			extentTest.get().log(Status.PASS, "Alert with message '" + alertMessage+ "' accepted successfully");

		}
		catch (Exception e) {
			extentTest.get().log(Status.FAIL, "Failed to validate Alert | Exception: " + e.getMessage());
			throw e;
		}
		return alertMessage;
	}


	//Method to wait for an alert presence and print alert message in report logs and Dismiss
	public String alertDismiss() {		
		String alertMessage;
		try {

			wait.until(ExpectedConditions.alertIsPresent());

			alertMessage = driver.switchTo().alert().getText();

			driver.switchTo().alert().dismiss();

			extentTest.get().log(Status.PASS, "Alert with message '" + alertMessage+ "' rejected successfully");

		}
		catch (Exception e) {
			extentTest.get().log(Status.FAIL, "Failed to validate Alert | Exception: " + e.getMessage());
			throw e;
		}
		return alertMessage;
	}


	public String alertSendkeysAccept(String message) {		
		String alertMessage;
		try {

			wait.until(ExpectedConditions.alertIsPresent());

			alertMessage = driver.switchTo().alert().getText();

			driver.switchTo().alert().sendKeys(message);

			driver.switchTo().alert().accept();

			extentTest.get().log(Status.PASS, "Promt alert with message '" + alertMessage+ "' accepted successfully");

		}
		catch (Exception e) {
			extentTest.get().log(Status.FAIL, "Failed to validate Promt alert | Exception: " + e.getMessage());
			throw e;
		}
		return alertMessage;
	}


	// Method to wait for an element to be clickable and then click using JS
	public void jClickButton(WebElement element) {
		String name = element.getText();  

		try {	        	
			wait.until(ExpectedConditions.elementToBeClickable(element));
			jScript.executeScript("arguments[0].click();", element);
			extentTest.get().log(Status.PASS, "Clicked on element : " + name +" button");
		} catch (Exception e) {
			extentTest.get().log(Status.FAIL, "Failed to click on element : " + name + " | Exception: " + e.getMessage());
			throw e;
		}
	}

	public void jScrollToCoordinate(int x, int y) {

		try {		

			// Use JavaScriptExecutor with actual variable values passed
			jScript.executeScript("window.scrollBy(arguments[0], arguments[1]);", x, y);

			extentTest.get().log(Status.PASS, "Scrolled upto desired co-ordinates : " + x +", "+ y);

		} catch (Exception e) {
			extentTest.get().log(Status.FAIL, "Failed to scrolled upto desired co-ordinates : " + x +", "+ y + " | Exception: " + e.getMessage());
			throw e;
		}
	}

	public void jScrollToView(WebElement element) {
		String name = element.getText(); 

		try {		

			//	wait.until(ExpectedConditions.visibilityOf(element));

			jScript.executeScript("arguments[0].scrollIntoView(true);", element);

			extentTest.get().log(Status.PASS, "Scrolled upto desired element : " + name);

			Thread.sleep(1000);

		} catch (Exception e) {
			extentTest.get().log(Status.FAIL, "Failed to scrolled upto desired element : " + name + " | Exception: " + e.getMessage());

			throw new RuntimeException("Re-throwing runtime exception", e);

		}
	}




	// Method to wait for an element to be visible only
	public void visibilityCheck(WebElement element) {

		String name = element.getText();  

		try {	        	
			wait.until(ExpectedConditions.visibilityOf(element));
			extentTest.get().log(Status.PASS, "Desired element visible : " + name +" ");
		} catch (Exception e) {
			extentTest.get().log(Status.FAIL, "Desired element not visible : " + name + " | Exception: " + e.getMessage());
			throw e;
		}
	}


	// Method to wait for an element to be visible only
	public void urlValidation( String expectedURL) {
		try {	

			wait.until(ExpectedConditions.urlToBe(expectedURL));

			String currentURL = driver.getCurrentUrl();

			Assert.assertEquals(currentURL, expectedURL, "Navigation after clicking the URL failed");

			extentTest.get().log(Status.PASS, "Navigation after clicking the URL successful : " + expectedURL);
		} catch (Exception e) {
			extentTest.get().log(Status.FAIL, "Navigation after clicking the URL failed : " + expectedURL + " | Exception: " + e.getMessage());
			throw e;
		}
	}

	// Method to wait for an element to be clickable
	public void clickCheck(WebElement element) {
		String name = element.getText();  

		try {	        	
			wait.until(ExpectedConditions.elementToBeClickable(element));

			extentTest.get().log(Status.PASS, "Clicked on element : " + name +" button");
		} catch (Exception e) {
			extentTest.get().log(Status.FAIL, "Failed to click on element : " + name + " | Exception: " + e.getMessage());
			throw e;
		}
	}

	// Method to wait for an element to be clickable and then click
	public void clickButton(WebElement element) {
		String name = element.getText();  

		try {	   
			wait.until(ExpectedConditions.visibilityOf(element));
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


	// Method to validate text from element
	public void textValidation(WebElement element, String expectedText) {
		String actualText = element.getText();
		try {
			// Assert if the actual text matches the expected text
			Assert.assertEquals(actualText, expectedText, "Actual text might be changed");

			extentTest.get().log(Status.PASS, "Text validated successfully : '" + actualText+"'");

		} catch (Exception e) {
			extentTest.get().log(Status.WARNING, "Failed to validate text '" + expectedText + "', Actual text changed to '"+actualText+"' | Exception : " + e.getMessage());
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

	//Method to select the value from dropdown using select Class 
	public void selectDropdown(WebElement element, String value) {

		wait.until(ExpectedConditions.visibilityOf(element));

		// Initialize the Select class with the dropdown element
		Select selObject = new Select(element);

		element.click();

		List<WebElement> optionsList = selObject.getOptions();

		try {				
			// Check if the input value is numeric or not
			// Try to parse the value to check if it's numeric
			int index = Integer.parseInt(value);
			// If value is numeric, select by index
			selObject.selectByIndex(index);
			String selectedOptionText = optionsList.get(index).getText();
			extentTest.get().log(Status.PASS, "Dropdown option selected using 'selectByIndex' method at index : "+ index +" | Option Text: " + selectedOptionText);
		}

		catch(NumberFormatException e) {	            
			boolean isValueMatched = false;
			for (WebElement option : optionsList) {
				if (option.getAttribute("value").equals(value)) {
					selObject.selectByValue(value);
					isValueMatched = true;
					extentTest.get().log(Status.PASS, "Dropdown option selected using 'selectByValue' method for value : " + value);
					break;
				}
			}

			// If the value attribute didn't match, fall back to selecting by visible text
			if (!isValueMatched) {
				selObject.selectByVisibleText(value);
				extentTest.get().log(Status.PASS, "Dropdown option selected using 'selectByVisibleText' method for text : "+ value);
			}

		}
		catch(Exception e) {
			extentTest.get().log(Status.FAIL, "Failed to select dropdown option '" + value + " | Exception : " + e.getMessage());
			throw e;
		}
	}


	public List<String> selectGetOptions(WebElement element) {

		wait.until(ExpectedConditions.visibilityOf(element));

		// Initialize the Select class with the dropdown element
		Select selObject = new Select(element);

		// Use the getOptions() method to retrieve all options
		List<WebElement> allOptions = selObject.getOptions();

		// Create a list to store the text of each dropdown option
		List<String> optionsTextList = new ArrayList<>();

		// Loop through all options, log the visible text, and add it to the list
		for (WebElement option : allOptions) {
			String optionText = option.getText();  // Get the visible text of the option
			optionsTextList.add(optionText);  // Add the option text to the list
		}

		// Return the list of option texts
		return optionsTextList;
	}


	public void titleValidation (String expectedTitle) {

		wait.until(ExpectedConditions.titleContains(expectedTitle));

		String actualTitle = driver.getTitle();		

		//	Assert.assertEquals(actualTitle, expectedTitle);

		if (actualTitle.contains(expectedTitle)) {
			extentTest.get().log(Status.PASS, "Tab title validated successfully");
		}
		else {
			extentTest.get().log(Status.WARNING, "Tab title validation failed : Not matching with expected title");
		}
	}


	



}

