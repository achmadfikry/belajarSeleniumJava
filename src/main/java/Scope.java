import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class Scope {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        //Scenario 1: calculate links count
        System.out.println(driver.findElements(By.tagName("a")).size());

        //Scenario 2: calculate links count on footer
        //limiting Web Driver scope
        WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
        System.out.println(footerDriver.findElements(By.tagName("a")).size());

        //Scenario 3: calculate links count on first coloumn of footer
        WebElement coloumnDriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        System.out.println(coloumnDriver.findElements(By.tagName("a")).size());

        //Scenario 4: click on each link in the coloumn and check if the pages are opening
        for (int i = 0; i < coloumnDriver.findElements(By.tagName("a")).size(); i++) {
            String clickOnLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
//            coloumnDriver.findElements(By.tagName("a")).get(i).click();
            coloumnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab);
            Thread.sleep(2000);
        }

        Set<String> abc = driver.getWindowHandles();
        Iterator<String> iterator = abc.iterator();
        while (iterator.hasNext()) { //if the first window is preset
            driver.switchTo().window(iterator.next());
            System.out.println(driver.getTitle());
        }


    }
}
