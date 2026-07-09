package com.automation.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
// import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BasicLocators {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		
		// Open webpage and maximise browser
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");
		driver.manage().window().maximize();
		
		// Locate the First Name text box and Enter Data
		// driver.findElement(By.name("firstname")).sendKeys("Dilshad");
		
		// To remember - driver.findElement() - returns a webElement , which u can store , and then use
		WebElement x = driver.findElement(By.name("firstname"));
		x.sendKeys("Dilshad");
		
		
		// Locate the Last Name Text Box and Enter Data - By id
		driver.findElement(By.id("input-lastname")).sendKeys("Sethna");
		
		// LOcate the Last Name Text Box and Enter Data - By name
		driver.findElement(By.name("email")).sendKeys("dilshad.s@gmail.com");
		
		// Locate the Privacy Checkbox and click on it - By name
		driver.findElement(By.name("agree")).click();
		
		// Locate the Privacy Policy Link and Click on it - By linkText / partialLinkText
		
		// driver.findElement(By.linkText("Privacy Policy")).click();
		// driver.findElement(By.partialLinkText("vacy")).click();
		driver.findElement(By.partialLinkText("Privacy")).click();
		
		driver.findElement(By.className("btn btn-primary")).click();
		Thread.sleep(2000);
		
		// Close Browser
		driver.quit();
		
		// TO Do - FILL THE ENTIRE FORM EXCEPT THE RADIO BUTTON ... Why ??? will do that later using xpath
		// driver.findElement(By.xpath("//input[@type='radio' and @value = '0']")).click();
		

	}

}
