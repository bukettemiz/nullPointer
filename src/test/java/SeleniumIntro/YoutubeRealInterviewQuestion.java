package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class YoutubeRealInterviewQuestion {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.youtube.com/");
        WebElement singer=driver.findElement(By.xpath("//input[@id='search']"));
        singer.sendKeys("Adele");
        singer.sendKeys(Keys.ENTER);//-->ENTER BUTTON or you can just put,and add to the singer name part("adele",Keys.ENTER)

       // WebElement search=driver.findElement(By.xpath("//button[@id='search-icon-legacy']"));
       // search.click();--> LONG WAY
        Thread.sleep(2000);//
        List<WebElement> song=driver.findElements(By.xpath("//a[@id='video-title']"));
        for (WebElement songss:song){
            songss.sendKeys(Keys.ARROW_DOWN);//scrolling down
            if (songss.getAttribute("aria-label").contains("Adele - Rolling in the Deep")){
                songss.click();
            }
        }
    }
}
