import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class base {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        Thread.sleep(3000);

        String [] itemsNeeded = {"Cucumber", "Brocolli", "Beetroot"};
        //kl pake static bisa langsung, tapi kl gak pake static harus intance kelas nya dulu
        //addItems(driver, itemsNeeded);
        base b = new base();
        b.addItems(driver, itemsNeeded);

        driver.findElement(By.cssSelector("img[alt='Cart']")).click();
        driver.findElement(By.xpath("//button[contains (text(), 'PROCEED TO CHECKOUT')]")).click();
        w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='promoCode']")));
        driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("rahulshettyacademy");
        driver.findElement(By.xpath("//button[@class='promoBtn']")).click();
        //explicit wait
        w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='promoInfo']")));
        Assert.assertTrue(driver.findElement(By.xpath("//span[@class='promoInfo']")).getText().contains("Code applied"));
    }

    public void addItems(WebDriver driver, String[] itemsNeeded) {
        int j = 0;
        List<WebElement> products = driver.findElements(By.cssSelector("h4[class='product-name']"));
//        for (WebElement product : products) {} //gak bisa pake ini karena harus pake index yang sama
        for (int i = 0; i < products.size(); i++) {
            //Brocolli - 1 Kg to Brocolli
            //format it to get actual vegetable name
            String[] name = products.get(i).getText().split("-");
            String formattedName = name[0].trim();

            //convert array itemsNeeded into array list for easy search (contains)
            //check whether name you extracted is present or not
            List itemsNeededList = Arrays.asList(itemsNeeded);
            System.out.println(name);
            System.out.println(formattedName);
            System.out.println(itemsNeededList);
            if(itemsNeededList.contains(formattedName)){
                j++;
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                if (j==itemsNeeded.length) {
                    break;
                }
            }
        }

    }
}
