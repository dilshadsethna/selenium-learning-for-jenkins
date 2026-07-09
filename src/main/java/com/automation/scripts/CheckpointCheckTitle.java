package com.automation.scripts;

// Checkpoint - Check the Title of a Page 
// Used to Compare Expected Title of Page  with Actual Title Of Page
// This is useful mainly during Navigation testing; to check that the correct page has opened

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class CheckpointCheckTitle {

	public static void main(String[] args) {
		
		WebDriver  driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		String expectedTitle = "OrangeHRM";
	    String actualTitle = driver.getTitle();

	    System.out.println("Actual Title is : " + actualTitle);

	    // checkpoint code - compare the expected and actual title
	    
	    if (actualTitle.contentEquals(expectedTitle))
	    	System.out.println("Title same ...Test Passed!");
	    else
	    	System.out.println("Title not same ...Test Failed");
	    
        driver.quit();
	}
}
