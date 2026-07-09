package com.automation.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class HandlingKeyboard {

	public static void main(String[] args) throws InterruptedException {
				
		WebDriver driver = new ChromeDriver();
		
		// Maximize Browser
		driver.manage().window().maximize();
		
		// Open the web page
		driver.navigate().to("http://tutorialsninja.com/demo/index.php?route=account/register");
		
		// Locate the firstname textbox using the 'name' locator
		driver.findElement(By.name("firstname")).sendKeys("Anita");
		
		// NOW ALL ELEMENTS WILL BE HANDLED USING KEYS ... WE DO NOT WANT TO LOCATE ANY OTHER ELEMENT NOW
		// Now get the current active element  - First Name , save that in a webElement
		// Send the Tab Key to go to the next field
		
		WebElement currentElement = driver.switchTo().activeElement();
		
		// Clicking on the TAb Key on the fname element
		currentElement.sendKeys(Keys.TAB);
		Thread.sleep(2000);
		
		// Now the Current Active Element is Last Name , save that as a Web Element
		// Lets say we send some wrong text here
		currentElement = driver.switchTo().activeElement();
		currentElement.sendKeys("Sharmi");
		currentElement.sendKeys(Keys.TAB);
		
		// Now the Current Active Element is email , save that as a Web Element 
		currentElement = driver.switchTo().activeElement();
		currentElement.sendKeys("xyz@gmail.com");
				
		// Now we want to move back to the Last Name field , and delete the incorrect content , and add new content
		// To send multiple keys  , use Keys.chord
		
		currentElement.sendKeys(Keys.chord(Keys.SHIFT, Keys.TAB));
		
		// Current active element is Last Name , which I am saving in a webelement
		currentElement = driver.switchTo().activeElement();
		
		Thread.sleep(1000);
		currentElement.sendKeys(Keys.DELETE);
		Thread.sleep(1000);
		currentElement.sendKeys("Sharma");
		
		// Assignment : To do as HW
		// Enter Data in All Fields , moving to each field using the Keyboard */
		
	}

}
