package com.automation.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TryXpath {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demoqa.com/webtables");
		driver.manage().window().maximize();
		
		// print salary for Cierra / Alden  - whatever name you want
		String name = "Alden";
		
		
		// WebElement x = driver.findElement(By.xpath("//td[text() = 'Cierra']/parent::tr/td[5]"));
		
		// If you want to use the variable 
		// REmember - XPath is a string — Java variables must be concatenated into it.
		
		WebElement x = driver.findElement(By.xpath("//td[text() = '" + name + "']/parent::tr/td[5]"));
		System.out.println("Salary is : " + x.getText());

	}

}
