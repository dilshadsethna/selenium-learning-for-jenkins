package tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

// IMP Imports
import base.BaseTest;
import pages.LoginPage;


// Inherits the BaseTest Class , so the driver , @BeforeMethod , @AfterMethod will be inherited
public class LoginTest extends BaseTest {

    
         
        // Test 1 - do only this first
        @Test(priority = 1)
        public void checkLoginPageTitle() 
        {
        	// Create object of LoginPage.
        	// This calls the parameterized constructor of LoginPage and passes the driver created in BaseTest.
        	// LoginPage will use this SAME browser instance.
        	// We do not create a new WebDriver inside LoginPage.
        	
           	LoginPage lp = new LoginPage(driver);
        	   
           	String actualTitle = lp.getTitle();
            String expectedTitle = "OrangeHRM";
                  
            // Replace 'System.out.println' with reporter.log ; the 2nd parameter "true" , will print the message in the console As well as TestNG Report
            Reporter.log("Page Title : " + actualTitle, true);
            System.out.println("Git Changes - See in Console");
            
            // Assertion - if equal , test passes
            // so if actual title is "OrangeHRM" , test passes 
            // Compare this to the if-else we had written earlier - this is a better way to write an Assertion
            Assert.assertEquals(actualTitle, expectedTitle); 
        }
        
        
        // Test 2 - new test added , also add priority 
        // Tests for Valid Login - data from config.properties .. this is the simple method to do this 
        // The config file username and password will be used for all tests that require to login to the application with valid credentials 
                
        @Test(priority = 2, enabled = false)
        public void verifyValidLogin() 
        {
			// object of LoginPage
        	LoginPage lp = new LoginPage(driver);
			      
            // Perform login - use data from config file
        	String uname = p.getProperty("username");
        	String pwd = p.getProperty("password");
        	
            lp.login(uname, pwd); 

            // Validation - Dashboard visible AND Login button absent , we know that login is successful
            boolean status = lp.isDashboardDisplayed() && lp.isLoginButtonAbsent();

            Reporter.log("Valid Login Result : " + status, true);
            
            // Assertion - If status is true , test passes 
            Assert.assertTrue(status);
        } 
        
        
        // Test 3 - New Test Added 
        // This Test Verifies Valid AND Invalid Credentials
        // Data is from the @DataProvider
        @Test(dataProvider = "loginData", priority = 3, enabled = false)
        public void verifyLogin(String uname, String pwd, boolean expected) throws InterruptedException 
        {

        	// object of LoginPage
        	LoginPage lp = new LoginPage(driver);
        	
        	// Perform login - use data from Data Provider
            lp.login(uname, pwd);

            boolean actual;

            //  Valid Credentials  : 'Dashboard' visible AND login button absent -> actual =  TRUE
            if(expected == true)
            {
                actual = lp.isDashboardDisplayed() && lp.isLoginButtonAbsent();
            }
            // Invalid Credentials - error visible AND login button NOT absent (!lp.isLoginButtonAbsent()) -> actual = TRUE
            else
            {
                actual = lp.isErrorMessageDisplayed() && !lp.isLoginButtonAbsent();
            }
            

            // if actual is "true" , test passes , else fails 
            Reporter.log("Application Validation Result : " + actual, true);
            
            if(actual)
            {
               Reporter.log("Test Passed", true);
            }
            else
            {
                Reporter.log("Test Failed", true);
            }

            // Assertion : If validations are correct (actual = TRUE) , test passes
            Assert.assertTrue(actual);
            
            // This is ONLY for parallel execution
            // Thread.sleep(10000);
        }
        
        
        @DataProvider(name = "loginData")
        public Object[][] getData() 
        {

            return new Object[][] {
                {"Admin", "admin123", true},
                {"Admin", "wrong", false},
                {"wrong", "admin123", false},
                {"wrong", "wrong", false}
            };
        } 
        
    }
