package com.automation.scripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocateByXpath_1 {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		// Wait till the page loads - This is Implicit Synchronisation
		// This will wait at 10 seconds for any findElement command
		// THis step has to be put IMMEDIATELy after creting the driver instance
				
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
		
		/*
		
		// Absolute xpath : Right click - Inspect - right click on the html element and copy xpath
		// To verify xpath ... Cntrl-f , paste xpath and see that element gets highlighted 
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		

		// Locate Username , password using xpath , and enter data
		driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")).sendKeys("admin");
		driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input")).sendKeys("admin123");
			
		// Locate the Login Button by xpath and click it
		driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
		
		*/
		
				
		
		// Relative xpath
		/*
		// 1. Syntax : //tagname[@attribte = 'value'] - Login Page of OrangeHRM
		
		// Locate Username , Password and Login Button
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.findElement(By.xpath("//input[@name= 'username']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@type = 'password']")).sendKeys("admin123");	
		driver.findElement(By.xpath("//button[@type = 'submit']")).click();
		
		driver.findElement(By.xpath("//img[@class = 'oxd-userdropdown-img']")).click(); 
		driver.findElement(By.linkText("Logout")).click(); */
		 
		/*
		// 2. Syntax : 
		//  // tagname[text() = 'value']				Exact Text Match
		//  //tagname[contains(text(), 'text')] 		Partial Text Match

		// Google - click on images link
		driver.get("https://www.google.co.in/");
		
		// driver.findElement(By.xpath("//a[text() = 'Images']")).click();
		driver.findElement(By.xpath("//a[contains(text(), 'Ima')]")).click(); 
		
		driver.quit();
		
		*/
		
		
		
		// 3. Syntax : //tagname[@attribte = 'value' and @attribte = 'value']
		//             //tagname[@attribte = 'value' or @attribte = 'value'] 
		// Use this when there may be more than one element withn the same attribute and u want to use another attribute also
		
		
		driver.get("https://www.google.co.in/");
		Thread.sleep(1000);
		// locate google search field - try both 'and' and 'or'
		driver.findElement(By.xpath("//textarea[@class='gLFyf' and  @name = 'q']")).sendKeys("Selenium Webdriver"); 
		
		
		// But actually Simpler wud just be using By.name !!!
		// driver.findElement(By.name("q")).sendKeys("Selenium Webdriver"); 
		 
		
		
		// Now go back to the BasicLocators.java .. and complete the radio button click
	}

}
