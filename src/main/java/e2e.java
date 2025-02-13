import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class e2e {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.spicejet.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        driver.findElement(By.xpath("//div[@data-testid='one-way-radio-button']")).click();
//        driver.findElement(By.xpath("").click();

        driver.findElement(By.cssSelector("div[data-testid='to-testID-origin']")).click();
        driver.findElement(By.xpath("//div[text()='MAA']")).click();

        driver.findElement(By.xpath("//div[@data-testid='to-testID-destination']")).click();
        driver.findElement(By.xpath("//div[text()='BLR']")).click();

        driver.findElement(By.xpath("//div[@data-testid='undefined-calendar-day-27']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//div[contains(@class,'css-1dbjc4n r-1awozwy r-1loqt21')])[8]")).click();
        driver.findElement(By.xpath("//div[@data-testid='home-page-flight-cta']")).click();


    }
}
