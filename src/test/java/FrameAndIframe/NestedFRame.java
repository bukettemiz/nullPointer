package FrameAndIframe;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

public class NestedFRame {
    @Test
    public void Practicee(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/nested_frames");
        //NAME or ID iframe
        driver.switchTo().frame("frame-top");
        //Webelement Iframe
        WebElement iframeLeft= driver.findElement(By.xpath("//frame[@name='frame-left']"));
        driver.switchTo().frame(iframeLeft);
        WebElement left= driver.findElement(By.xpath("//body[contains(text(),'LEFT')])"));
        System.out.println(BrowserUtils.getText(left));
        driver.switchTo().parentFrame();//top frame
        driver.switchTo().frame("frame-middle");//middle frame
        WebElement middle= driver.findElement(By.cssSelector("#content"));
        System.out.println(BrowserUtils.getText(middle));
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-right");//right frame
        WebElement right=driver.findElement(By.xpath("//body[contains(text(),'RIGHT')]"));
        System.out.println(BrowserUtils.getText(right));
        //can you print the botton
        //driver.switchTo().parentFrame();//top frame
       // driver.switchTo().parentFrame();//main html we did double because bottom was not child of top frame
        driver.switchTo().defaultContent();//this one always go to main html you dont need to go 2 times parent when you use this one
        driver.switchTo().frame("frame-botton");
        WebElement botton= driver.findElement(By.xpath("//body[contains(text(),'BOTTOM')]"));
        System.out.println(BrowserUtils.getText(botton));


    }
}
