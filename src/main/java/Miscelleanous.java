import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Miscelleanous {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
//        driver.manage().deleteCookieNamed("sessionKey");

        //click on any link
        //login page- verify login url
        driver.get("https://www.google.com");

    }
}
