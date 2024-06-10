package com.DemoQA.PageLayer;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.DemoQA.TestBase.TestBase;

public class TC11_ExplicitAndFluentWaits extends TestBase {
	
	//Different ExplicitWait Conditions handling
	
	public TC11_ExplicitAndFluentWaits () {
		PageFactory.initElements(driver, this);
	}
	

	//------------ Xpath Repository -------------
	
	@FindBy (xpath = "//input[@type=\"checkbox\"]")
	private WebElement cb_checkBox_homePage;
	
	@FindBy (xpath = "//button[@onclick=\"swapCheckbox()\"]")
	private WebElement btn_removeAdd_homePage;
	
	//------------ Action Methods -------------	
	
	public void explicitWaitConditions() throws InterruptedException {

		driver.get("https://the-internet.herokuapp.com/dynamic_controls");
		
		if (cb_checkBox_homePage.isSelected()) {
			System.out.println("CheckBox is selected successfully");
		}
		else {
			System.out.println("CheckBox is not selected yet");
		}
		
		Thread.sleep(2000);
		
		cb_checkBox_homePage.click();
		
		if (cb_checkBox_homePage.isSelected()) {
			System.out.println("CheckBox is selected successfully");
		}
		else {
			System.out.println("CheckBox is not selected yet");
		}
		
		Thread.sleep(2000);
		
		btn_removeAdd_homePage.click();
		
		WebDriverWait expliciteWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		//Element to Be Clickable: Waits until the element is present in the DOM and clickable.
		//This condition is useful when waiting for an element to become interactive, such as a button or a link.
		WebElement element = expliciteWait.until(ExpectedConditions.elementToBeClickable(By.id("elementId")));

		//Visibility of Element: Waits until the element is present in the DOM and visible. 
		//This condition is useful when waiting for an element to become visible on the web page.
	    WebElement element2 = expliciteWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("elementId")));
		
		//Invisibility of Element: Waits until the element is no longer visible on the web page. 
		//This condition is useful when waiting for an element to disappear, such as a loading spinner or a popup.
	    boolean elementInvisible = expliciteWait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("elementId")));

		//Presence of Element: Waits until the element is present in the DOM, regardless of its visibility. 
		//This condition is useful when waiting for an element to be added to the DOM.
	    WebElement element3 = expliciteWait.until(ExpectedConditions.presenceOfElementLocated(By.id("elementId")));

		//Text to Be Present in Element: Waits until the specified text is present within the element. 
		//This condition is useful when waiting for dynamic content to appear.
	    boolean textPresent = expliciteWait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("elementId"), "expectedText"));

		//Title Contains: Waits until the title of the web page contains the specified text.
		boolean titleContains = expliciteWait.until(ExpectedConditions.titleContains("expectedText"));
		
		
		//Declare and initialise a fluent wait
		FluentWait fluentWait = new FluentWait(driver);
		
		fluentWait.withTimeout(Duration.ofSeconds(30)) // Maximum wait time
        .pollingEvery(Duration.ofSeconds(5)) // Frequency of checks
        .ignoring(NoSuchElementException.class); // Ignore NoSuchElementException

		
		//This is how we specify the condition to wait on.
		//This is what we will explore more in this chapter
		fluentWait.until(ExpectedConditions.alertIsPresent());

	}

}
