package selIntroduction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelIntroduction {
    public static void main(String[] args) {
        System.out.println("Hello World");

        //Invoking Browser
        //initiate web driver selenium
        //menggunakan chromedriver.exe
//        WebDriver driver = new ChromeDriver();
//        //menggunakan selenium manager
//        System.setProperty("webdriver.chrome.driver", "C:/Users/Lenovo/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");

        //firefox launch
        WebDriver driver = new FirefoxDriver();
//        System.setProperty("webdriver.gecko.driver", "C:/Users/Lenovo/Downloads/geckodriver-v0.35.0-win-aarch64/geckodriver.exe");

        driver.get("https://rahulshettyacademy.com/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.close();
//        driver.quit();
    }
}
