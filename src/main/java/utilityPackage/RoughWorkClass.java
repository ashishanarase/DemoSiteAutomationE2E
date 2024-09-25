package utilityPackage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RoughWorkClass {


	private static int maxWaitTime = 15;

	private static String appUrl = "https://www.amazon.in";

	public static WebDriver driver;

	private static String searchKey = "One Plus Mobiles";

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();		

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(maxWaitTime));

		Actions action = new Actions(driver);

		JavascriptExecutor jScript = (JavascriptExecutor) driver;

		driver.get(appUrl);

		WebElement element1 = wait.until(ExpectedConditions.visibilityOf
				(driver.findElement(By.xpath("//div[@id='nav-search-dropdown-card']"))));

		WebElement element2 = wait.until(ExpectedConditions.visibilityOf
				(driver.findElement(By.id("nav-search-dropdown-card"))));		
		
		element2.click();
		
		WebElement element3 = wait.until(ExpectedConditions.visibilityOf
				(driver.findElement(By.xpath("//select[@aria-describedby='searchDropdownDescription']"))));

		// Initialize the Select class with the dropdown element
		Select selObject = new Select(element3);


		// Use the getOptions() method to retrieve all options
		List<WebElement> allOptions = selObject.getOptions();

		// Create a list to store the text of each dropdown option
		List<String> optionsTextList = new ArrayList<>();

		// Loop through all options, log the visible text, and add it to the list
		for (WebElement option : allOptions) {
			String optionText = option.getText();  // Get the visible text of the option
			optionsTextList.add(optionText);  // Add the option text to the list
		}

		System.out.println(true);

	}
}
