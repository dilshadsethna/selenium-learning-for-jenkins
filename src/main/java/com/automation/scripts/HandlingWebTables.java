package com.automation.scripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class HandlingWebTables {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		// Go To the "Table" URL
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		// 1. PRINT DATA OF THE ENTIRE TABLE 
		
		// Traverse the Entire Table - and print the contents of the entire table
		
		// Locate the Table Using xpath
		// Note : There are 2 tables with the same id = "Product" 
		
		// First one has id = "Product" and name = "courses" - so to select this use
		// xpath = //table[@id = "product" and @name = "courses"]
		
		// Second table has id = "Product" but does not have a name attribute - so to select this use
		// xpath = //table[@id = "product" and not (@name)]
		
		// Another way of doing this is : 
		// xpath : (//table[@id='product'])[1] - remember , xpath starts with index 1 (not 0 ) - so this means first table with id = "product"
		// But this is not very reliable because
		// - Depends on position
		// - Breaks if New table gets added above or Order changes
		// Use index based xpath only if No unique attribute exists
		
		
		WebElement mytable = driver.findElement(By.xpath("//table[@id = 'product' and @name = 'courses']"));
		
		
		// Locate All Rows by tagname <tr> and store in a List
		List<WebElement> all_rows = mytable.findElements(By.tagName("tr"));
		
		int total_rows = all_rows.size();
		 
		// Start the Loop From row 1 ; since row 0 had headings - which we don't want to print
		for (int i = 1; i < total_rows; i++) 		
		{
			// Locate All Cells (by tagname <td>) of the ith row , and store in a List
			List<WebElement> all_columns  = all_rows.get(i).findElements(By.tagName("td"));
			
			int total_columns = all_columns.size();
			
			for (int j = 0 ; j < total_columns; j++) 
			{
					System.out.println(all_columns.get(j).getText());
			}
		} 
		
	/*
			
		// 2. SEARCH FOR A VALUE IN THE TABLE
		// e.g Search for a particular Course and Find its price
		
		String expectedname = "WebSecurity Testing for Beginners-QA knowledge to next level";
		String actualname = "";
		int flag = 0; // flag will be used to tell us if name is present in table , flag = 1 , then name is present
				
		// Locate the Table Using xpath
		WebElement mytable = driver.findElement(By.xpath("//table[@id = 'product' and @name = 'courses']"));
				
		List<WebElement> all_rows = mytable.findElements(By.tagName("tr"));
		
		int total_rows = all_rows.size();
		
		// Start the Loop From row 1 ; since row 0 had headings
		for (int i = 1; i < total_rows; i++) 		
		{
			// Locate All Cells of the Row , and store in a List
			List<WebElement> all_columns  = all_rows.get(i).findElements(By.tagName("td"));
			
			// Get the text of cell 1 of the row (cells start from 0 , so name is in cell 1 , cost will be in cell 2 )
			actualname = all_columns.get(1).getText();
			if (expectedname.contentEquals(actualname))
			{
				System.out.println("Course Name : " + expectedname + "  , Course Cost : " + all_columns.get(2).getText());
				flag = 1;
				break;
			}
		} 
		if (flag == 0)
			System.out.println("Course Name : " + expectedname + " Not Found in Table"); 
		
		driver.quit();*/
	}

}
