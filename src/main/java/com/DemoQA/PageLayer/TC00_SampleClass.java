package com.DemoQA.PageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.PageFactory;

import com.DemoQA.TestBase.TestBase;

public class TC00_SampleClass extends TestBase {
	
	//this is sample class
	
	
	public TC00_SampleClass () {
		PageFactory.initElements(driver, this);
	}
	
	//------------ Xpath Repository -------------
	
	// Using @FindBy to locate a single element by ID
    @FindBy(xpath = " ")
    private WebElement prefix_name_page;

    // Using @FindBys to locate an element with multiple criteria (AND)
    //where it uses a logical AND between the conditions.
    @FindBys({
        @FindBy(id = " "),
        @FindBy(tagName = " ")
    })
    private WebElement prefix_name_page2;

    // Using @FindAll to locate an element with multiple criteria (OR)
    //where it uses a logical OR between the conditions.
    @FindAll({
        @FindBy(id = " "),
        @FindBy(className = " ")
    })
    WebElement prefix_name_page3;
    
    
	//------------ Action Methods -------------	
	
	public void sampleMethod() {
		
	}

}
