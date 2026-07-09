package com.automation.scripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocateByClass {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		// Wait till the page loads - This is Implicit Synchronisation
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
				
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		// Locate Username and Password
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		
		// Locate Login Button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Thread.sleep(2000);
		// Locate User  Image - By Classname locator
		driver.findElement(By.className("oxd-userdropdown-img")).click();
		
		// Locate USer Image - By css selector Syntax : tagname.class - this is what we did in CSS Selector 
		// driver.findElement(By.cssSelector("img.oxd-userdropdown-img")).click();
		
		Thread.sleep(1000);
		
		// Click on Logout
		driver.findElement(By.linkText("Logout")).click();
		
		Thread.sleep(3000);
		driver.quit();

	}

}
