import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class UploadDownload {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        driver.get("https://rahulshettyacademy.com/upload-download-test/index.html");

        //download
        driver.findElement(By.cssSelector("#downloadButton")).click();

        //Edit Excel


        //Upload
        WebElement upload = driver.findElement(By.cssSelector("input[type='file']"));
        upload.sendKeys("C:/Users/Lenovo/Downloads/download.xlsx");

        //Wait for success message to show up and wait for disappear


        //Verify updated excel data showing in the web table


    }
}
