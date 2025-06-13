import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsDemo {
    ExtentReports extentReports;

    @BeforeTest
    public void config() {
        // ExtentReports, ExtentSparkReporter
        String path = System.getProperty("user.dir") + "/reports/index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Web Automation Results");
        reporter.config().setDocumentTitle("Test Results");

        extentReports = new ExtentReports();
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Tester", "Samiksha Kute");
    }

    @Test
    public void initialDemo() {

        ExtentTest test = extentReports.createTest("Initial Demo");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/");
        System.out.println(driver.getTitle());
        driver.close();
        test.fail("Report data not found!");
        extentReports.flush();
    }
}
