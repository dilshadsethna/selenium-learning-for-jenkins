package com.automation.scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LaunchFirefox {

	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();	
		driver.get("https://www.google.co.in/");

	}

}
