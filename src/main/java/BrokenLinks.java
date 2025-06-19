import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class BrokenLinks    {
    public static void main(String[] args) throws MalformedURLException, IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

        List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
        SoftAssert softAssert = new SoftAssert();


        for (WebElement link : links) {
//            link.getAttribute("href");
            //broken url
            //step 1 : to get all  urls tied up to the links using selenium
            //step 2 : Java methods will call url's & gets you the status code
            // step 3 : if status code > 400 then that url is not working -> link which tied up to url is broken
            //a[href*="https://www.soapui.org/"]
            String url = link.getAttribute("href"); //step 1

            HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
            conn.setRequestMethod("HEAD");
            conn.connect();
            int respCode = conn.getResponseCode();
            System.out.println(respCode);

//            if (respCode > 400) {
//                System.out.println("The link with the text " + link.getText() + " is broken with code " + respCode);
//                Assert.assertTrue(false);
//            }
            softAssert.assertTrue(respCode<400, "The link with the text " + link.getText() + " is broken with code " + respCode);
        }

    }
}
