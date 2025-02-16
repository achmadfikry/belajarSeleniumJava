import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class base {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        String [] itemsNeeded = {"Cucumber", "Brocolli"};
        int j = 0;

        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        Thread.sleep(3000);
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
