import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicDropdown {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
        driver.get("https://www.spicejet.com/");

//        div[data-testid='to-testID-origin'] //div[text()='MAA'] //div[text()='BLR']
//        span[contains(@class, "AirportForm_airport_code") and contains(text(), "JKTC")]
        driver.findElement(By.cssSelector("div[data-testid='to-testID-origin']")).click();
        driver.findElement(By.xpath("//div[text()='MAA']")).click();

        driver.findElement(By.xpath("//div[@data-testid='to-testID-destination']")).click();
        driver.findElement(By.xpath("//div[text()='BLR']")).click();

    }
}
