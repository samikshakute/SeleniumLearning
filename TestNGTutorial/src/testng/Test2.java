package testng;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test2 {
	@Test(groups= {"Smoke"})
	public void ploan() {
		System.out.println("good");
	}
	
	@AfterSuite
	public void afSuite() {
		System.out.println("I am number one from last");
	}
	
	@BeforeTest
	public void prerequisite() {
		System.out.println("This will execute first");
	}
}
