import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class SeleniumTest {
    @Test
    public void homePageCheck() throws MalformedURLException, URISyntaxException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        // capabilities.setPlatform(Platform.WINDOWS);

        WebDriver driver = new RemoteWebDriver(new URI("http://192.168.1.149:4444").toURL(), capabilities);
        driver.get("https://www.selenium.dev/");
        System.out.println(driver.getTitle());
        driver.close();
    }
}
