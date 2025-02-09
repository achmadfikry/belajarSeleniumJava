import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowActivity {
    public static void main(String[] args) {
        //System.setProperty("webdriver.chrome.driver", "C:/Users/Lenovo/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.google.com"); //selenium will pause until this page is fully loaded
        driver.navigate().to("https://www.rahulshettyacademy.com"); //selenium will pause until this page is fully loaded
        driver.navigate().back();
        driver.navigate().forward();
    }
}
