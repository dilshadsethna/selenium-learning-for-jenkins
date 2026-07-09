package com.automation.scripts;


import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocateByTagName {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		
		driver.manage().window().maximize();
		
		driver.get("https://www.amazon.in/");
		Thread.sleep(2000);
		
		// Locate by tag name - this is normally used when we want to locate multiple elements 
		
		// findElements - returns a List of web elements
		
		// Here , we want a list of all LInks on the Amazon Page
		// Also , click on the "Mobiles" link
		
		String expectedLink =  "Mobiles";
		
		List <WebElement> allLinks = driver.findElements(By.tagName("a"));
		
		// for - each loop
		for (WebElement we : allLinks)
		{
			System.out.println(we.getText());
			
			// Try doing this and see what happens ..allLinks.
			// if (expectedLink.equalsIgnoreCase(we.getText()))
				// we.click();
		}
		
		
		/* Why can't you click inside the loop ? 
		 	- You collect all links, and store in the List
			- Loop starts printing text
			- When it finds "Mobiles" - clicks it
			- Page navigates (Amazon loads new page)
			- Now DOM is completely refreshed 
			- Loop continues - tries to use old elements - StaleElementReferenceException
			IMP : after click, the page changes, so your older elements are no longer valid.
		 */
		
		// So now if we want to click on a specific link , we need to do it outside of the loop
		driver.findElement(By.linkText(expectedLink)).click();

	}

}
