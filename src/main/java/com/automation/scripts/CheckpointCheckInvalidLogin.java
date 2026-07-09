package com.automation.scripts;

import java.time.Duration;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CheckpointCheckInvalidLogin {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		// This page opens faster on Firefox
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		
		// For Taking proper screenshots - Better screenshot size
		// Note : this will overridde the maximize ... and set it to this proper size
		driver.manage().window().setSize(new Dimension(1920, 1080));
				
		
		// Wait			
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));	
		
		// open page
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		// Login with invalid credentials
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		// Check if Login is NOT Successful, and error message displayed 
		// - Login Button is still visible and correct error message is displayed
		// - do a findElements() for both these , and see if the size of the list is 1 (means element is there)
		
		int foundErrorMessage = driver.findElements(By.xpath("//p[text() = 'Invalid credentials']")).size();
		int foundLoginButton = driver.findElements(By.xpath("//button[@type='submit']")).size();
		
		if ((foundErrorMessage == 1) && (foundLoginButton == 1))
		{
			System.out.println("Login is NOT Successful with Invalid Credentials - Test Passed");
			
			// Capture Screenshot - ideally , this should be done when Test FAILS
			// But since we do not have a failure , we are doing it here 
			// V.IMP : add the setsize() method , after creating the driver instance
			// Without this , screenshots may not appear proper
			
			// Step1:
			// Cast the driver object into the TakesScreenshot interface type.
			// Note: 'ts' is NOT a new object (we do not create objects of an interface).
			// It is only another reference variable pointing to the SAME driver object.
			// The actual browser driver class (ChromeDriver/FirefoxDriver/etc.) already implements TakesScreenshot.
			// Casting the driver allows us to access screenshot-related methods like getScreenshotAs().
			TakesScreenshot ts = (TakesScreenshot) driver;
			
			// Step2:
			// takes a snapshot of the browser screen, stores it temporarily in an 'image file'
			// returns this temporary file object
			Thread.sleep(5000);
			File sourceFile = ts.getScreenshotAs(OutputType.FILE);
				
			// Step3: 
			// Create folder 'Screenshots' if not present (u can also do this manually)
			// - create a FILE object
			// - mkdirs() physically creates the folder on the computer.
			File folder = new File("./Screenshots");
			folder.mkdirs();
			
			// Step4: 
			// Creates a File object representing the destination screenshot path (LoginFailure.png' in the 'Screenshots' folder)
			// The actual physical file will be created during Files.copy().
			// V IMP - u will need to delete this file before running again , else u will get a exception
			// java.nio.file.FileAlreadyExistsException
			// Otherwise , use the 'StandardCopyOption.REPLACE_EXISTING' parameter, in the Files.copy
			File destinationFile = new File(folder, "LoginFailure.png");
			
			// Step5:
			// This copies the temporary screenshot file into your physical file (created above)
			// Modern Java file operations use Path objects (java.nio.file) instead of the older File class.
			// File operations like move , copy , delete etc. work with Path objects, not FILE objects.
			// 'Path' simply represents the location of a file/folder in the file system
			// Selenium screenshot API returns a File object,  which we convert into a Path object using toPath()
			
			// Files.copy(sourceFile.toPath(), destinationFile.toPath());
			Files.copy(sourceFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
			System.out.println("Screenshot saved successfully");		
		}
		else
		{
			System.out.println("Test Failed - Check Error Message");
			
			// Ideally , the screenshot code should be here
		}
		
		driver.quit();
	}

}
