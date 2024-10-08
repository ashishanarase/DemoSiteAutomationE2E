package com.DemoQA.PageLayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.DemoQA.TestBase.TestBase;
import com.aventstack.extentreports.Status;

public class TC08_SearchResultAndCartValidation extends TestBase {

	//Fetch the search result count dynamically in run time. 
	//Assume here we can send any input in search box and code should work properly.

	public TC08_SearchResultAndCartValidation () {
		PageFactory.initElements(driver, this);
	}

	//Required variables
	private String currentUrl1 = "https://www.newel.com";
	protected String staticPath1 = "(//img[@class='product-image'])[";
	protected String staticPath2 = "]/following::a[1]/h2";
	protected int cardNumber;
	String[] keywordList = {"Table", "Bed", "Chair", "Mirror", "Sculpture", "Light", "Lamp"};
	
	private String currentUrl2 = "https://www.amazon.in";
	

	//------------ Xpath Repository -------------
	// Using @FindBy to locate a single element by ID, Xpath etc
	@FindBy(id = "search-input")
	WebElement txtBox_searchBox_Dashboard;

	@FindBy(xpath = "//a[contains(text(),'RESULTS FOR')]")
	WebElement btn_resultText_Dashboard;

	@FindBy (xpath = "//input[@id='twotabsearchtextbox']")
	private WebElement txtBox_searchBox_homePage;

	@FindBy (xpath = "//span[contains(text(),'results for')]")
	private WebElement txt_searchResult_homePage;

	@FindBy(id = "twotabsearchtextbox")
	WebElement txtBox_search_homePage;

	@FindBy(id = "nav-search-submit-button")
	WebElement btn_search_homePage;

	@FindBy(xpath = "(//span[@data-component-type='s-product-image'])[1]")
	WebElement img_product1_searchResultPage;

	@FindBy(xpath = "(//span[@class='a-price-whole'])[4]")
	WebElement txt_priceProduct1_searchResultPage;

	@FindBy(xpath = "(//span[@data-component-type='s-product-image'])[1]/following::i[1]")
	WebElement txt_ratingStar1_searchResultPage;

	@FindBy(id = "acr-popover-title")
	WebElement txt_ratingStarCount1_searchResultPage;

	@FindBy(xpath = "//span[contains(text(),'global ratings')]")
	WebElement txt_globalRatingCount1_searchResultPage;

	@FindBy(id = "productTitle")
	WebElement txt_productTitle_productPage;

	@FindBy(xpath = "(//span[@class='a-price-symbol'])[6]/following::span[1]")
	WebElement txt_productPrice_productPage;

	@FindBy(xpath = "(//input[@id='add-to-cart-button'])[2]")
	WebElement btn_addToCart_productPage;

	@FindBy(id = "attach-accessory-cart-subtotal")
	WebElement txt_productPrice_cartPage;


	//------------ Action Methods -------------	

	public void searchResultValidation() {
		try {

			driver.get(currentUrl1);
			
			for (String searchKeyword : keywordList) {

				action.enterText(txtBox_searchBox_Dashboard, searchKeyword);

				action.jScrollToView(btn_resultText_Dashboard);

				action.clickButton(btn_resultText_Dashboard);

				List <String> productTitleList = new ArrayList<>();

				List<WebElement> productTitleElements = wait.until(ExpectedConditions.visibilityOfAllElements
						(driver.findElements(By.xpath("//img[@class='product-image']/following::a[1]/h2"))));

				for (WebElement productTitle : productTitleElements) {		           
					productTitleList.add(productTitle.getText());	 
				}

				int value1 = 0 ;
				int value2 = 0 ;


				// Loop through the list and validate each title
				for (int i = 0; i < productTitleList.size(); i++) {
					String title = productTitleList.get(i);

					String keyword = searchKeyword.toLowerCase();

					// Check if the title contains the word "Table" (ignoring case)
					if (title.toLowerCase().contains(keyword)) {
						value1++;
					} else {
						value2++;
					}
				}

				extentTest.get().log(Status.PASS, "search results for the keyword '"+searchKeyword+"' found in '"+value1+"' product titles");

				if (value2>0) {
					extentTest.get().log(Status.WARNING, "search results for the keyword '"+searchKeyword+"' NOT found in '"+value2+"' product titles");
				}
			}

			extentTest.get().log(Status.PASS, "Method executed successfully : searchResultValidation();");

		} 
		catch (Exception e) {
			extentTest.get().log(Status.FAIL, "Method failed : searchResultValidation();");
			throw e; // Re-throw the exception to be caught globally
		}
	}


	public void searchResultCount(String searchKey) {

		try {
			driver.get(currentUrl2);

			extentTest.get().log(Status.PASS, "Navigated to Amazon home page");

			action.enterText(txtBox_searchBox_homePage, searchKey);

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
			extentTest.get().log(Status.INFO, "Number of results: " + resultCount);

			extentTest.get().log(Status.PASS, "Method executed successfully : searchResultCount();");

		} 
		catch (Exception e) {
			extentTest.get().log(Status.FAIL, "Method failed : searchResultCount();");
			throw e; // Re-throw the exception to be caught globally
		}

	}


	public void cartValue() {

		try {

			action.visibilityCheck(img_product1_searchResultPage);

			action.visibilityCheck(txt_priceProduct1_searchResultPage);

			String priceProduct1 = txt_priceProduct1_searchResultPage.getText();

			extentTest.get().log(Status.INFO, "Price of the first product on search result : "+priceProduct1);

			action.jScrollToView(txt_ratingStar1_searchResultPage);
			//	action.moveToElement(txt_ratingStar1_searchResultPage).build().perform();
			// Mouse Over not working with this, so clicking on element

			action.clickButton(txt_ratingStar1_searchResultPage);

			action.visibilityCheck(txt_ratingStarCount1_searchResultPage);

			action.visibilityCheck(txt_globalRatingCount1_searchResultPage);

			String ratingCount = txt_ratingStarCount1_searchResultPage.getText();

			String globalRatingCount = txt_globalRatingCount1_searchResultPage.getText();

			extentTest.get().log(Status.INFO, "Ratings '"+ratingCount + "' with total '"+ globalRatingCount+"'");

			action.clickButton(img_product1_searchResultPage);

			action.switchToNextTab();

			action.visibilityCheck(txt_productTitle_productPage);

			String productTitle = txt_productTitle_productPage.getText();

			extentTest.get().log(Status.INFO, "Title of the product on product page : "+productTitle);

			action.visibilityCheck(txt_productPrice_productPage);

			String productPrice = txt_productPrice_productPage.getText();

			extentTest.get().log(Status.INFO, "Price of the product on product page = "+productPrice);

			action.clickButton(btn_addToCart_productPage);

			action.visibilityCheck(txt_productPrice_cartPage);

			String cartPrice = txt_productPrice_cartPage.getText();

			extentTest.get().log(Status.INFO, "Price of the product on cart page = "+cartPrice);


			if (cartPrice.contains(priceProduct1)) {
				extentTest.get().log(Status.PASS, "Cart price against the search result page price validated successfully");
			}
			else {
				extentTest.get().log(Status.WARNING, "Failed to validate the cart price against the search result page price");
			}

			if (cartPrice.contains(productPrice)) {
				extentTest.get().log(Status.PASS, "Cart price against the product page price validated successfully");
			}
			else {
				extentTest.get().log(Status.WARNING, "Failed to validate the cart price against the product page price");
			}

			extentTest.get().log(Status.PASS, "Method executed successfully : cartValue();");

		} 
		catch (Exception e) {
			extentTest.get().log(Status.FAIL, "Method failed : cartValue();");
			throw e; // Re-throw the exception to be caught globally
		}

	}


	//Class Brace	
}	
