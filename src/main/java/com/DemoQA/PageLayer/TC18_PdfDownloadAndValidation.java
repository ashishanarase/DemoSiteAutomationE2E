package com.DemoQA.PageLayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.DemoQA.TestBase.TestBase;
import com.aventstack.extentreports.Status;

import utilityPackage.DataProvider;

public class TC18_PdfDownloadAndValidation extends TestBase {	

	public TC18_PdfDownloadAndValidation () {
		PageFactory.initElements(driver, this);
	}


	//Required variables
	protected String newelUrl = "https://newel.com";
	protected String expectedUrl = "https://newel.com/products?tag=new-arrivals";
	protected String staticPath = "(//img[@class='product-image'])[";
	protected int cardNumber;
	protected String expectedTitle;
	protected String expectedPrice;
	protected String expectedQty;
	protected String expectedId;
	protected String expectedDimensions;

	//------------ Xpath Repository -------------
	// Using @FindBy to locate a single element by ID, Xpath etc
	@FindBy(xpath = "(//a[text()='New at Newel'])[1]")
	private WebElement btn_newArrivals_HomePage;

	@FindBy(xpath = "//div[@class='product_name']")
	private WebElement txt_productTitle_productPage;

	@FindBy(xpath = "//div[@class='product_name']/following::h5")
	private WebElement txt_productPrice_productPage;	

	@FindBy(xpath = "//span[contains(text(),'Available Qty:')]")
	private WebElement txt_productQty_productPage;

	@FindBy(xpath = "//span[contains(text(),'Item #:')]")
	private WebElement txt_productId_productPage;

	@FindBy(xpath = "//h4[contains(text(),'DIMENSIONS')]/following::p[1]")
	private WebElement txt_productDimensions_productPage;	

	@FindBy(xpath = "//h4[contains(text(),'DETAILS')]/following::strong[1]")
	private WebElement txt_productId2_productPage;

	@FindBy(xpath="//span[text()='Print / Download Tearsheet']")
	private WebElement btn_downloadTearSheet1_productPage;		

	@FindBy(xpath="//span[text()='Print or download a tear-sheet for your project(s).']")
	private WebElement btn_downloadTearSheet2_productPage;


	//---------------------Methods-----------------
	public void navigateToProduct() {

		try {
			
			driver.get(newelUrl);

			action.clickButton(btn_newArrivals_HomePage);

			cardNumber = DataProvider.getIntValue(1, 48);
			
			action.urlValidation(expectedUrl);

			WebElement productImage = wait.until(ExpectedConditions.visibilityOf
					(driver.findElement(By.xpath(staticPath+cardNumber+"]"))));			

			action.jScrollToView(productImage);

			WebElement productTitle = wait.until(ExpectedConditions.visibilityOf
					(driver.findElement(By.xpath(staticPath+cardNumber+"]/following::h2[1]"))));

			expectedTitle = productTitle.getText();			

			WebElement productPrice = wait.until(ExpectedConditions.visibilityOf
					(driver.findElement(By.xpath(staticPath+cardNumber+"]/following::p[1]"))));

			expectedPrice = productPrice.getText();

			WebElement productQty = wait.until(ExpectedConditions.visibilityOf
					(driver.findElement(By.xpath(staticPath+cardNumber+"]/following::p[3]"))));

			expectedQty = productQty.getText();

			WebElement productId = wait.until(ExpectedConditions.visibilityOf
					(driver.findElement(By.xpath(staticPath+cardNumber+"]/following::p[4]"))));

			expectedId = productId.getText().replaceAll("#", "");	

			WebElement productDimensions = wait.until(ExpectedConditions.visibilityOf
					(driver.findElement(By.xpath(staticPath+cardNumber+"]/following::p[5]"))));

			expectedDimensions = productDimensions.getText();

			action.jClickButton(productTitle);

			extentTest.get().log(Status.INFO, "Navigated successfully to product page");

			extentTest.get().log(Status.PASS, "Method executed successfully : navigateToProduct();");

		} 
		catch (Exception e) {
			extentTest.get().log(Status.FAIL, "Method failed : navigateToProduct();");
			throw e; // Re-throw the exception to be caught globally
		}

	}


	public void productDetails() {

		try {

			//	driver.get("https://www.newel.com/product/pair-of-art-deco-mid-century-burl-circular-end-side-tables-with-mahogany-veneered-bases");

			String actualTitle = txt_productTitle_productPage.getText();

			String actualPrice = txt_productPrice_productPage.getText();

			String actualQty = txt_productQty_productPage.getText();

			String actualId = txt_productId_productPage.getText();

			String actualDimensions = txt_productDimensions_productPage.getText();
			
			System.out.println("1="+actualTitle+" /1="+expectedTitle);
			System.out.println("2="+actualPrice+" /2="+expectedPrice);
			System.out.println("3="+actualQty+" /3="+expectedQty);
			System.out.println("4="+actualId+" /4="+expectedId);
			System.out.println("5="+actualDimensions+" /5="+expectedDimensions);

			extentTest.get().log(Status.PASS, "Method executed successfully : productDetails();");

		} 
		catch (Exception e) {
			extentTest.get().log(Status.FAIL, "Method failed : productDetails();");
			throw e; // Re-throw the exception to be caught globally
		}
	}

		public void downloadTearsheet() {

			try {

				action.jScrollToView(btn_downloadTearSheet1_productPage);

				action.clickButton(btn_downloadTearSheet1_productPage);

				action.clickButton(btn_downloadTearSheet2_productPage);

				extentTest.get().log(Status.PASS, "Method executed successfully : downloadTearsheet();");

			} 
			catch (Exception e) {
				extentTest.get().log(Status.FAIL, "Method failed : downloadTearsheet();");
				throw e; // Re-throw the exception to be caught globally
			}

		}
	}

