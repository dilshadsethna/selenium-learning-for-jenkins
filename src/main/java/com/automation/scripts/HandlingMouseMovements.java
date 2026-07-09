package com.automation.scripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HandlingMouseMovements {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.istqb.in/index.php");
		Thread.sleep(4000);
		
		// Move to 'Specialist' Menu Option
		// Locate the Web Element 'Specialist'
		
		WebElement specialist = driver.findElement(By.linkText("SPECIALIST"));
		
		// Create an Object of Class Actions : This is used when we want to do Mouse Movements such as 
		// - Move the mouse hover certain elements
		// - Drag and Drop (Done in the next program)
		// - Click or Right click and so on.
		
		// build() method creates an action AND perform() method will execute the action
				
		Actions act = new Actions(driver);
	
		act.moveToElement(specialist).build().perform();
		Thread.sleep(1000);
				
		// Now Move  to Element "PROCEDURE" and Click on it
		WebElement procedure = driver.findElement(By.linkText("PROCEDURE"));
		act.moveToElement(procedure).build().perform();
		act.click().build().perform();
		
		Thread.sleep(3000);
		
	
		// 2. Lets Print all the Menu Options Under 'Specialist'
		// First Move Back
		driver.navigate().back();
		
		Thread.sleep(2000);
		
		// Move to Specialist
		
		specialist = driver.findElement(By.linkText("SPECIALIST"));
		act.moveToElement(specialist).build().perform();
		Thread.sleep(2000);
		
		// Get all the sub menu options in a List
		// Store this in a List of WebElements
		
		// xpath : Find the anchor <a> - 'specialist' - Move to its sibling dropdown <div> - Then find all <li>
		
		List <WebElement> suboptions = driver.findElements(By.xpath("//a[@href='/specialist']/following-sibling::div//li"));
		
		for (WebElement we : suboptions)
		{
			System.out.println(we.getText());
		} 
		
		driver.quit();
	}

}
