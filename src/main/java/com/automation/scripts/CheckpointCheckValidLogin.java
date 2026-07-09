package com.automation.scripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CheckpointCheckValidLogin {

	public static void main(String[] args) {
		
		// This page opens faster on Firefox
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		
		// Wait			
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
		
		// open page
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		// Login with valid credentials
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		// Check if Login is Successful - 
		// - Page that opens after click of Login button has the heading "Dashboard" AND Login button Not visible
		// - do a findElements() for both these ; Dashboard Element - size == 1 , LoginButton - size == 0
		
		int foudDashboard = driver.findElements(By.xpath("//h6[text() = 'Dashboard']")).size();
		int foundLoginButton = driver.findElements(By.xpath("//button[@type='submit']")).size();
		
		if ((foudDashboard == 1) && (foundLoginButton == 0))
			System.out.print("Login is Successful with Valid Credentials - Test Passed");
		else
			System.out.print("Login is NOT Successful with Valid Credentials - Test Failed");
		
		driver.quit();
			
	}

}
