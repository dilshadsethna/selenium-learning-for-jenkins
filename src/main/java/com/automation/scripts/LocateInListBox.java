package com.automation.scripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LocateInListBox {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		// identify the list element
		WebElement Category = driver.findElement(By.id("dropdown-class-example"));
		Select Cat = new Select(Category);
		
		// Three ways of selecting options from drop down list 
		// 1. By Visible Text - the text that you can see in the list
		// 2. By Index - the index or position of the value in the list. Index starts from 0
		// 3. By Value - Inspect the Element By FireBug , and expand the "Select Id = "XX..." in the HTML Code
		//    - You will see all the values of the list with "option value = "......"
	
		// Cat.selectByVisibleText("Option2");
		// Cat.selectByValue("option2");
		Cat.selectByIndex(2); 

	}

}
