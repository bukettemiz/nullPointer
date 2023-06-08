package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumBasic {
    //FIRST STEP is setting up your automation

    public static void main(String[] args) {
        //FIRST STEP is setting up your automation
        WebDriverManager.chromedriver().setup();//Settingup to chrome
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        // Then create your driver to start automation
        WebDriver driver=new ChromeDriver(options);
        driver.get("https://www.amazon.com/");
        System.out.println(driver.getTitle());
        String actualTitle= driver.getTitle();
        String expectedTitle="Amazon.com Spends Less. Smile";
        if (actualTitle.equals(expectedTitle)) {

            System.out.println("passed");
        }else {
            System.out.println("failed");
        }
        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="https://www.amazon.com/";
        if (actualUrl.equals(expectedUrl)){
            System.out.println("url is passed");
        }else{
            System.out.println("failed URL");
        }
        driver.close();
    }
}
