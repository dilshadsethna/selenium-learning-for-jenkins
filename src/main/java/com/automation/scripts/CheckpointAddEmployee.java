package com.automation.scripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckpointAddEmployee {

	public static void main(String[] args) throws InterruptedException {
		// This page opens faster on Firefox
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
				
		// Wait			
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));	
				
		// open page
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		// Login with valid credentials
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		// Add Employe Page : open directly
		// driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/pim/addEmployee");
		
		// Add Employee Page - Open thru menus
		//driver.findElement(By.xpath("//span[text()='PIM']")).click();
		driver.findElement(By.xpath("//a[@href='/web/index.php/pim/viewPimModule']")).click();
		driver.findElement(By.xpath("//a[text()='Add Employee']")).click();
		
		String first_name ="Dilshad";
		String middle_name = "Pankaj";		
		String last_name = "Sethna";
		String expected_name = first_name + " " + last_name;
		
		driver.findElement(By.name("firstName")).sendKeys(first_name);
		driver.findElement(By.name("middleName")).sendKeys(middle_name);
		driver.findElement(By.name("lastName")).sendKeys(last_name);
		
		
		// Selenium is trying to click the button, BUT a loading overlay/spinner is sitting on top of it.
		// So Selenium CAN SEE the button, but cannot physically click it yet.
		// Wait until loader disappears.
		// how did we get this ? Run without these steps and see the error:
		// Exception in thread "main" org.openqa.selenium.ElementClickInterceptedException: 
		// Element <button class="oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space" type="submit"> is not clickable at point (1157,497)
		// because another element <div class="oxd-form-loader"> obscures it
		
		// Create a wait object - Explicit Synchronisation
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("oxd-form-loader")));
	
		driver.findElement(By.xpath("//button[@type = 'submit']")).click();

		
		// Checkpoint - Check that the employee is added correctly
		// - check the name above the profile picture , to see if it is the same as the name we saved
		
		// V IMP : Wait till the name element is visible , and then sleep for some time , for the text to be loaded
		// Remember - Visible ≠ fully loaded with data
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='orangehrm-edit-employee-name']/h6")));
		Thread.sleep(3000);
				
		String actual_name = driver.findElement(By.xpath("//div[@class = 'orangehrm-edit-employee-name']/h6")).getText();
		System.out.println("Actual Name = " + actual_name);
				
				if(expected_name.equalsIgnoreCase(actual_name))
					System.out.println("Test Passed .. Employee Added Correctly");
				else
					System.out.println("Test Failed .. Employee Not Added Correctly");
				
		// just to see the page - THIS IS NOT FOR SYNCHRONISATION - ONLY FOR DEMO PURPOSE 
		Thread.sleep(5000); 
		
		driver.quit();

	}

}
