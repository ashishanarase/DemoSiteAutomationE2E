package com.DemoQA.PageLayer;

import java.util.Set;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.PageFactory;
import com.DemoQA.TestBase.TestBase;

public class TC15_MultipleTabAndWindows extends TestBase {

	//this is sample class

	public TC15_MultipleTabAndWindows () {
		PageFactory.initElements(driver, this);
	}

	//------------ Xpath Repository -------------

	// Using @FindBy to locate a single element by ID



	//------------ Action Methods -------------	

	public void multipleWindow() throws InterruptedException {

		driver.get("https://www.google.com/");
		// Opens a new window and switches to new window

		String title1 = driver.getTitle();

		System.out.println("Script focus on "+ title1);

		driver.switchTo().newWindow(WindowType.WINDOW);

		// Opens LambdaTest homepage in the newly opened window
		driver.navigate().to("https://www.lambdatest.com/");

		String title2 = driver.getTitle();

		System.out.println("Script focus on "+ title2);
		
		Set <String> list = driver.getWindowHandles();
		
		System.out.println(list);

	}
	
	public void multipleTab() throws InterruptedException {

		driver.get("https://www.youtube.com/");
		// Opens a new window and switches to new window

		String title1 = driver.getTitle();

		System.out.println("Script focus on "+ title1);

		driver.switchTo().newWindow(WindowType.TAB);

		// Opens LambdaTest homepage in the newly opened window
		driver.navigate().to("https://www.flipkart.com/");

		String title2 = driver.getTitle();

		System.out.println("Script focus on "+ title2);
		
		Set <String> list = driver.getWindowHandles();
		
		System.out.println(list);

	}

}
