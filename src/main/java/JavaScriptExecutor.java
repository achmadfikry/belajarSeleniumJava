import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class JavaScriptExecutor {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        //driver casting javascript executor, so driver will be aware that it can go ahead & execute Javascripts
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,500)");

        //cssSelector: driver.findElement By.cssSelector
        //DOM: document.querySelector(".class")
        Thread.sleep(3000);
        js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");

        //calculate sum of amount on last column
        //xpath: //td[4]
        //css: td:nth-child(4)
        List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
        int sum = 0;
        for (int i = 0; i < values.size(); i++) {
            System.out.println(Integer.parseInt(values.get(i).getText()));
            sum = sum + Integer.parseInt(values.get(i).getText());
            System.out.println(sum);
        }

        int total = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
        System.out.println(total);

        Assert.assertEquals(sum, total);
    }
}
