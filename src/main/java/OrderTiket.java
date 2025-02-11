import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class OrderTiket {
    public static void main(String[] args) throws InterruptedException {
        List<WebElement> options;
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.manage().window().maximize();
        driver.get("https://www.tiket.com/");

        driver.findElement(By.cssSelector("a[aria-label='Pesawat']")).click();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        Assert.assertTrue(driver.getCurrentUrl().contains("/pesawat"), "Link is not valid");
        Assert.assertTrue(driver.getTitle().contains("Pesawat"), "Title is not valid");

        driver.findElement(By.cssSelector("div[data-testid='clickable-departure-input']")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("input[placeholder*='nama kota']")).sendKeys("Jakarta");

        System.out.println(driver.findElement(By.xpath("(//div[@class='AirportForm_airport__v1tCa'])[1]")).getText());

        options = driver.findElements(By.xpath("(//div[@class='AirportForm_airport__v1tCa'])"));
        for (WebElement option : options){
            if (option.getText().contains("Jakarta")) {
                option.click();
                break;
            }
        }

        driver.findElement(By.cssSelector("div[data-testid='clickable-arrival-input']")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("input[placeholder*='nama kota']")).sendKeys("Bajo");

        System.out.println(driver.findElement(By.xpath("(//div[@class='AirportForm_airport__v1tCa'])[1]")).getText());

        options = driver.findElements(By.xpath("(//div[@class='AirportForm_airport__v1tCa'])"));
        for (WebElement option : options){
            if (option.getText().contains("Bajo")) {
                option.click();
                break;
            }
        }

        System.out.println(driver.findElement(By.cssSelector("div[data-testid='clickable-departure-input']")).getText());
        System.out.println(driver.findElement(By.cssSelector("div[data-testid='clickable-arrival-input']")).getText());
        Assert.assertTrue(driver.findElement(By.cssSelector("div[data-testid='clickable-departure-input']")).getText().contains("Jakarta"), "Departure Input is not valid");
        Assert.assertTrue(driver.findElement(By.cssSelector("div[data-testid='clickable-arrival-input']")).getText().contains("Bajo"), "Arrival Input is not valid");

//        Thread.sleep(2000);
        driver.findElement(By.cssSelector("label[class*='SearchForm_round_trip']")).click();
        driver.findElement(By.xpath("//p[contains(@class,'SearchForm_departure_return') and contains (text(), 'Pergi')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("span[aria-label='24 Maret 2025 Senin']")).click();
//        driver.findElement(By.xpath("//p[contains(@class,'SearchForm_departure_return') and contains (text(), 'Pulang')]")).click();
        driver.findElement(By.cssSelector("span[aria-label='28 Maret 2025 Jumat']")).click();

        driver.findElement(By.cssSelector("div[class*='SearchForm_passenger_picker']")).click();
        Thread.sleep(1000);
        for(int j = 1; j < 4; j++){
            driver.findElement(By.xpath("//p[contains(text(),'Dewasa')]/following-sibling::div/button[2]")).click();
        }
        driver.findElement(By.xpath("//button/span[text()='Ekonomi']")).click();
        driver.findElement(By.cssSelector("button[class*='PassengerForm_btn_save']")).click();
        driver.findElement(By.cssSelector("button[class*='SearchForm_btn_submit']")).click();



    }
}
