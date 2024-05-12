package com.DemoQA.PageLayer;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.DemoQA.TestBase.TestBase;

public class TC12_BrokenLinkValidation extends TestBase {

	//this is sample class

	public TC12_BrokenLinkValidation () {
		PageFactory.initElements(driver, this);
	}

	//------------ Xpath Repository -------------

	@FindBy (xpath = " ")
	private WebElement txtbox_userName_homePage;

	//------------ Action Methods -------------	

	public void brokenLinkValidation(String desiredUrl) throws InterruptedException, IOException {

		driver.get(desiredUrl);

		List <WebElement> urlList = driver.findElements(By.tagName("a"));

		System.out.println("Total Number of Links = "+urlList.size());

		//List <WebElement> activeLinks = new ArrayList <WebElement>();

		for (int i = 0; i<urlList.size(); i++) {
			if (urlList.get(i).getAttribute("href") != null) {

				String urlLink = urlList.get(i).getAttribute("href");

				URL link = new URL(urlLink);

				HttpURLConnection httpCon = (HttpURLConnection) link.openConnection();

				Thread.sleep(2000);

				httpCon.connect();

				int responseCode = httpCon.getResponseCode();

				if (responseCode >= 400) {
					System.out.println("Broken Link = " + urlLink);
				}
				else {
					System.out.println();
				}
			}				
		}
	}
}




