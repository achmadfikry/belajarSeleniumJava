import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class Assignment3 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
        driver.findElement(By.id("password")).sendKeys("learning");
        driver.findElement(By.xpath("//label[@class='customradio'][2]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
        driver.findElement(By.id("okayBtn")).click();

        WebElement staticDrodown = driver.findElement(By.xpath("//select[@class='form-control']"));
        Select dropdown = new Select(staticDrodown);
        dropdown.selectByValue("consult");
        driver.findElement(By.xpath("//input[@id='terms']")).click();
        driver.findElement(By.xpath("//input[@id='signInBtn']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='my-4']")));

        List<WebElement> buttonAdd = driver.findElements(By.xpath("//button[@class='btn btn-info']"));
        for (int i = 1; i <= buttonAdd.size(); i++) {
//            buttonAdd.get(i).click();
            driver.findElement(By.xpath("(//button[@class='btn btn-info'])"+"["+i+"]")).click();
        }
//        driver.findElement(By.partialLinkText("Checkout")).click();
        driver.findElement(By.xpath("//a[contains(@class,'nav-link btn btn-primary')]")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//h3[text()='Total']")).isDisplayed());
    }
}
