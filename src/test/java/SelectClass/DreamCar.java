package SelectClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DreamCar {
    @Test
    public static void cars() throws InterruptedException {
         /*
NOTE: Please use browser utils for the select classes if it is needed or getText.
1-Navigate to the website
2-Choose the "New" from the New/used option
3-Choose "Lexus" for Make part
4-Choose "RX-350"
5-Validate the Price is selected "No max price"-->getFirstSelectedOption
6-Choose the distance 40 mil
7-Put your Zip code-->Before that Clear it.60056 element.clear()
8-Click Search Button
9-Validate the header "New Lexus RX 350 for sale"
10-Click Sort by and choose the Lowest Price
11-Validate the all titles has Lexus RX 350
     */
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.cars.com/");
        WebElement condition= driver.findElement(By.xpath("//select[@name='stock_type']"));
        BrowserUtils.selectBy(condition,"2","index");
        WebElement make=driver.findElement(By.xpath("//select[@id='makes']"));
        BrowserUtils.selectBy(make,"Lexus","text");
        WebElement model= driver.findElement(By.xpath("//select[@id='models']"));
        BrowserUtils.selectBy(model,"RX 350","text");
        WebElement price=driver.findElement(By.xpath("//select[@id='make-model-max-price']"));
        Select pr=new Select(price);
        String actualprice=BrowserUtils.getText(pr.getFirstSelectedOption());
        String expectedprice="No max price";
        Assert.assertEquals(actualprice,expectedprice);
        WebElement distance=driver.findElement(By.xpath("//select[@id='make-model-maximum-distance']"));
        BrowserUtils.selectBy(distance,"3","index");
        WebElement zipcode= driver.findElement(By.xpath("//input[@name='zip']"));
        zipcode.clear();
        zipcode.sendKeys("60056");
        WebElement search= driver.findElement(By.xpath("//button[@type='submit']"));
        search.click();

        WebElement header= driver.findElement(By.xpath("//h1[@class='sds-heading--1 sds-page-section__title']"));
        BrowserUtils.getText(header);
        Assert.assertEquals(BrowserUtils.getText(header),"New Lexus RX 350 for sale");

        WebElement sort=driver.findElement(By.cssSelector("#sort-dropdown"));
        Thread.sleep(2000);
        BrowserUtils.selectBy(sort,"Lowest price","text");
        Thread.sleep(2000);

        List<WebElement> texttt= driver.findElements(By.xpath("//h2[@class='title']"));

        for (WebElement bla:texttt){
            Assert.assertTrue(BrowserUtils.getText(bla).contains("Lexus RX 350"));
            System.out.println(BrowserUtils.getText(bla));
        }
        ///
        List<WebElement> PriceTags = driver.findElements(By.xpath("//span[@class='primary-price']"));
        List<Integer> actual=new ArrayList<>();
        List<Integer> expected=new ArrayList<>();
         for (WebElement prics:PriceTags){
             String priccess=prics.toString().replace("$","").replace(",","");
             actual.add(Integer.parseInt(priccess));
             expected.add(Integer.parseInt(priccess));
         }
        Collections.sort(expected);
         Assert.assertEquals(actual,expected);


    }
}