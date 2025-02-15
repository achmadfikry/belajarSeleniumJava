import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment2 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        driver.findElement(By.name("name")).sendKeys("Rahul");
        driver.findElement(By.name("email")).sendKeys("rahulshetty@yopmail.com");
        driver.findElement(By.id("exampleInputPassword1")).sendKeys("TestPassword");
        driver.findElement(By.id("exampleCheck1")).click();

//        (//select[@id='exampleFormControlSelect1'])
        WebElement staticDropdown = driver.findElement(By.id("exampleFormControlSelect1"));
        Select dropdown = new Select(staticDropdown);
        dropdown.selectByVisibleText("Male");

        driver.findElement(By.cssSelector("input[id='inlineRadio1']")).click();
        driver.findElement(By.name("bday")).sendKeys("12/12/2012");
        driver.findElement(By.cssSelector("input[value='Submit']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert-success')]")).getText().contains("Success!"));
    }
}
