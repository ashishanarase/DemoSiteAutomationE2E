package com.DemoQA.PageLayer;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.DemoQA.TestBase.TestBase;
import com.aventstack.extentreports.Status;

import io.opentelemetry.sdk.metrics.data.Data;
import utilityPackage.DataProvider;

public class TC21_MutualFundAnalysis extends TestBase {

	//this is sample class

	public TC21_MutualFundAnalysis () {
		PageFactory.initElements(driver, this);
	}

	//Required variables
	
	private String timeStamp;
	
	private String currentUrl = "https://upstox.com/mutual-funds/";

	private String filePath = userDirectory+"DataFiles\\MutualFundTracker.xlsx";

	

	//------------ Xpath Repository -------------

	// Using @FindBy to locate a single element by ID
	@FindBy(xpath = "//input[@id='navbar-search-input']")
	private WebElement txtBox_searchBox_homePage;

	@FindBy(xpath = "//button[@class='tabItem activeTabItem']/following::div[3]")
	private WebElement dd_option1_homePage;	

	@FindBy(xpath = "//h2[text()='Fund Info']")
	private WebElement txt_fundInfo_homePage;

	@FindBy(xpath = "//div[text()='NAV']/following::div[1]")
	private WebElement txt_dateStamp_homePage;

	@FindBy(xpath = "//div[text()='NAV']/following::div[3]")
	private WebElement txt_currentNAV_homePage;

	@FindBy(xpath = "//div[@class='resultInfo']")
	private WebElement dd__homePage;

	//------------ Action Methods -------------	

	
	public void analyzeFunds() throws Exception {
	    try {
	        timeStamp = DataProvider.getCurrentTimeStamp("dd-MMM-yyyy");

	        // Read fund details and last purchased values into arrays
	        String[] fundNames = {
	            action.readExcel(filePath, 2, 2),
	            action.readExcel(filePath, 2, 3),
	            action.readExcel(filePath, 2, 4),
	            action.readExcel(filePath, 2, 5)
	        };

	        double[] highValues = {
	            Double.parseDouble(action.readExcel(filePath, 3, 2)),
	            Double.parseDouble(action.readExcel(filePath, 3, 3)),
	            Double.parseDouble(action.readExcel(filePath, 3, 4)),
	            Double.parseDouble(action.readExcel(filePath, 3, 5))
	        };

	        double[] lastPurchasedValues = {
	            Double.parseDouble(action.readExcel(filePath, 7, 2)),
	            Double.parseDouble(action.readExcel(filePath, 7, 3)),
	            Double.parseDouble(action.readExcel(filePath, 7, 4)),
	            Double.parseDouble(action.readExcel(filePath, 7, 5))
	        };

	        // Iterate over funds and perform analysis
	        for (int i = 0; i < fundNames.length; i++) {
	            analyzeSingleFund(fundNames[i], highValues[i], lastPurchasedValues[i], i + 2);
	        }

	        // Update last date
	        action.writeExcelString(filePath, 2, 7, timeStamp);

	    } catch (Exception e) {
	        extentTest.get().log(Status.FAIL, "Method failed : analyzeFunds()");
	        throw e; // Re-throw the exception to be caught globally
	    }
	}

	private void analyzeSingleFund(String fundName, double highValue, double lastPurchased, int columnIndex) throws Exception {
	    driver.get(currentUrl);

	    // Search and navigate to the fund
	    action.enterText(txtBox_searchBox_homePage, fundName);
	    Thread.sleep(2000);
	    action.jClickButton(dd_option1_homePage);
	    action.jScrollToView(txt_fundInfo_homePage);

	    // Fetch current NAV
	    String textNAV = txt_currentNAV_homePage.getText();
	    double currentNAV = Double.parseDouble(textNAV.substring(1));

	    // Write current NAV to Excel
	    action.writeExcelDouble(filePath, 4, columnIndex, currentNAV);

	    // Calculate and write high from down
	    double highFromDown = (highValue - currentNAV) / highValue;
	    action.writeExcelDouble(filePath, 5, columnIndex, DataProvider.extractTwoDecimalValue(highFromDown));

	    // Calculate and write last purchased percentage change
	    double lastPurchasedChange = (currentNAV - lastPurchased) / lastPurchased;
	    action.writeExcelDouble(filePath, 8, columnIndex, DataProvider.extractTwoDecimalValue(lastPurchasedChange));

	    // Update high value and timestamp if the current NAV exceeds the high value
	    if (currentNAV > highValue) {
	        action.writeExcelDouble(filePath, 3, columnIndex, currentNAV);
	        action.writeExcelString(filePath, 6, columnIndex, timeStamp);
	    }
	}


	//Class Brace
}
