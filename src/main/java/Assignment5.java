import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Assignment5 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/");
        //click Nested Frame
        //print MIDDLE on output
        driver.findElement(By.cssSelector("a[href='/nested_frames']")).click();
        System.out.println(driver.findElements(By.tagName("frame")).size());
        driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-top']")));
        driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-middle']")));
        System.out.println(driver.findElement(By.xpath("//div[@id='content']")).getText());
    }
}
