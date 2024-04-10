package com.DemoQA.PageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.DemoQA.TestBase.TestBase;

public class TC08_SearchResultCount extends TestBase {

	public TC08_SearchResultCount () {
		PageFactory.initElements(driver, this);
	}

	//------------ Xpath Repository -------------

	@FindBy (xpath = "//input[@id=\"twotabsearchtextbox\"]")
	public WebElement txtBox_searchBox_homePage;

	@FindBy (xpath = "//input[@id=\"nav-search-submit-button\"]")
	public WebElement btn_search_homePage;

	@FindBy (xpath = "//h1[@class=\"a-size-base s-desktop-toolbar a-text-normal\"]")
	public WebElement txt_searchResult_homePage;

	//------------ Action Methods -------------	

	public void fetchSearchResultCount() throws InterruptedException {

		driver.get("https://amazon.in");

		String desiredSearchText = "Motorola Mobiles";

		//		WebElement txtBox_searchBox_homePage = driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]"));

		txtBox_searchBox_homePage.sendKeys(desiredSearchText);

		//			WebElement btn_search_homePage = driver.findElement(By.xpath("//input[@id=\"nav-search-submit-button\"]"));

		btn_search_homePage.click();

		//		WebElement txt_searchResult_homePage = driver.findElement(By.xpath("//h1[@class=\"a-size-base s-desktop-toolbar a-text-normal\"]"));

		String resultText = txt_searchResult_homePage.getText();

		// Split the search result string by whitespace
		String[] parts = resultText.split(" ");

		// Extract the count from the splitted parts
		String countStr = parts[2]; // Assuming count is at index 3

		// Remove non-numeric characters from the count string
		countStr = countStr.replaceAll("[^\\d]", "");

		System.out.println(countStr);

		// Convert the count string to an integer
		int resultCount = Integer.parseInt(countStr);

		// Print the count
		System.out.println("Number of results: " + resultCount);

	} 

}
