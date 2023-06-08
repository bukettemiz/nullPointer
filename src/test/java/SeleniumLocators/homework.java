package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class homework {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");
        WebElement name=driver.findElement(By.id("userName"));
        name.sendKeys("John");
        WebElement email=driver.findElement(By.xpath("//input [@id='userEmail']"));
        email.sendKeys("john@gmail.com");
        WebElement address=driver.findElement(By.id("currentAddress"));
        address.sendKeys("1234 S Wisconsin Ave 60163");
        WebElement PermanentAddress=driver.findElement(By.id("permanentAddress"));
        PermanentAddress.sendKeys("1212 W Michigan Ave 60121");
        Thread.sleep(3000);
        WebElement submit=driver.findElement(By.xpath("//button[@id='submit']"));
        submit.click();
        if (name.isDisplayed()&& email.isDisplayed()&&address.isDisplayed()&&PermanentAddress.isDisplayed()){
            System.out.println("PASSED");
        }else {
            System.out.println("FAILED");
        }

    }
}
