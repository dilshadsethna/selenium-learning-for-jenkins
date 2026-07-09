package com.automation.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class HandlingFrames {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
				
		driver.manage().window().maximize();
		driver.navigate().to("https://demo.automationtesting.in/Frames.html");
		
		// You can directly access this button "Single iFrame" , since its on the main browser page
		
		WebElement button1 = driver.findElement(By.xpath("//a[@href = '#Single']"));
		button1.click();
		
		System.out.println("Button 1 Text = " + button1.getText());
		
		// What is a frame / iframe
		// A frame is a webpage inside the main webpage
		// Look at the Page Source ... see the frame names. 
		
		// SINGLE FRAME
		
		
		// Try to directly access the textbox, U will get an error, since its inside a frame
		// driver.findElement(By.xpath("//input[@type = 'text']")).sendKeys("Hello"); // Error 
		
		// To access the elements in a frame , you need to switch to the frame
		// How to move to a Frame ? You can do this in any of the following ways
		// 1. Using the Frame Id (if its present)
		// 2. Using the Frame Name (if its present)
		// 3. Using the Frame Webelement (locate the element using xpath / css and store in a webelement)
		// 4. Using Frame Index (starts from 0) - not the best method
		
		// Step1 : switch to frame
		
		// driver.switchTo().frame("singleframe"); 	// frame id
		// driver.switchTo().frame("SingleFrame"); 	// frame name
		// driver.switchTo().frame(0); 				// frame index
		
		WebElement f = driver.findElement(By.xpath("//iframe[@src='SingleFrame.html']"));	// WebElement 
		driver.switchTo().frame(f);
		
		// Step 2: interact with textbox
		driver.findElement(By.xpath("//input[@type = 'text']")).sendKeys("Hello Single Frame");
		
		
		// now try this : click on the "Iframe with in an Iframe" button - u will not be able to , since u are currently inside the frame
		// So u need to come back to the parent frame / window 
		// Note : you cannot switch from one child frame to the next child frame 
		// Need to go back to the Parent Frame , and then move to the next child frame
		// 2 ways of doing this ... switchTo().parentFrame() OR switchTo().defaultContent()
		
		
		// driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();
		
		// NESTED FRAMES
		
		WebElement button2 = driver.findElement(By.xpath("//a[@href = '#Multiple']"));
		button2.click();
		
		System.out.println("Button 2 Text = " + button2.getText());
		
		// Now to access the text box in the nested (inner frame)
		
		// Step 1: switch to outer frame
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']")));

		// Step 2: switch to inner frame
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='SingleFrame.html']")));

		// Step 3: interact with textbox
		driver.findElement(By.xpath("//input")).sendKeys("Hello Nested Frame");

		Thread.sleep(5000);
		
		// Step 4 (optional): go back to main page - if u want to access anything else
		driver.switchTo().defaultContent();
		
		driver.quit();
		
		
		// try this is on the rahulshettyacademy website.
		// https://rahulshettyacademy.com/AutomationPractice/ 
		// click on button in the frame and then go back to main page and enter some text in the text box 
		
		}

	}
