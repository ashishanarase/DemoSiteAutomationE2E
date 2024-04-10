package com.DemoQA.PageLayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.DemoQA.TestBase.TestBase;

public class TC05_DynamicTableStructure extends TestBase {

	public TC05_DynamicTableStructure() {
		PageFactory.initElements(driver, this);
	}

	//------------ Xpath Repository -------------

	@FindBy (xpath = "//table[@class=\"ds-w-full ds-table ds-table-xs ds-table-auto  ds-w-full ds-overflow-scroll ds-scrollbar-hide\"]")
	private WebElement element_table_homePage;


	//------------ Action Methods -------------	

	public void dynamicTableStructure() {

		int expectedRowCount = 101;
		int expectedColCount = 9;

		driver.get("https://www.espncricinfo.com/records/trophy/team-highest-innings-totals/indian-premier-league-117");

	//	WebElement element_table_homePage = driver.findElement(By.xpath("//table[@class=\"ds-w-full ds-table ds-table-xs ds-table-auto  ds-w-full ds-overflow-scroll ds-scrollbar-hide\"]"));

		int rowCount = element_table_homePage.findElements(By.tagName("tr")).size();
		System.out.println(rowCount);

		// Find the first row to determine the number of columns
		int colCount = element_table_homePage.findElement(By.tagName("tr")).findElements(By.tagName("td")).size();
		System.out.println(colCount);

		// Validate the number of rows and columns
		if (rowCount == expectedRowCount && colCount == expectedColCount) {
			System.out.println("Validation Passed: Correct number of rows and columns.");
		} else {
			System.out.println("Validation Failed: Incorrect number of rows and/or columns.");
		}
	}
}

