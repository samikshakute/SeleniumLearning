package testng;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test4 {
	@Parameters({"URL"})
	@Test
	public void webLoginHomeLoan(String urlName) {
		System.out.println("Web Login Home Loan");
		System.out.println(urlName);
	}
	
	@Test(groups= {"Smoke"})
	public void mobileLoginHomeLoan() {
		System.out.println("Mobile Login Home Loan");
	}
	
	@Test
	public void loginAPIHomeLoan() {
		System.out.println("Login API Home Loan");
	}
}
