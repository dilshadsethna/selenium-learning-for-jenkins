package com.automation.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocateByCssSelector {

	public static void main(String[] args) {
	
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("http://tutorialsninja.com/demo/index.php?route=account/register");
				
		// Syntax 1 : tagname[attribute='value'] - for First Name
		driver.findElement(By.cssSelector("input[name='firstname']")).sendKeys("Dilshad");
		
		// Compare this with xpath - use //tagname[@attribute = 'value']" - So cssSelector has no // and no @
		// driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Sethna");
		
		// Syntax 2 : "tagname#idvalue"  - for Last Name (use this only with id attribute)
		driver.findElement(By.cssSelector("input#input-lastname")).sendKeys("Sethna");
		// driver.findElement(By.cssSelector("inout[id = 'input-lastname']")).sendKeys("Sethna");
			
		// Syntax 4 : starts with : "tag[attribute^=value]"  - for Email
		driver.findElement(By.cssSelector("input[type^='em']")).sendKeys("dilshad@gmail.com");
				
		// Syntax 5 : end with - "tag[attribute$=value]" - for Telephone
		driver.findElement(By.cssSelector("input[name$='phone']")).sendKeys("9999999999");
		// driver.findElement(By.cssSelector("input[id$='one']")).sendKeys("8888888888");
		
		// Syntax 6 : contains - "tag[attribute*=value]" - for Password
		driver.findElement(By.cssSelector("input[type*='assw']")).sendKeys("Dilshad"); 
		
		// radio button - using 2 attributes (works as an AND]
		driver.findElement(By.cssSelector("input[type = 'radio'][value = '1']")).click();
				
		// Syntax 3 : tagname.classname - Very useful when we have multiple classes (tagname.classname1.classname2)
		// Remember .. className Locator can only use a SINGLE CLASS NAME
		
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		
		// OR - Using Syntax 1 
		driver.findElement(By.cssSelector("input[class = 'btn btn-primary']")).click();
		
		// OR - Using xpath  
		// driver.findElement(By.xpath("//input[@class = 'btn btn-primary']")).click();
		
	}

}
