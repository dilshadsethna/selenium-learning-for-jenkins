package com.automation.scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseVsQuit {
	
	public static void main(String[] args) throws InterruptedException {
	
		WebDriver driver = new ChromeDriver();	
		driver.manage().window().maximize();
	
		// Opens a URL in the Browser Window
		driver.get("https://www.amazon.com/");
		Thread.sleep(2000);
	
		// Open NEW TAB in browser
		driver.switchTo().newWindow(WindowType.TAB);
    
		// Second tab
		driver.get("https://www.google.com/");
    
		// Close Browser
		// close() - Closes ONLY current browser window , only the current tab
		// quit() - Closes ENTIRE browser session, all tabs and ends webdriver session, also frees memory - use this preferably
		// close leaves the driver instance , quit will flush / destroy the driver instance
		
		System.out.println("Driver before is : " + driver);
		
		// driver.close();
		driver.quit();
				
		System.out.println("Driver after is : " + driver);
	}
		
}
