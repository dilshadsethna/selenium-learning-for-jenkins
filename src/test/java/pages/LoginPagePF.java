	package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPagePF {
	 WebDriver driver;

	    // Page Factory Locators
	 	// @FindBy automatically creates the WebElement objects.
	 	// so we do not need a findElement() now in the methods , like in our previous LoginPage

	    @FindBy(name = "username")
	    WebElement username;

	    @FindBy(name = "password")
	    WebElement password;

	    @FindBy(xpath = "//button[@type='submit']")
	    WebElement loginBtn;
	   
	    // For Validation
	    
	    @FindBy(xpath = "//h6[text()='Dashboard']")
	    List<WebElement> dashboardText;
	   
	    
	    // Note : The drawback of Page Factory
	    // same locator sometimes needs multiple representations 
	    // here , one for the click() method (which requires a single element) , and one for validation (which requires a list)
	    // Hence modern developers prefer the By Locators (which we have seen before)
	    
	    // IMP : Page Factory simplifies element interaction, 
	    // but traditional By locators often provide more flexibility for validations and waits.
	   
	    @FindBy(xpath = "//button[@type='submit']")
	    List<WebElement> loginBtnList;
	    
	    // ---------------------------------------------------------------------------
	   
	    // Constructor
	    public LoginPagePF(WebDriver driver)
	    {
	        this.driver = driver;

	        // Initialize Page Factory elements - V IMP
	        // Initialize all @FindBy elements in this class.
	        // This line is the HEART of Page Factory
	        PageFactory.initElements(driver, this);
	    }

	    // Reusable Methods
	    
	    // Enter Username
	    public void enterUsername(String uname) 
	    {
	    	// This is how we did it previously , using the By Locator - username was the locator
	    	// driver.findElement(username).sendKeys(uname);
	    	
	    	// With Page Factory @Find , username is now a WebElement , so no need to do a findElement now
	    	username.sendKeys(uname);
	    }
	    
	    // Enter Password
	    public void enterPassword(String pwd) 
	    {
	        password.sendKeys(pwd);
	    }

	    // Click on Login Button
	    public void clickLogin() 
	    {
	        loginBtn.click();
	    }
	    
	    // Business Method
	    public void login(String uname, String pwd)
	    {
	       	enterUsername(uname);
	    	enterPassword(pwd);
	    	clickLogin();
	    }
	    
	    // For Validations -----
	    
	    // Check if Dashboard is Displayed
	    public boolean isDashboardDisplayed()
	    {
	        int found = dashboardText.size();

	        if(found == 1)
	            return true;
	        else
	            return false;
	    }
	    
	    // Check if Login Button is Absent
	    public boolean isLoginButtonAbsent()
	    {
	        int found = loginBtnList.size();

	        if(found == 0)
	            return true;
	        else
	            return false;
	    }

}
