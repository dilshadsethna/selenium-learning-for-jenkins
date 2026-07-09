

package tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.PIMPage;


public class PIMTest extends BaseTest{
	
	@Test
	public void verifyAddEmployee() throws InterruptedException
	{
		// Objects of LoginPage and PIMPage 
		LoginPage lp = new LoginPage(driver);
		PIMPage pim = new PIMPage(driver);	
		
		// Call the login() method of LoginPage (Reusability), use values from config file
    	String uname = p.getProperty("username");
    	String pwd = p.getProperty("password");
    	
        lp.login(uname, pwd); 
        
        // We cud also just do this in one statement
		// lp.login(p.getProperty("username"), p.getProperty("password"));
		
		// Add Employee Data 
		String firstName = "Dilshad";
		String middleName = "Pankaj";
		String lastName = "Sethna";
		
		String expectedName = firstName + " " + lastName;
		
		// Call the addEmployee method of PIMPage - Do this part first
		pim.addEmployee(firstName, middleName, lastName);
		
		//------------- DO THIS PART LATER --------------------------
		
		// Assertion - Compare Expected and Actual Name , if Same , Test Passes
		String actualName = pim.getEmployeeName();
		
		System.out.println("Expected Name : " + expectedName);
		System.out.println("Actual Name : " + actualName);
		
		// Assertion : if actualName == expectedName , test will show as "PAss"
		// if test fails , assertion will show "Failed" , and test will end  , and 
	    Assert.assertEquals(actualName, expectedName);
	    Reporter.log("Add Employee Test PASSED", true);
		

		// Observation delay only
		Thread.sleep(5000);
		
		// This is ONLY for parallel execution
        Thread.sleep(10000);
	}

}
