import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators1 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        // waits for an element to be present in the DOM when it's not immediately
        // available.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys("samikshak");
        driver.findElement(By.name("inputPassword")).sendKeys("xyz123");
        driver.findElement(By.className("signInBtn")).click();

        // xpath and css selectors can be constructed based on existing html
        /*
         * CSS Selectors:
         * classname is available -> tagname.classname -> button.signInBtn
         * id is available -> tagname#id -> input#inputUsername
         * 
         * if no id or class name is present then there is a generic syntax:
         * tagname[attribute='value']
         * eg: input[placeholder='Username']
         */

        System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
        // linktext locator
        driver.findElement(By.linkText("Forgot your password?")).click();

        // xpath: //tagname[@attribute='value']
        // e.g: //input[@placeholder='Username']
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Sam");
        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("sam12@gmail.com");

        // if no unique attributes are available use indexing
        // syntax for xpath: //tagname[@attribute='value'][index]
        // syntax for css: tagname[attribute='value']:nth-child(index)
        // xpath and css index might differ due to some hidden attributes in the page
        driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
        driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("sam2002@gmail.com");

        // Traversing from parent to child:
        // using xpath: parentTagName/childTagName
        // using css: parentTagName childTagName
        driver.findElement(By.xpath("//form/input[3]")).sendKeys("9876543210");
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        System.out.println(driver.findElement(By.cssSelector("form p")).getText());

        driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();

        driver.findElement(By.cssSelector("#inputUsername")).sendKeys("Sam");
        // in certain scenarios the attribute values may change dynamically. for this
        // use regular expressions
        driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
        driver.findElement(By.id("chkboxOne")).click();
        driver.findElement(By.xpath("//button[contains(@class, 'submit')]")).click();

        driver.quit();
    }
}
