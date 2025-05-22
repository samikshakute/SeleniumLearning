import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CalendarTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        String month = "1";
        String date = "22";
        String year = "2027";
        String[] expectedList = {month, date, year};
        driver.findElement(By.cssSelector(".react-date-picker__inputGroup")).click();
        driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
        driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
        driver.findElement(By.xpath("//button[text()='"+year+"' ]")).click();
        driver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(Integer.parseInt(month)-1).click();
        driver.findElement(By.xpath("//abbr[text()='"+date+"']")).click();
        List<WebElement> actuaList = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));

        for (int i = 0; i < actuaList.size(); i++) {
            System.out.println(actuaList.get(i).getDomAttribute("value"));
            Assert.assertEquals(actuaList.get(i).getDomAttribute("value"), expectedList[i]);
        }
        driver.quit();
    }
}
