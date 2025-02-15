import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class e2e {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.spicejet.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        driver.findElement(By.xpath("//div[@data-testid='one-way-radio-button']")).click();
//        driver.findElement(By.xpath("//div[@data-testid='round-trip-radio-button']")).click();

        if(driver.findElement(By.xpath("//div[@data-testid='return-date-dropdown-label-test-id']")).getDomAttribute("style").contains("background-color")){
            System.out.println("it's disabled");
            Assert.assertTrue(true);
        }else{
            Assert.assertTrue(false);
        }

        driver.findElement(By.cssSelector("div[data-testid='to-testID-origin']")).click();
        driver.findElement(By.xpath("//div[text()='MAA']")).click();
        if(driver.findElement(By.xpath("//input[contains (@value,'MAA')]")).getDomAttribute("value").contains("MAA")){
            Assert.assertTrue(true);
        }else {
            Assert.assertTrue(false);
        }

        driver.findElement(By.xpath("//div[@data-testid='to-testID-destination']")).click();
        driver.findElement(By.xpath("//div[text()='BLR']")).click();
        if(driver.findElement(By.xpath("//input[contains (@value,'BLR')]")).getDomAttribute("value").contains("BLR")){
            Assert.assertTrue(true);
        }else {
            Assert.assertTrue(false);
        }

        driver.findElement(By.xpath("//div[@data-testid='undefined-calendar-day-27']")).click();
//        Thread.sleep(1000);
        if(driver.findElement(By.xpath("//div[@data-testid='departure-date-dropdown-label-test-id']")).getText().contains("27")){
            Assert.assertTrue(true);
        }else {
            Assert.assertTrue(false);
        }

        driver.findElement(By.xpath("//div[@data-testid='home-page-travellers']")).click();
//        driver.findElement(By.xpath("//div[@data-testid='Adult-testID-plus-one-cta']")).click();
        driver.findElement(By.xpath("//div[@data-testid='home-page-travellers-done-cta']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//div[@data-testid='home-page-travellers']")).getText(), "Passengers\n" +
                "1 Adult");

        driver.findElement(By.xpath("//div[normalize-space()='Currency']")).click();
        driver.findElement(By.xpath("(//div[text()='INR'])[2]")).click();

        driver.findElement(By.xpath("//div[text()='Students']")).click();
        driver.findElement(By.xpath("//div[@data-testid='home-page-flight-cta']")).click();


    }
}
