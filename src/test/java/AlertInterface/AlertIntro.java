package AlertInterface;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertIntro {
    @Test
    public void AlertAccepAndGetText(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement clickJSalert= driver.findElement(By.xpath("//button[contains(@onclick,'jsAlert')]"));
        clickJSalert.click();
        Alert alert=driver.switchTo().alert();
        String actualText= alert.getText().trim();//this one can not be inspectable because come from pop-up
        String expectedText="I am a JS Alert";
        Assert.assertEquals(actualText,expectedText);
        alert.accept();//will click ok button otherwise you will get unhandled alert exception
        WebElement message= driver.findElement(By.cssSelector("#result"));
        String actualMessage= BrowserUtils.getText(message);
        String expectedMessage="You successfully clicked an alert";
        Assert.assertEquals(actualMessage,expectedMessage);
    }
    @Test
    public void AlertDismiss(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement jfConfirm= driver.findElement(By.xpath( "//button(contains@onclick,'jsConfirm')"));
        jfConfirm.click();
        Alert alert=driver.switchTo().alert();
        alert.dismiss();
        WebElement Resultmesage= driver.findElement(By.xpath("//p[contains(@id,'resul')"));
        String actualMesage=BrowserUtils.getText(Resultmesage);
        String expectedMasage="You clicked: Cancel";
        Assert.assertEquals(actualMesage,expectedMasage);
    }
    @Test
    public  void AlertSendKeys() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement JsPrompt= driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        JsPrompt.click();
        Thread.sleep(2000);
        Alert alert=driver.switchTo().alert();
        Thread.sleep(2000);
        alert.sendKeys("Homework is Important");
        Thread.sleep(2000);
        alert.accept();
        WebElement mesage= driver.findElement(By.cssSelector("#result"));
        String actualMesage=BrowserUtils.getText(mesage);
        String expectedMesage="You entered: Homework is Important";
        Assert.assertEquals(actualMesage,expectedMesage);
    }
}
