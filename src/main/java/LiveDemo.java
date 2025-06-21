import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.stream.Collectors;

public class LiveDemo {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //1. click on that column
        //2. capture all of these values into one list (original list)
        //3. foreach web element, let's do get text
        //4. sort in the list of step 3 -> sorted list
        //5. compare original list vs sorted list

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        //1
        driver.findElement(By.xpath("//tr//th[1]")).click();

        //2.
        List<WebElement> elementsList = driver.findElements(By.xpath("//tr//td[1]"));

        //3.
        List<String> originalList = elementsList.stream().map(s->s.getText()).collect(Collectors.toList());

        //4.
        List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());

        //5.
        Assert.assertTrue(originalList.equals(sortedList));



    }
}
