package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/cucumber", tags = "@Regression", glue = "stepdefinitions", monochrome = true, plugin = {
        "html:target/cucumber.html" })
public class TestNGTestRunner extends AbstractTestNGCucumberTests {

}
