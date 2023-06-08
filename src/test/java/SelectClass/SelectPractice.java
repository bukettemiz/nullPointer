package SelectClass;

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
import java.util.List;

public class SelectPractice {

    @Test
    public void practice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("file:///C:/Users/Laptop/Downloads/Techtorial%20(1).html");
        // validate UNITED STATES first option
        WebElement countryBox=driver.findElement(By.xpath("//select[@name='country']"));
        Select country=new Select(countryBox);
        String actualFirstOption=country.getFirstSelectedOption().getText().trim();
        String expectedFirstOption="UNITED STATES".trim();
        Assert.assertEquals(actualFirstOption,expectedFirstOption);
        // print all the options
        List<WebElement> AllCountrys=country.getOptions();// will give you all the countries
        int counter=0;
        for (WebElement cntry:AllCountrys){
            System.out.println(cntry.getText().trim());
            counter++;
        }
        System.out.println(counter);
        //chose your own country best and must visit country
        country.selectByVisibleText("TURKEY");
        Thread.sleep(2000);
        country.selectByValue("132");
        Thread.sleep(2000);
        country.selectByIndex(9);

    }
}
