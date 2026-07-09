package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPagePF;

public class LoginTestPF extends BaseTest {
	
	@Test
	public void verifyValidLogin() 
    {
		// object of LoginPageFactory - Only this is  Changed in this test as compared to the LoginTest
    	LoginPagePF lp = new LoginPagePF(driver);
		      
    	// Perform login - use data from config file
    	String uname = p.getProperty("username");
    	String pwd = p.getProperty("password");
    	
        lp.login(uname, pwd); 
        
 
        // Validation - if login button is not on the page and Dashborad is displayed, we know that login is successful
        boolean status = (lp.isLoginButtonAbsent() && lp.isDashboardDisplayed());

        System.out.println("Valid Login Result : " + status);

        // Assertion - If status is true , test passes 
        Assert.assertTrue(status);
    } 
}
