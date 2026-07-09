package com.automation.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UnderstandingLocators {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("file://D:/Mamma/Dilshad/3RI/Selenium/HTML/Prg1.html");
		
		// LOcate USername textbox using the id locator , and send text to it
		driver.findElement(By.id("username")).sendKeys("Dilshad");
		
		// Locate Password using name locator
		driver.findElement(By.name("pass")).sendKeys("xyx");
		
		// Locate Login Button and click it 
		driver.findElement(By.id("loginBtn")).click();
		
		
		// Thread.sleep(5000);
		
		// driver.quit();

	}

}
