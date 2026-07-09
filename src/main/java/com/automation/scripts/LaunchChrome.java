package com.automation.scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchChrome {

	public static void main(String[] args) throws InterruptedException {
		
		// Step 1: Create driver object
        WebDriver driver = new ChromeDriver();

        // Step 2: Open URL
        driver.get("https://www.google.com");
        
        // Pauses the test for some time
        Thread.sleep(2000);
        
        // Step 3: Print title
        System.out.println("Page Title: " + driver.getTitle());

        // Step 4: Close browser
        driver.quit();

	}

}
