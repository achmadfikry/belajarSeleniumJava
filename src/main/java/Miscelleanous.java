import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class Miscelleanous {
    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
//        driver.manage().deleteCookieNamed("sessionKey");

        //click on any link
        //login page- verify login url
        driver.get("https://www.google.com");


        //delete screenshot & kill the process which is running in the background
        //convert webdriver object into screenshot object
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); //casting driver object to TakesScreenshot object
        FileUtils.copyFile(src, new File("/Users/telkomdev/Redis/Fikry/screenshot.png")); //rewrite source object to our local machine
    }
}
