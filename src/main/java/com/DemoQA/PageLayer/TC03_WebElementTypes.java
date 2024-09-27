package com.DemoQA.PageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.DemoQA.TestBase.TestBase;
import com.aventstack.extentreports.Status;
import utilityPackage.CommonMethods;
import utilityPackage.DataProvider;

public class TC03_WebElementTypes extends TestBase {

	//Different Type of Xpath and Handling them on Add Candidate Recruitment of OrangeHRM

	public TC03_WebElementTypes () {
		PageFactory.initElements(driver, this);
	}

	private String domainName = "@orange.com";	
	private String contactNumber = "9876543210";	
	private String sampleKeywords = "Java, Selenium WebDriver, API";	
	private String sampleNotes = "This is Sample Note of Added Candidate";
	
	//------------ Xpath Repository -------------

	@FindBy(xpath = "//span[text()='Recruitment']") 	//tagname[text()='text_value']
	private WebElement btn_sidePanelOption5_dashboard;

	@FindBy(xpath = "//button[@type='button'and@class='oxd-button oxd-button--medium oxd-button--secondary']")
	private WebElement btn_add_recruitmentPage;

	@FindBy(xpath = "//input[@placeholder='First Name']")
	private WebElement txtBox_firstName_recruitmentPage;

	@FindBy(xpath = "//input[@placeholder='Middle Name']")
	private WebElement txtBox_middleName_recruitmentPage;

	@FindBy(xpath = "//input[@placeholder='Last Name']")
	private WebElement txtBox_lastName_recruitmentPage;

	@FindBy(xpath = "//div[text()='-- Select --']")
	private WebElement dd_selectDesignation_recruitmentPage;

	@FindBy(xpath = "(//div[@role='option'])[5]")
	private WebElement dd_option4_recruitmentPage;

	@FindBy(xpath = "(//input[@placeholder='Type here'])[1]")
	private WebElement txtBox_email_recruitmentPage;

	@FindBy(xpath = "(//input[@placeholder='Type here'])[2]")
	private WebElement txtBox_contactNumber_recruitmentPage;

	@FindBy(xpath = "//label[text()='Email']/following::span[text()='Expected format: admin@example.com']")
	private WebElement txt_emailError_recruitmentPage;

	@FindBy(xpath = "//input[@placeholder='Enter comma seperated words...']")
	private WebElement txtBox_keyWords_recruitmentPage;

	@FindBy(xpath = "(//input[@placeholder='yyyy-dd-mm'])[1]")
	private WebElement btn_fromDate_recruitmentPage;

	@FindBy(xpath = "//div[@class='oxd-calendar-date --selected --today']")
	private WebElement btn_today_recruitmentPage;

	@FindBy(xpath = "//textarea[@placeholder='Type here']")
	private WebElement txtBox_notes_recruitmentPage;

	@FindBy(xpath = "//span[@class='oxd-checkbox-input oxd-checkbox-input--active --label-right oxd-checkbox-input']")
	private WebElement cb_consentData_recruitmentPage;

	@FindBy(xpath = "//p[text()=' * Required']/following::button[2]")
	private WebElement btn_save_employeePage;

	@FindBy(xpath = "//p[text()='Successfully Saved']")
	private WebElement txt_toasterSuccessMessage_employeePage;


	//------------ Action Methods -------------	

	String[] nameDetails = DataProvider.getNameDetails();

	String firstName = nameDetails[0];
	String middleName = nameDetails[1];
	String lastName = nameDetails[2];
	String employeeID = nameDetails[3];

	public void actionOnElements() {
		try {

			action.clickButton(btn_sidePanelOption5_dashboard);

			action.clickButton(btn_add_recruitmentPage);

			action.enterText(txtBox_firstName_recruitmentPage, firstName);

			action.enterText(txtBox_middleName_recruitmentPage, middleName);

			action.enterText(txtBox_lastName_recruitmentPage, lastName);

			action.clickButton(dd_selectDesignation_recruitmentPage);

			action.clickButton(dd_option4_recruitmentPage);

			action.enterText(txtBox_email_recruitmentPage, firstName+lastName+domainName);

			action.enterText(txtBox_contactNumber_recruitmentPage, contactNumber);			

			action.enterText(txtBox_keyWords_recruitmentPage, sampleKeywords);

			action.clickButton(btn_fromDate_recruitmentPage);

			action.clickButton(btn_today_recruitmentPage);

			action.enterText(txtBox_notes_recruitmentPage, sampleNotes);

			action.clickCheckBox(cb_consentData_recruitmentPage);

			CommonMethods.beforeActionSuccessMessage(txt_toasterSuccessMessage_employeePage);

			action.clickButton(btn_save_employeePage);

			CommonMethods.afterActionSuccessMessage(txt_toasterSuccessMessage_employeePage);

			extentTest.get().log(Status.PASS, "Method executed successfully : actionOnElements();");

		} 
		catch (Exception e) {
			extentTest.get().log(Status.FAIL, "Method failed : actionOnElements();");
			throw e; // Re-throw the exception to be caught globally
		}

	}

}

