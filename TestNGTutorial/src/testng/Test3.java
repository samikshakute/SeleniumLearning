package testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test3 {
	@Parameters({"URL", "APIKey/username"})
	@Test
	public void webLoginCarLoan(String urlname, String key) {
		System.out.println("Web Login Car Loan");
		System.out.println(urlname);
		System.out.println(key);
	}
	
	@Test(groups= {"Smoke"})
	public void mobileLoginCarLoan() {
		System.out.println("Mobile Login Car Loan");
	}
	
	@BeforeClass
	public void beforeC() {
		System.out.println("Before executing any methods in the Test3 class");
	}
	
	@AfterClass
	public void afterC() {
		System.out.println("After executing all methods in the Test3 class");
	}
	
	@Test(enabled=false)
	public void mobileSigninCarLoan() {
		System.out.println("Mobile Sign In Car Loan");
	}
	
	@BeforeMethod
	public void before() {
		System.out.println("I will execute before every method in Test3 class");
	}
	
	@AfterMethod
	public void after() {
		System.out.println("I will execute after every method in Test3 class");
	}
	
	@Test(dataProvider="getData")
	public void mobileSignOutCarLoan(String username, String password) {
		System.out.println("Mobile Sign Out Car Loan");
		System.out.println(username);
		System.out.println(password);
	}
	
	@Test(dependsOnMethods= {"webLoginCarLoan"})
	public void APICarLoan() {
		System.out.println("Login API Car Loan");
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[3][2];
		data[0][0] = "firstusername";
		data[0][1] = "password";
		
		data[1][0] = "secondusername";
		data[1][1] = "secondpassword";
		
		data[2][0] = "thirdusername";
		data[2][1] = "thirdpassword";
		
		return data;
		
	}
}
