import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class BrokenLinks    {
    public static void main(String[] args) throws MalformedURLException, IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

        //broken url
        //step 1 : to get all  urls tied up to the links using selenium
        //step 2 : Java methods will call url's & gets you the status code
        // step 3 : if status code > 400 then that url is not working -> link which tied up to url is broken
        //a[href*="https://www.soapui.org/"]
        String url = driver.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute("href"); //step 1

        HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
        conn.setRequestMethod("HEAD");
        conn.connect();
        int respCodde = conn.getResponseCode();
        System.out.println(respCodde);
    }
}
