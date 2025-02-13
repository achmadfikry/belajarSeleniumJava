import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class OrderTiketPesawat {
    public static void main(String[] args) throws InterruptedException {
        List<WebElement> options;
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://www.tiket.com/");

        //select airplan
        driver.findElement(By.cssSelector("a[aria-label='Pesawat']")).click();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        Assert.assertTrue(driver.getCurrentUrl().contains("/pesawat"));

        //select departure
        driver.findElement(By.cssSelector("div[data-testid='clickable-departure-input']")).click();
        //pop up
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("div[class^='SearchBox_placeholder'] input")).sendKeys("Jakarta");
        System.out.println(driver.findElement(By.xpath("(//div[@class='AirportForm_airport__v1tCa'])[1]")).getText());
        options = driver.findElements(By.xpath("(//div[@class='AirportForm_airport__v1tCa'])"));
        for (WebElement option : options){
            if (option.getText().contains("Jakarta")) {
                option.click();
                break;
            }
        }

        //select arrival
        driver.findElement(By.cssSelector("div[data-testid='clickable-arrival-input']")).click();
        Thread.sleep(1000);
        //popup
        driver.findElement(By.cssSelector("div[class^='SearchBox_placeholder'] input")).sendKeys("Yogya");
        System.out.println(driver.findElement(By.xpath("(//div[@class='AirportForm_airport__v1tCa'])[1]")).getText());
        options = driver.findElements(By.xpath("(//div[@class='AirportForm_airport__v1tCa'])"));
        for (WebElement option : options){
            if (option.getText().contains("Yogya")) {
                option.click();
                break;
            }
        }

        //assert selection departure & arrival
        System.out.println(driver.findElement(By.cssSelector("div[data-testid='clickable-departure-input']")).getText());
        System.out.println(driver.findElement(By.cssSelector("div[data-testid='clickable-arrival-input']")).getText());
        Assert.assertTrue(driver.findElement(By.cssSelector("div[data-testid='clickable-departure-input']")).getText().contains("Jakarta"));
        Assert.assertTrue(driver.findElement(By.cssSelector("div[data-testid='clickable-arrival-input']")).getText().contains("Yogya"));

        //select departure
        driver.findElement(By.xpath("(//p[contains(@class, 'SearchForm_departure_return')])[1]")).click();
        Thread.sleep(1000);
//        driver.findElement(By.cssSelector("span[aria-label='24 Maret 2025 Senin']")).click();
        driver.findElement(By.xpath("(//button[contains(@class,'Day_day_selected')])[1]")).click();

//        driver.findElement(By.xpath("(//p[contains(@class, 'SearchForm_departure_return')])[2]")).click();
//        driver.findElement(By.cssSelector("span[aria-label='28 Maret 2025 Jumat']")).click();
//        driver.findElement(By.xpath("(//button[contains(@class,'Day_day_selected')])[2]")).click();

        driver.findElement(By.cssSelector("button[class*='SearchForm_btn_submit']")).click();
        Thread.sleep(2000);
        Assert.assertTrue(driver.getCurrentUrl().contains("/pesawat/search?"));

        //select one of card in the list
        driver.findElement(By.xpath("(//div[contains(@data-testid, 'srp-flight-card')])[1]")).click();

        //review page
        Thread.sleep(2000);
        Assert.assertTrue(driver.getCurrentUrl().contains("/pesawat/review?"));
        driver.findElement(By.xpath("(//button[contains(@class, 'TypeCard_select_btn')])")).click();

        //cart page
        Thread.sleep(2000);
        Assert.assertTrue(driver.getCurrentUrl().contains("/cart/flight"));
        driver.findElement(By.xpath("(//span[ contains (@class,'Radio_icon__GF_Hw')])[1]")).click();
        driver.findElement(By.xpath("(//div[@class='styles_inline_input_wrapper__fW9I0'])[1]")).click();
        Thread.sleep(1000);
//        driver.findElement(By.xpath("(//input[contains(@id,'full-name')])[1]")).sendKeys("Achmad Fikry");

        driver.findElement(By.xpath("(//div[@class='styles_inline_input_wrapper__fW9I0'])[2]")).click();
        Thread.sleep(1000);
//        driver.findElement(By.xpath("//input[@id='phone-number']")) .sendKeys("089670755821");

        driver.findElement(By.xpath("(//div[@class='styles_inline_input_wrapper__fW9I0'])[3]")).click();
        Thread.sleep(1000);
//        driver.findElement(By.xpath("//input[@id='email-address']")).sendKeys("achmadfikryy@gmail.com");

        driver.findElement(By.xpath("(//div[@class='styles_inline_input_wrapper__fW9I0'])[4]")).click();
        Thread.sleep(1000);
//        driver.findElement(By.xpath("(//input[@id='full-name'])[2]")).sendKeys("Achmad Fikry");
        driver.findElement(By.xpath("(//span[ contains (@class,'Radio_icon__GF_Hw')])[4]")).click();

        driver.findElement(By.xpath("(//button[ contains (@class,'Button_button__tpkRA') and contains(@class,'Button_variant_primary')])[last()]")).click();

        driver.findElement(By.xpath("(//button[contains(@class, 'Button_button__tpkRA')])[last()]")).click();


    }

}
