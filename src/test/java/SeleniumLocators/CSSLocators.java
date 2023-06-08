package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CSSLocators {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(chromeOptions);
        driver.get("https://www.etsy.com/");
        WebElement search=driver.findElement(By.cssSelector("#global-enhancements-search-query"));
        search.sendKeys("watch");
        WebElement searching=driver.findElement(By.cssSelector(".global-enhancements-search-input-btn-group__btn"));
        searching.click();
        System.out.println(driver.getCurrentUrl());

    }
}
