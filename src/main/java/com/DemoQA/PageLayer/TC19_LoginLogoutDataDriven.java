package com.DemoQA.PageLayer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.DemoQA.TestBase.TestBase;
import com.aventstack.extentreports.Status;

public class TC19_LoginLogoutDataDriven extends TestBase{

	public TC19_LoginLogoutDataDriven () {
		PageFactory.initElements(driver, this);
	}

	//Required variables
	private String currentUrl = "https://www.saucedemo.com";
	private String dataSheetPath = userDirectory + "\\DataFiles\\LoginCredentialsData.xlsx";
	private int startRowNo = 1;
	private int endRowNo = 6;
	private int startColNo = 0;
	private int endColNo = 4;


	//------------ Xpath Repository -------------
	// Using @FindBy to locate a single element by ID, Xpath etc
	@FindBy(xpath = "//input[@placeholder='Username']")
	private WebElement txtBox_userName_homePage;

	@FindBy(xpath = "//input[@placeholder='Password']")
	private WebElement txtBox_passWord_homePage;

	@FindBy(id="login-button")
	private WebElement btn_login_homePage;	

	@FindBy(xpath="//span[@class='title']")
	private WebElement txt_product_dashboard;

	@FindBy(id="react-burger-menu-btn")
	private WebElement btn_menuButton_dashboard;

	@FindBy(id="logout_sidebar_link")
	private WebElement btn_logOut_dashboard;



	//---------------------Methods-----------------
	public void loginDataDriven() {

		try {

			driver.get(currentUrl);

			Map <String, String> data = new HashMap<>();

			List<String> usernames = new ArrayList<>();
			List<String> passwords = new ArrayList<>();
			List<String> results = new ArrayList<>();

			for (int i = startRowNo; i<=endRowNo; i++) {

				String username = action.readExcel(dataSheetPath, i, startColNo);
				String password = action.readExcel(dataSheetPath, i, startColNo+1);
				String result = action.readExcel(dataSheetPath, i, startColNo+2);
				usernames.add(username);
				passwords.add(password);
				results.add(result);
			}

			List<String> actualResults = new ArrayList<>();

			// Iterate through all three lists using the index
			for (int i = 0; i < usernames.size(); i++) {
				String username = usernames.get(i);
				String password = passwords.get(i);
				String expectedResult = results.get(i);

				action.enterText(txtBox_userName_homePage, username);

				action.enterText(txtBox_passWord_homePage, password);

				action.clickButton(btn_login_homePage);

				try {
					// Check if the dashboard element is displayed (successful login)
					if (txt_product_dashboard.isDisplayed()) {
						actualResults.add("Passed");

						// Log out after successful login
						action.clickButton(btn_menuButton_dashboard);
						action.clickButton(btn_logOut_dashboard);
					} 
				} catch (NoSuchElementException e) {
					// If the element is not found, it means login failed
					actualResults.add("Failed");
					
				}



			}

			System.out.println(actualResults);

		} 
		catch (Exception e) {
			extentTest.get().log(Status.FAIL, "Method failed : navigateToProduct();");
			throw e; // Re-throw the exception to be caught globally
		}

	}


}
