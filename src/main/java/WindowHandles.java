import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class WindowHandles {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");

        driver.findElement(new By.ByClassName("blinkingText")).click();
        Set<String> windows = driver.getWindowHandles(); //[parentId, childId, subchildId], get all the widow IDs in the set data structure
        Iterator<String> iterator = windows.iterator(); // extract/iterate/access the values/element present in your set collection
        String parentId = iterator.next(); //get next index of Set collection, control will go to the zero index, parent index
        String childId = iterator.next(); //child index
//        String subchildId = iterator.next(); //subchildId index
        driver.switchTo().window(childId);

        //child window
        System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());


    }
}
