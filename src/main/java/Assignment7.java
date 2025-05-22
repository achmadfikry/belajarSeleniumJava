import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Assignment7 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qaclickacademy.com/practice.php");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0,500)");
//        Integer countRow = (Integer) js.executeScript("document.querySelectorAll('.table-display tbody tr').length");
//        System.out.println("Number of rows in table: " + countRow);
//        Integer countColumn = (Integer) js.executeScript("document.querySelectorAll('.table-display tbody :first-child th').length");
//        System.out.println("Number of columns in table: " + countColumn);

        WebElement table = driver.findElement(By.className("table-display"));
        System.out.println(table.findElements(By.tagName("tr")).size()); // get count of row
        System.out.println(table.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th")).size()); // get count of column

        List<WebElement> secondrow=table.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));
        System.out.println(secondrow.get(0).getText());
        System.out.println(secondrow.get(1).getText());
        System.out.println(secondrow.get(2).getText());
    }
}
