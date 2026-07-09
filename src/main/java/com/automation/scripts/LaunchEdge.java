package com.automation.scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class LaunchEdge {

	public static void main(String[] args) {
		
		WebDriver driver = new EdgeDriver();	
		driver.get("https://www.google.co.in/");

	}

}
