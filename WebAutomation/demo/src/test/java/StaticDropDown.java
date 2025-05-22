import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropDown {
    public static void main(String[] args) {
        // Handling select dropdowns
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        WebElement staticDropDown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select dropdown = new Select(staticDropDown);
        dropdown.selectByIndex(3);
        System.out.println(dropdown.getFirstSelectedOption().getText());
        dropdown.selectByVisibleText("AED");
        System.out.println(dropdown.getFirstSelectedOption().getText());
        // using value attribute
        dropdown.selectByValue("INR");
        System.out.println(dropdown.getFirstSelectedOption().getText());
        dropdown.selectByContainsVisibleText("U");
        System.out.println(dropdown.getFirstSelectedOption().getText());
        driver.close();
    }
}
