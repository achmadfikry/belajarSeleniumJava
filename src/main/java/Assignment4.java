import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class Assignment4 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com");

        //Scenario:
        //Click Multiple Windows
        //Click Here
        //Switch to new window
        //Catch New Window text
        //Print New Window on the output
        //switch to parent window
        //Print Opening a new window

        driver.findElement(By.cssSelector("a[href='/windows']")).click();
        driver.findElement(By.cssSelector("a[href='/windows/new']")).click();

        Set<String> windows = driver.getWindowHandles();
        Iterator<String> iterator = windows.iterator();
        String parentId = iterator.next();
        String childId = iterator.next();

        driver.switchTo().window(childId);
        String textChildWindow = driver.findElement(By.cssSelector("div[class='example'] h3")).getText();
        System.out.println(textChildWindow);

        driver.switchTo().window(parentId);
        String textParentWindow = driver.findElement(By.cssSelector("div[class='example'] h3")).getText();
        System.out.println(textParentWindow);



    }
}
