package com.DemoQA.TestLayer;

import java.util.ArrayList;
import java.util.List;
import org.testng.TestNG;
import org.testng.annotations.Test;
import com.DemoQA.PageLayer.TC02_HomePage;
import com.DemoQA.PageLayer.TC03_WebElementTypes;


public class TestSuiteClassExample {

	@Test
	public void runTestSuite () {

		// Create a TestNG object
		TestNG testng = new TestNG();

		// Create a list of test classes
		List<Class<?>> testClasses = new ArrayList<>();
		testClasses.add(TC02_HomePage.class); 
		testClasses.add(TC03_WebElementTypes.class); 

		// Set the list of test classes
		Class<?>[] classesArray = testClasses.toArray(new Class<?>[0]);
		testng.setTestClasses(classesArray);

		// Run the test suite
		testng.run();
	}


//Class Brace	
}


