import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class base {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");

        List<WebElement> products = driver.findElements(By.cssSelector("h4[class='product-name']"));
//        for (WebElement product : products) {} //gak bisa pake ini karena harus pake index yang sama
        for (int i = 0; i < products.size(); i++) {
            String name = products.get(i).getText();
            System.out.println(name);
            if(name.contains("Cucumber")){
                driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
                break;
            }
        }
    }
}
