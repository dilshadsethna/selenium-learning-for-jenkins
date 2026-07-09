package pages;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PIMPage {
	
	WebDriver driver;
	WebDriverWait wait;

    // Constructor
    public PIMPage(WebDriver driver)
    {
        this.driver = driver;
        
        // wait uses the same driver. So create the wait object in the constructor
        // - Constructor initializes it once
        // - All page methods can reuse it
        // - so each method does not need to create its own wait object
        // - Cleaner and more efficient framework design
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators
    
    By pimMenu = By.xpath("//span[text()='PIM']");
    By addEmployeeMenu = By.xpath("//a[text()='Add Employee']");
    By firstName = By.name("firstName");
    By middleName = By.name("middleName");
    By lastName = By.name("lastName");
    By saveBtn = By.xpath("//button[@type='submit']");
       
    // For Synchronisation 
    By loader = By.className("oxd-form-loader");
    
    // For Validation
    By employeeNameText = By.xpath("//div[@class = 'orangehrm-edit-employee-name']/h6");
    
    
    // Add these simple reusable method first 
    public void clickPIM()
    {
        driver.findElement(pimMenu).click();
    }
    
    public void clickAddEmployee()
    {
        driver.findElement(addEmployeeMenu).click();
    }
    
    /*
    These reusable methods also become useful if we want to just validate data in a single field
    WE want validate the firstname for valid / invalid data (numeric , special chars etc ?? )
    Valid name				Dilshad
	Invalid Numeric			12345
	Invalid Special chars	@@@
	Invalid Blank			""
     
    So we do enterFirstName(data); - And data can come from the @DataProvider method 
    */
    
    public void enterFirstName(String fname)
    {
        driver.findElement(firstName).sendKeys(fname);
    }
    
    public void enterMiddleName(String mname)
    {
        driver.findElement(middleName).sendKeys(mname);
    }
    
    public void enterLastName(String lname)
    {
        driver.findElement(lastName).sendKeys(lname);
    }
    
    public void clickSave()
    {
        // Add the syncronisation step here 
    	// Wait until loader disappears, and thyen click on the save button
    	// V IMP : framework methods should handle synchronization internally whenever possible.
    	
    	wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
    	driver.findElement(saveBtn).click();
    }
    
    // Now this is a Business Action Method 
    // We can reuse all our smaller methods here 
    
    public void addEmployee(String fname, String mname, String lname)
    {
        clickPIM();
        clickAddEmployee();
        enterFirstName(fname);
        enterMiddleName(mname);
        enterLastName(lname);
        clickSave();
    }
    
    // Validation Method
    public String getEmployeeName() throws InterruptedException
    {
    	// Wait till the name element is visible , and then sleep for some time , for the text to be loaded
		// Remember - Visible ≠ fully loaded with data	
        wait.until(ExpectedConditions.visibilityOfElementLocated(employeeNameText));
        Thread.sleep(3000);
        
        return driver.findElement(employeeNameText).getText();
    }
}
