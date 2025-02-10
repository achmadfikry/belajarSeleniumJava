import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class UpdatedDropdown {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
//        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.get("https://www.spicejet.com/");

        System.out.println(driver.findElement(By.xpath("//div[contains(text(),'Adult')]")).getText());
        driver.findElement(By.xpath("//div[normalize-space()='Passengers']")).click();
        Thread.sleep(2000);
        int i = 1;
//        while(i < 5){ //4 times
//            driver.findElement(By.xpath("(//*[name()='path'][@fill-rule='nonzero'])[10]")).click();
//            i++;
//        }
        for(int j = 1; j < 5; j++){
            driver.findElement(By.xpath("(//*[name()='path'][@fill-rule='nonzero'])[10]")).click();
        }
        driver.findElement(By.cssSelector("div[data-testid='home-page-travellers-done-cta']")).click();

        System.out.println(driver.findElement(By.xpath("//div[contains(text(),'Adult')]")).getText());
    }
}
