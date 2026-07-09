package com.automation.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import org.openqa.selenium.interactions.Actions;

public class HandlingMouseMovementsDragDrop {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
			
		driver.get("http://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		
		// Create an Object of Class Actions : This is used when we want to do Mouse Movements 
		// Here we are going to do Drag and Drop
			
		Actions act = new Actions(driver);

		// Since the drag and drop element are inside a frame so we need to move to the Frame
		WebElement frame1 = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(frame1);
		
		Thread.sleep(2000);
			
		// Locating FROM drag-box 
		WebElement from_drag = driver.findElement(By.id("draggable"));

		// Locating  TO drag-box 
		Thread.sleep(2000);
		WebElement to_drop = driver.findElement(By.id("droppable"));
			
		// Up till now, we have not performed any actions on these elements
		
		// We use clickAndHold , moveToElement and release method
		/*
		act.clickAndHold(from_drag).build().perform();
		act.moveToElement(to_drop).build().perform();
		act.release(to_drop).build().perform(); */
		
		
		// Another way ... direct method
		// We use dragAndDrop method and give source to destination 
		act.dragAndDrop(from_drag, to_drop).build().perform();
		
		driver.quit();
		


	}

}
