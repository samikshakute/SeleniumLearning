
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Locators2 {
    public static void main(String[] args) throws InterruptedException {
        String name = "Sam";
        WebDriver driver = new ChromeDriver();

        // waits for an element to be present in the DOM when it's not immediately
        // available.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        String password = getPassword(driver);
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys(name);
        driver.findElement(By.name("inputPassword")).sendKeys(password);
        driver.findElement(By.className("signInBtn")).click();

        // in changing state of an application if an element is not detected then use
        // Thread.sleep for the element to get in stable state
        Thread.sleep(1000);

        // if there is only one tagname in a page we can use the tagname locator but if
        // there are multiple tag name the first occurence will be retreived
        System.out.println(driver.findElement(By.tagName("p")).getText());

        Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
        driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText();
        Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),
                "Hello " + name + ",");

        // xpath can be used to find text in a page
        driver.findElement(By.xpath("//button[text()='Log Out']")).click();
        // another way if text is unique: //*[text()='Log Out']

        driver.quit();
    }

    public static String getPassword(WebDriver driver) throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(1000);
        driver.findElement(By.className("reset-pwd-btn")).click();
        String resetPwdString = driver.findElement(By.className("infoMsg")).getText();
        String[] password = resetPwdString.split("'");
        String paString = password[1];
        return paString;
    }
}
