import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class CalendarTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");

        String monthNumber = "2";
        String date = "15";
        String year = "2025";
        String[] expectedList = {monthNumber, date, year};

        driver.findElement(By.cssSelector("a[class='cart-header-navlink'][href='#/offers']")).click();

        Set<String> windows = driver.getWindowHandles();
        Iterator<String> iterator = windows.iterator();
        String parentId = iterator.next();
        String childId = iterator.next();
        driver.switchTo().window(childId);

        driver.findElement(By.cssSelector("div[class='react-date-picker__inputGroup']")).click();
        driver.findElement(By.cssSelector("span[class*='react-calendar__navigation__label']")).click(); //click month
        driver.findElement(By.cssSelector("button[class*='react-calendar__navigation__label']")).click(); //click year
        driver.findElement(By.xpath("//button[text()='"+year+"']")).click();//select year
        //driver.findElement(By.cssSelector("button[class*='react-calendar__year-view__months__month']:nth-child('"+monthNumber+"')")).click();//select month
        driver.findElements(By.cssSelector("button[class*='react-calendar__year-view__months__month']")).get(Integer.parseInt(monthNumber)-1).click();//select month
        driver.findElement(By.xpath("//abbr[text()='"+date+"']")).click();//select date
        System.out.println(driver.findElement(By.cssSelector("div[class='react-date-picker__inputGroup']")).getText());
        List<WebElement> actualList = driver.findElements(By.cssSelector("input[class*='react-date-picker__inputGroup__input']"));
        for (int i = 0; i < actualList.size(); i++) {
            System.out.println(actualList.get(i).getDomAttribute("value"));
            Assert.assertEquals(actualList.get(i).getDomAttribute("value"), expectedList[i]);
        }
    }
}
