package com.automation.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocateByXpath_2 {

	public static void main(String[] args) {
		
		// Flipkart - Search 'iphone 16' - and get and print its price 
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		// Open Flipkart 
		driver.get("https://www.flipkart.com/");
		
		// Type 'iphone 16' in SearchBar
		driver.findElement(By.xpath("//div[@class = 'Afujtw']/input")).sendKeys("iphone 16");
		
		// Current Element - click enter
		WebElement search = driver.switchTo().activeElement();
		search.sendKeys(Keys.ENTER);
		
		// Note : You my need to save this file as a UTF-8 format due to the '₹' symbol
		// Window → Preferences - General → Workspace - change Text file encoding to: UTF-8
		
		WebElement cost = driver.findElement(By.xpath("//div[contains(text(), 'Apple iPhone 16')]/following :: div[contains(text(), '₹')]"));
		System.out.println("Cost = " + cost.getText());
	}
}
