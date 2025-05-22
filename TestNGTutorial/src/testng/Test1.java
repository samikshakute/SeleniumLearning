package testng;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
public class Test1 {
	@AfterTest
	public void last() {
		System.out.println("I will execute last");
	}
	
	@BeforeSuite
	public void bfSuite() {
		System.out.println("I am number one");
	}
	@Test
	public void demo() {
		System.out.println("hello");
	}
	@Parameters({"URL"})
	@Test
	public void secondTest(String urlname) {
		System.out.println("bye");
		System.out.println(urlname);
	}
}
