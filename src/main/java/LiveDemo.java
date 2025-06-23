import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.stream.Collectors;

public class LiveDemo {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //1. click on that column
        //2. capture all of these values into one list (original list)
        //3. foreach web element, let's do get text
        //4. sort in the list of step 3 -> sorted list
        //5. compare original list vs sorted list

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        //1
        driver.findElement(By.xpath("//tr//th[1]")).click();

        //2.
        List<WebElement> elementsList = driver.findElements(By.xpath("//tr//td[1]"));

        //3.
        List<String> originalList = elementsList.stream().map(s->s.getText()).collect(Collectors.toList());

        //4.
        List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());

        //5.
        Assert.assertTrue(originalList.equals(sortedList));



        //Get price of each vegetable
        //scan the name column with getText -> Beans -> print the price of the Beans
        //filter is used to apply some condition
        //so before doing map & get the price of veggie, we had another stream first to filter, so map only receive web element of oly Beans
        //so once it receive web element of Beans, it get the price of that web element only
        // and you have to send us the argument s->getPriceVeggie()
        List<String> price;
//        price = elementsList.stream().filter(s->s.getText().contains("Beans")).map(s->getPriceVeggie(s)).collect(Collectors.toList());
//        price.forEach(a->System.out.println(a));

        //Get price of each vegetable on the next page
        do{
            List<WebElement> rows = driver.findElements(By.xpath("//tr//td[1]"));
            price = rows.stream().filter(s->s.getText().contains("Rice")).map(s->getPriceVeggie(s)).collect(Collectors.toList());
            price.forEach(a->System.out.println(a));

            if (price.size() < 1){
                driver.findElement(By.cssSelector("[aria-label='Next']")).click();
            }

        }while(price.size() < 1);
    }

    private static String getPriceVeggie(WebElement s   ) {
        ////tr//td[1]/following-sibling::td[1]
        String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
        return priceValue;
    }
}
