/* Simple TestNG Class
 * - Two test cases - Check Title AND Verify Login
 * - use Before Method and After Method 
 * - use Data Provider
 * - output using Reporter.log and Console output
 * - Assertions
 */

package tests;


import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SampleTest2 {
	
	// Driver is declared at class level so that all methods
	// (@BeforeMethod, @Test, @AfterMethod) can use the same driver instance.
	// Since it is used only within this class, we can make it private.
	// We will see a different approach when we build a framework.
	
	private WebDriver driver;
	
	@BeforeMethod
	 public void setup() throws IOException 
	 {
	
		 // Initialise the driver here ... DO NOT CREATE THE OBJECT , it is already created as a class object
		 driver = new FirefoxDriver();
		 				
		// Implicit Synchronisation
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
		// Maximise Browser
		driver.manage().window().maximize();
		
		// open page
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
						
	  }
	 
	 @AfterMethod
	 public void closeBrowser() throws InterruptedException 
	 {
		 driver.quit();
	 }

	 
	@Test (priority = 1)
	public void chkTitle()
	{
		String expectedTitle = "OrangeHRM";
		String actualTitle = "";
		
		actualTitle = driver.getTitle();
		
		// Checkpoint : Compare the Expected Title to the Actual Title 
		if (actualTitle.contentEquals(expectedTitle))
		{
			Reporter.log("Title Same .. Orange HRM Page Opened Correctly  ... Test Passed!", true);
		}
		else
		{
			Reporter.log("Title not same ...Orange HRM Page NOT Opened ..  Test Failed", true);	
			Assert.fail();
		}
	}
		
		
	// 'username' and 'password' will come from the @DataProvider
	// 'expected' - this is used for 'valid' or 'invalid' input , which will be used in our checkpoint / validation 
	// A better way is to use 'expected' as a boolean - true (for valid) or false (invalid)
	// we will do this in the next test. Here , have done this for simplicity
	
	// Also , instaed of printing in the console , we will use Reporter.log , which will print in the TestNG Report
	
	@Test(dataProvider = "loginData", priority = 2)
    public void verifyLogin(String uname, String pwd, String expected) 
    {

		// Login with uname and pwd 
		driver.findElement(By.name("username")).sendKeys(uname);
		driver.findElement(By.name("password")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		int foudDashboard = driver.findElements(By.xpath("//h6[text() = 'Dashboard']")).size();
		int foundLoginButton = driver.findElements(By.xpath("//button[@type='submit']")).size();
		int foundErrorMessage = driver.findElements(By.xpath("//p[text() = 'Invalid credentials']")).size();
		
		// Valid Credentials  : 'Dashboard' visible AND login button absent 
        if(expected.equals("valid"))
        {
        	if ((foudDashboard == 1) && (foundLoginButton == 0))
    			Reporter.log("Login is Successful with Valid Credentials - Test Passed", true);
    		else
    		{
    			Reporter.log("Login is NOT Successful with Valid Credentials - Test Failed", true);
    			Assert.fail();
    		}		
        }
        // Invalid Credentials - error visible AND login button still visible 
        else
        {
        	if ((foundErrorMessage == 1) && (foundLoginButton == 1))
    			Reporter.log("Login is NOT Successful with InValid Credentials - Test Passed", true);
    		else
    		{
    			Reporter.log("Test Failed", true);
    			Assert.fail();
    		}		
        }
	}
        
        
    @DataProvider(name = "loginData")
    public Object[][] getData() 
    {

    	return new Object[][] 
    	{
                {"Admin", "admin123", "valid"},
                {"Admin", "wrong", "invalid"},
                {"wrong", "admin123", "invalid"},
                {"wrong", "wrong", "invalid"}
        };
    }

}
