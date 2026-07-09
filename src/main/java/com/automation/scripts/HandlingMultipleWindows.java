package com.automation.scripts;

import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 In Selenium WebDriver, there is NO real difference between a tab and a new browser window at the API level.
 Selenium treats BOTH as window handles. So the same logic works whether it's:
	- a new tab
	- or a completely separate browser window
 */

public class HandlingMultipleWindows {

	public static void main(String[] args) throws InterruptedException {
		
		// Launch Chrome Browser
		WebDriver driver = new ChromeDriver();
		
		// Get URL
		driver.get("https://demo.automationtesting.in/Windows.html");
		driver.manage().window().maximize();
		
		// Store the Window handle of the current (parent) window
		String parentWindow = driver.getWindowHandle();
		
		// NEW TABBED WINDOWS
		
		// Locate 'Click' Button and click it
		driver.findElement(By.xpath("//a[@href = 'http://www.selenium.dev']/button")).click();
		
		
		// Can't directly access elements on the newly opened page
		// driver.findElement(By.linkText("Register now!")).click();
		
		
		// To Handle Multiple Windows : 'handle' is a Set of window handles
		Set <String> handle = driver.getWindowHandles();
		
		// This is a For-Each Loop(enhanced for loop):
		// for-each loop is introduced in java 1.5v.
		// this loop is mainly used to retrieving the elements in array and collections
		// Syntax:
		// for(declaration:expression){
		//		statements;
		//	}
		
							
		for (String h : handle)
		{
			// printing the window handle
			System.out.println(h);
			// Switch to the Window . and getting the title
			String pageTitle = driver.switchTo().window(h).getTitle();
			System.out.println("Window Title : " + pageTitle);
			
			// Now Check if the Page Title is Selenium 
			// If it is , then Click on the "Register Now" Link
			if (pageTitle.contentEquals("Selenium"))
			{
				// Click on "Register Now"								
				driver.findElement(By.linkText("Register now!")).click();
			}
		}
		
		Thread.sleep(5000);
		
				
		// switch back to parent window
		driver.switchTo().window(parentWindow);
		
		// NEW SEPERATE WINDOWS
		
		// Click on 'Open New Seperate Windows'
		driver.findElement(By.xpath("//a[@href='#Seperate']")).click();
		
		Thread.sleep(2000);
		
		// Click on button
		driver.findElement(By.xpath("//button[@onclick='newwindow()']")).click();
		
		// To Handle Multiple Windows : 'handle' is a Set of window handles
		// Remember - it does not matter if windows opens on the same browser , or on a different browser instance 
		// handling it remains the same.
		handle = driver.getWindowHandles();
		
		for (String h : handle)
		{
			// printing the window handle
			System.out.println(h);
			// Switch to the Window . and getting the title
			String pageTitle = driver.switchTo().window(h).getTitle();
			System.out.println("Window Title : " + pageTitle);
			
			// Now Check if the Page Title is Selenium 
			// If it is , then Click on the "Register Now" Link
			if (pageTitle.contentEquals("Selenium"))
			{
				driver.findElement(By.linkText("Register now!")).click();
			}
		}

		Thread.sleep(3000);
		// driver.close() will   only the last window (current window)
		// driver.close();
		
		
		// driver.quit() will close all windows - close the browser
		driver.quit(); 
		
		
	}

}
