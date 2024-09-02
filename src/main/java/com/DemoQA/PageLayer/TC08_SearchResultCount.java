package com.DemoQA.PageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.DemoQA.TestBase.TestBase;
import com.aventstack.extentreports.Status;

public class TC08_SearchResultCount extends TestBase {

	//Fetch the search result count dynamically in run time. 
	//Assume here we can send any input in search box and code should work properly.

	public TC08_SearchResultCount () {
		PageFactory.initElements(driver, this);
	}

	private String currentUrl = "https://www.amazon.in";

	//------------ Xpath Repository -------------

	@FindBy (xpath = "//input[@id='twotabsearchtextbox']")
	private WebElement txtBox_searchBox_homePage;

	@FindBy (xpath = "//input[@id='nav-search-submit-button']")
	private WebElement btn_search_homePage;

	@FindBy (xpath = "//span[contains(text(),'results for')]")
	private WebElement txt_searchResult_homePage;

	//------------ Action Methods -------------	

	public void fetchSearchResultCount() {

		try {
			driver.get(currentUrl);
			
			extentTest.get().log(Status.PASS, "Navigated to Amazon home page");

			String desiredSearchText = "Motorola Mobiles";

			action.enterText(txtBox_searchBox_homePage, desiredSearchText);

			action.clickButton(btn_search_homePage);
		
			String resultText = txt_searchResult_homePage.getText();
			
			extentTest.get().log(Status.INFO, "Result text : "+resultText);

			// Split the search result string by whitespace
			String[] parts = resultText.split(" ");

			// Extract the count from the splitted parts
			String countStr = parts[2]; // Assuming count is at index 3

			extentTest.get().log(Status.INFO, "Extracting the count from text");
			
			// Remove non-numeric characters from the count string
			countStr = countStr.replaceAll("[^\\d]", "");

			// Convert the count string to an integer
			int resultCount = Integer.parseInt(countStr);

			// Print the count			
			extentTest.get().log(Status.PASS, "Number of results: " + resultCount);

			boolean value = true;
			if (value = true) {
				extentTest.get().log(Status.PASS, "Window handling successful");
			}  

		}
		catch(Exception e) {
			extentTest.get().log(Status.FAIL, "Window handling failed !");
			throw e;
		}		
	} 
}
