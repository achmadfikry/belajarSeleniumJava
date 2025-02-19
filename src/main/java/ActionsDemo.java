import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ActionsDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://www.amazon.com/");


        Actions actions = new Actions(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='nav-link-accountList']")));
        actions.moveToElement(driver.findElement(By.xpath("//a[@id='nav-link-accountList']"))).build().perform();
    }
}
