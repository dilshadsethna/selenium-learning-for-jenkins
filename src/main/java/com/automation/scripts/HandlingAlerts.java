package com.automation.scripts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class HandlingAlerts {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		// Open the URL
		driver.get("https://demoqa.com/alerts");
		
		// 1. SIMPLE ALERT
		// "Click Button to see alert" - Locate that button and click
		
		driver.findElement(By.id("alertButton")).click();
		Thread.sleep(2000);
		
		// Create an Object of Alert Class , and switch to the Alert
		
		Alert alt = driver.switchTo().alert();
		
		// Concept of Checkpoint / Assertion: 
		// To add an Expected Result to the Test Case , so that when the test executes
		// We can compare the Expected vs. Actual Result , and mark the Test as Passed or Failed
		
		
		// Checkpoint : Check that the Message on the Alert Window is correct
		String expectedmsg = "You clicked a button";
	
		// get text of the alert
		String actualmsg = alt.getText();
				
		System.out.println("Alert Message is : " + actualmsg);
				
				
		if (expectedmsg.contentEquals(actualmsg))
			System.out.println("Alert Message Correct .. Test Passed");
		else
			System.out.println("Alert Message InCorrect .. Test Failed");
		
		
		// Click on the OK Button on the Alert Window  - using alt.accept
		alt.accept();
		
		Thread.sleep(3000);
		
		/*
		// 2. CONFIRMATION ALERT
		// "On button click, confirm box will appear" - Locate that button and click
		
		driver.findElement(By.id("confirmButton")).click();
		alt = driver.switchTo().alert();
		Thread.sleep(1000);
		
		// Click OK
		alt.accept();
		
		// Click CANCEL
		//alt.dismiss();
		
		Thread.sleep(3000);
		
		// 3. PROMPT ALERT
		// "On button click, prompt box will appear" - Locate that button and click
		
		driver.findElement(By.id("promtButton")).click();
		alt = driver.switchTo().alert();
		
		alt.sendKeys("Hello Students");
		Thread.sleep(3000);
		
		// Click OK
		alt.accept();
				
		// Click CANCEL
		// alt.dismiss();
				
		Thread.sleep(3000);
		
		driver.quit(); */
		
		// For Practice of Alerts - use this page : https://demo.automationtesting.in/Alerts.html
	}

}
