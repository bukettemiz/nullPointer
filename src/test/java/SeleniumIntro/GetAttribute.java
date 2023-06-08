package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class GetAttribute {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        WebElement makeAppoitment=driver.findElement(By.cssSelector("#btn-make-appointment"));
        makeAppoitment.click();
        WebElement username=driver.findElement(By.xpath("//input[@value='John Doe']"));
        username.click();
        System.out.println(username.getAttribute("value"));//if you want to just print the value of attribute use getAttribute method
        System.out.println(username.getAttribute("type"));
    }
}
