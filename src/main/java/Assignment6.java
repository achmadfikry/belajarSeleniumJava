import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment6 {
    public static void main(String[] args) {
        /*
        Scenario:
        1. Select one of any checkbox
        2. Grab the label / text of the checkbox
        3. Select dropdown based on label / text of the checkbox from step 2
        4. enter the step 2 grabbed label text in edit box
        5. click alert and then verify if text grabbed from step 2 is present in the pop up message
         */
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.cssSelector("#checkBoxOption1")).click();
        String checkbox = driver.findElement(By.cssSelector("label[for='bmw']")).getText();
        System.out.println(checkbox);
        WebElement statidDropdown = driver.findElement(By.cssSelector("#dropdown-class-example"));
        Select dropdown = new Select(statidDropdown);
        dropdown.selectByVisibleText(checkbox);
        driver.findElement(By.cssSelector("#name")).sendKeys(checkbox);
        driver.findElement(By.cssSelector("#alertbtn")).click();
        String alertText = driver.switchTo().alert().getText();
        System.out.println(alertText);
        Assert.assertEquals(alertText, "Hello Option1, share this practice page and share your knowledge");
//        driver.switchTo().alert().accept();

    }
}
