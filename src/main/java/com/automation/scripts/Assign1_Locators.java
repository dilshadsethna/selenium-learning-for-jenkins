package com.automation.scripts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

// Assignment 1 - Locators 
// 1. Login to ORHM , Click on Search , and enter some value  and click enter

// 2. https://rahulshettyacademy.com/AutomationPractice/ 
// A. select any 1 radio button
// B. From the course table , get the price for course "Selenium Webdriver with Java Basics + Advanced + Interview Guide" and print in the console
// C. Select 'Option2' from the Dropdown List   
// D. Click on the 'Option1' checkbox

// 3. https://demo.automationtesting.in/Register.html
// Fill this entire Form

public class Assign1_Locators {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		
		// Synchronisation
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.manage().window().maximize();
		
		/*
		// Part 1 
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		// Locate Username and Password
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		
		// Locate Login Button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		
		// Search Field , and enter text
		driver.findElement(By.xpath("//input[@placeholder = 'Search']")).sendKeys("Performance");
		// click on the search result
		driver.findElement(By.cssSelector("span[class = 'oxd-text oxd-text--span oxd-main-menu-item--name']")).click();
		
		// Sleep - to see the page , before moving to part 2 of assignment
		Thread.sleep(5000);
		
		*/
		// Part 2 
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		// A. select any 1 radio button
		driver.findElement(By.xpath("//input[@value = 'radio1']")).click();
		
		
		// B. From the course table , get the price for course "Selenium Webdriver with Java Basics + Advanced + Interview Guide" and print in the console
		
		WebElement x = driver.findElement((By.xpath("//td[text() = 'Selenium Webdriver with Java Basics + Advanced + Interview Guide']/parent::tr/td[3]")));
		System.out.println("Price of Course is : " + x.getText());
		
		// C. Select 'option2' from dropdown list
		WebElement Category = driver.findElement(By.id("dropdown-class-example"));
		Select Cat = new Select(Category);
		Cat.selectByVisibleText("Option2");
		
		
		// D. Click on the 'Option1' checkbox
		
		// Easiest and cleanest
		// driver.findElement(By.id("checkBoxOption1")).click();
		
		// OR
		
		driver.findElement(By.xpath("//input[@id = 'checkBoxOption1']")).click();
		
		// OR - JUST TOM UNDERSTAND THE XPATH / and // and normalize-space 
		
		// find the label that has text "option1" (remove all spaces) and folowed immediately by input
		// driver.findElement(By.xpath("//label[normalize-space()='Option1']/input")).click();
		
		// OR IF U Want to not hardcode the checkbox to be selected , but store it in  a variable , u can do this 
		// here select Option2
		List<WebElement> labels = driver.findElements(By.xpath("//div[@id='checkbox-example']//label"));

		String expectedOption = "Option2";

		for (WebElement label : labels) {
		    String text = label.getText().trim();

		    if (text.equals(expectedOption)) {
		        label.findElement(By.tagName("input")).click();
		        break;
		    }
		}
		
		Thread.sleep(5000);
		
		//Close Browser
		driver.quit();
		

	}

}
