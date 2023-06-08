package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class DriverFindElementsPractice {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/");
        List<WebElement> alllinks=driver.findElements(By.xpath("//li"));
        int i=0;
        for (WebElement LINK:alllinks){
            i++;
            System.out.println(LINK.getText());

        }
        System.out.println(i);
        int counter=0;
        for (WebElement linkis:alllinks){
            if (linkis.getText().length()>=12){
                System.out.println(linkis.getText().trim());
                counter++;
            }
        }
        System.out.println(counter);


    }
}
