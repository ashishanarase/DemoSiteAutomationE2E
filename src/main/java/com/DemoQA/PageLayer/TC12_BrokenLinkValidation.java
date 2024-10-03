package com.DemoQA.PageLayer;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.DemoQA.TestBase.TestBase;
import com.aventstack.extentreports.Status;

public class TC12_BrokenLinkValidation extends TestBase {

	//this is sample class

	public TC12_BrokenLinkValidation () {
		PageFactory.initElements(driver, this);
	}

	//------------ Xpath Repository -------------

	@FindBy (xpath = " ")
	private WebElement txtbox_userName_homePage;

	//------------ Action Methods -------------	

	public void brokenLinkValidation(String desiredUrl) {

		try {

			driver.get(desiredUrl);

			List <WebElement> elementLinks = driver.findElements(By.tagName("a"));

			extentTest.get().log(Status.INFO, "Total number of links : "+elementLinks.size());

			List<String> linkList = new ArrayList<String>();
			List<String> brokenLinks = new ArrayList<String>();
			List<String> validLinks = new ArrayList<String>();

			for (WebElement element : elementLinks) {
				String url = element.getAttribute("href");
				linkList.add(url);
			}

			long stTime = System.currentTimeMillis();

			// Traditional for loop instead of parallelStream()
			for (String linkUrl : linkList) {
				if (checkBrokenLink(linkUrl)) {
					brokenLinks.add(linkUrl);
				} else {
					validLinks.add(linkUrl);
				}
			}
			//			linkList.parallelStream().forEach(element -> checkBrokenLink(element));			

			long endTime = System.currentTimeMillis();

			// Log the counts of valid and broken links
			extentTest.get().log(Status.INFO, "Total number valid links : " + validLinks.size());

			extentTest.get().log(Status.INFO, "Total number of broken links : " + brokenLinks.size());

			extentTest.get().log(Status.PASS, "Method executed successfully : brokenLinkValidation();");

		} 
		catch (Exception e) {
			extentTest.get().log(Status.FAIL, "Method failed : brokenLinkValidation();");
			throw e; // Re-throw the exception to be caught globally
		}
	}

	public static boolean checkBrokenLink(String linkUrl) {

		try {
			URL link = new URL(linkUrl);

			HttpURLConnection httpCon = (HttpURLConnection) link.openConnection();

			httpCon.setConnectTimeout(5000);

			httpCon.connect();

			int responseCode = httpCon.getResponseCode();

			if (responseCode >= 400) {
				return true;  // Broken link
			}
			else {
				return false; // Valid link
			}
		}
		catch (MalformedURLException e) {
			// Handle MalformedURLException
			//	System.err.println("Malformed URL : " + linkUrl);
			return true; // Consider malformed URLs as broken
		} catch (IOException eIO) {
			// Handle IOException
			//	System.err.println("IOException : " + e.getMessage());
			return true; // Consider IO issues as broken
		} catch (NullPointerException eNull) {
			// Handle NullPointerException
			//	System.err.println("NullPointerException : " + eNull.getMessage());
			return true; // Consider null URLs as broken
		}
	}


//Class Brace	
}




