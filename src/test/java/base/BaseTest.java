package base;

/*
 	Earlier, every test had driver setup 
	Now we centralize it in ONE place , All test classes will reuse this (Inherit this class)
	Note : Anything common to all tests can go into BaseTest
 */

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

	public class BaseTest {

		// Driver object used by all test classes.
	    // Declared at class level so that setup(), test methods, and teardown() can use the same browser instance.
	    // Keep it protected so that child classes (LoginTest, PIMTest, etc.) can access it through inheritance.
		
	    protected WebDriver driver;
	    
	    // Properties object used to read values from config.properties (browser, url, username, password, etc.).
	    // Keep it protected so that child classes can directly access configuration values using p.getProperty().
	    
	    protected Properties p;

	    @BeforeMethod
	    public void setup() throws IOException {

	        
	    	// Load config.properties file, and read its values
	    	// Properties is a Java class. Used to store key-value pairs. e.g
	    	// 	Key			Value
	    	//	browser		firefox
	    	// 	username	Admin
	    	
	    	// 'p' is the object of the class
	    	// getResourceAsStream("config.properties") - locates file in the resources folder and opens it as a stream
	    	// getClassLoader() - to locate project resources/files.
	    	// getClass() - current class
	    	// so basically : Load all values from config.properties into the container object p
	    	
	    	// IMP NOTE : src/test/resources - folder is the standard location for framework configuration files in Maven projects
	    	
	    	// Later : p.getProperty("browser") : fetch specific browser value, and create specific browser object
	    	
	    	
	        p = new Properties();
	        p.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
	        
	        // Launch browser 
	        // driver = new FirefoxDriver();
	    	
	        
	    	// LATER ADD THIS 
	        // comment this , since browser is now a TestNG parameter
	    	String browser = p.getProperty("browser");

	    	if(browser.equalsIgnoreCase("chrome"))
	    	{
	    		driver = new ChromeDriver();
	    	}
	    	else if(browser.equalsIgnoreCase("firefox"))
	    	{
	    		driver = new FirefoxDriver();
	    	}
	    	else if(browser.equalsIgnoreCase("edge"))
	    	{
	    		driver = new EdgeDriver();
	    	}
	    	
	    	
	    	// Maximize
	        driver.manage().window().maximize();

	        // Implicit wait
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

   
	        // Open application
	        driver.get(p.getProperty("url"));
	    }

	    @AfterMethod
	    public void closeBrowser() {
	        driver.quit();
	    }
	}