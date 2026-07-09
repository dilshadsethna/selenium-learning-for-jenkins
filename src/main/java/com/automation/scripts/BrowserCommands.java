package com.automation.scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserCommands {

	public static void main(String[] args) throws InterruptedException  {
		
		WebDriver driver = new ChromeDriver();	
		
		// Maximise the browser window
		driver.manage().window().maximize();
				
		// Opens a URL in the Browser Window
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		System.out.println("First Current URL: " + driver.getCurrentUrl());
		System.out.println("First Page Title: " + driver.getTitle());
		
		// This is a concept of Syncronisation ... will do this in details a lil later
		// As of now , just understand this as pausing the script for x milliseconds .. here 2 seconds
		Thread.sleep(2000);
					
		// Minimise the browser window , and then again maximise
		
		driver.manage().window().minimize();
		Thread.sleep(2000);
		
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
				
		// Opens a URL in the Browser Window - Another Way of opening the URL
		driver.navigate().to("https://www.google.co.in/");
		System.out.println("Second Current URL: " + driver.getCurrentUrl());
		System.out.println("Second Page Title: " + driver.getTitle());
		Thread.sleep(2000);
				
		// Click on Back Arrow in Browser - previous page
		driver.navigate().back();
		Thread.sleep(2000);
				
		// Click on Forward Arrow in Browser - next page
		driver.navigate().forward();
		Thread.sleep(2000);
				
		// Refresh the page
		driver.navigate().refresh();
		Thread.sleep(2000);
		
					
		// Close Browser
		// We will see the diff between close and quit in the next example
		System.out.println("Driver before close is : " + driver);
		driver.close();
		System.out.println("Driver after close is : " + driver);				

	}

}
