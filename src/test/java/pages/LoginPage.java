	package pages;

/*  
 	POM : 
 	Page Class -  represents ONE page of the application
   	Locators + actions are inside page class
	Test class will NOT use findElement anymore
*/


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    // Parameterized Constructor  : VERY IMP - 
    // We pass driver from test → page
    
    // The driver is created in BaseTest (driver = new FireFoxDriver()) and passed to this page class.
    // This allows LoginPage to use the SAME browser instance that the test is using.
    // We must not create another WebDriver object here, otherwise a new browser window would be opened.
    
    public LoginPage(WebDriver driver) 
    {
    	// 'driver' on the right = constructor parameter
    	// 'this.driver' on the left = class-level variable
    	this.driver = driver;
    }

    // Locators : V IMP : Why are we creating the locators here ?
    // - Locators are centralized for easier maintenance. In-case a locator changes , we only need to change it here , not inside any method
    // - Locator is visible at top
    // - Reusable within the class (any method can use it)
    // - e.g. WE may want to write a new methods like getUsernameText() or clearUsername()  - which would use the same locators
    // Helps in maintenance, readability, scaling - Industry standard in POM
    
    // By.name("username") - 
    // - returns an object of type By
    // - By is a Selenium class used to locate elements
    
    
    By username = By.name("username");
    By password = By.name("password");
    By loginBtn = By.xpath("//button[@type='submit']");
    
    // ---------------------------------------------------------------------------
    // this is added later - to verify the login functionality
    By dashboardText = By.xpath("//h6[text()='Dashboard']");
    By errorMsg = By.xpath("//p[text()='Invalid credentials']"); 
    // ------------------------------------------------------------------
        
    // Actions (methods)
    // Write only the first 5 methods as of now ... 
    
    public void openApplication(String url) 
    {
        driver.get(url);
    }

    // Enter Username
    public void enterUsername(String uname) 
    {
    	// We would do this normally .. right ?
    	//driver.findElement(By.name("username")).sendKeys(uname);
    	
        // Instead of doing the above , use the locator object created first
    	// Selenium uses that By object (that we created above) to locate the element
    	
    	driver.findElement(username).sendKeys(uname);
    }
    
    // Get Username
    public String getUsername()
    {
    	String str = driver.findElement(username).getText();
    	return str;
    }

    // Enter Password
    public void enterPassword(String pwd) 
    {
        driver.findElement(password).sendKeys(pwd);
    }

    // Click on Login Button
    public void clickLogin() 
    {
        driver.findElement(loginBtn).click();
    }

    // Get Page Title
    public String getTitle() 
    {
        return driver.getTitle();
    }
    
    // ------------------------------------------------------------------------------------------
    
    // This are new methods - For Login Validations
    
    // Login to application - take username and Password as parameters 
    public void login(String uname, String pwd) 
    {
        
        // This is what we wud have normally done : 
        
        // driver.findElement(username).sendKeys(uname);
        // driver.findElement(password).sendKeys(pwd);
        // driver.findElement(loginBtn).click(); 
    	
        
        // Do this later : Instead of the above , we can use the small methods
    	enterUsername(uname);
    	enterPassword(pwd);
    	clickLogin(); 
    }
    
    // Validation methods for Login Functionality
    
    // Check if Dashboard is Displayed
    public boolean isDashboardDisplayed()
    {
        int found = driver.findElements(dashboardText).size();

        if(found == 1)
            return true;
        else
            return false;
    }
    
    
    // Check if Login Button is Absent
    public boolean isLoginButtonAbsent()
    {
        int found = driver.findElements(loginBtn).size();

        if(found == 0)
            return true;
        else
            return false;
    }
    
    // Check if Error Message is Displayed
    public boolean isErrorMessageDisplayed()
    {
        int found = driver.findElements(errorMsg).size();

        if(found == 1)
            return true;
        else
            return false;
    }
    
    // -------------------------------------------------------------------------------------------
    
}