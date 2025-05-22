package testng;

import org.testng.ITestListener;
import org.testng.ITestResult;

// ITestListener interface is used to implement TestNG listeners.

public class Listeners implements ITestListener{
	public void onTestSuccess(ITestResult result) {
		System.out.println("I successfully executed Listeners pass code" + result.getName());
	}
	
	public void onTestFailure(ITestResult result) {
		System.out.println("I failed executing!" + result.getName());
	}
}
