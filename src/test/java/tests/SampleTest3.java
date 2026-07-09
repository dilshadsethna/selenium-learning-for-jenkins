package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SampleTest3 {
	
	@Test(groups = "smoke")
	void test1()
	{
		System.out.println("This is from SampleTest3");
	}
	
	
	@BeforeClass
	void beforeClass()
	{
		System.out.println("This is Before Class - Sample Test 3 ");
	}
	
	@AfterClass
	void afterClass()
	{
		System.out.println("This is After Class - Sample Test 3 ");
	}
	
	@BeforeTest
	void beforeTest()
	{
		System.out.println("This is Before Test - Sample Test 3  ");
	}
	
	@AfterTest
	void afterTest()
	{
		System.out.println("This is After Test - Sample Test 3 ");
	}

}
