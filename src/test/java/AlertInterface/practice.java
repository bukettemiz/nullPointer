package AlertInterface;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class practice {
    @Test
    public void practice(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.hyrtutorials.com/p/alertsdemo.html");

        WebElement firstClick= driver.findElement(By.xpath("//button[@id='alertBox']"));
        firstClick.click();
        Alert alert=driver.switchTo().alert();
        alert.accept();
        WebElement message1= driver.findElement(By.xpath("//div[@id='output']"));
        String expectedMessage1="You selected alert popup";
        String actualMessage1= BrowserUtils.getText(message1);
        Assert.assertEquals(expectedMessage1,actualMessage1);

        WebElement secondClick= driver.findElement(By.xpath("//button[@id='confirmBox']"));
        secondClick.click();
        alert.dismiss();
        WebElement mesage2= driver.findElement(By.xpath("//div[@id='output']"));
        String actualM2= BrowserUtils.getText(mesage2);
        String expected2="You pressed Cancel in confirmation popup";
        Assert.assertEquals(expected2,actualM2);

        WebElement thirdClick=driver.findElement(By.xpath("//button[@id='promptBox']"));
        thirdClick.click();
        alert.sendKeys("Buket");
        alert.accept();
        WebElement message3= driver.findElement(By.cssSelector("#output"));
        String actualP=BrowserUtils.getText(message3);
        String expectedP="You entered text Buket in prompt popup";
        Assert.assertEquals(actualP,expectedP);
    }
    @Test
    public void pratikk() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://sweetalert.js.org/");

        WebElement previewButton= driver.findElement(By.xpath("//button[contains(@onclick,'alert')]"));
        previewButton.click();
        Thread.sleep(1000);
        Alert alert=driver.switchTo().alert();
        String expectedText="Oops, something went wrong!";
        String actualText=alert.getText().trim();
        Assert.assertEquals(expectedText,actualText);
        alert.accept();
        Thread.sleep(1000);

        WebElement SeconPreviewButton= driver.findElement(By.xpath("//button[contains(@onclick,'swal')]"));
        SeconPreviewButton.click();
        WebElement htmlAlert= driver.findElement(By.xpath("//div[@class='swal-text']"));
        String actualMessage=BrowserUtils.getText(htmlAlert);
        String expectedMessage="Something went wrong!";
        Assert.assertEquals(actualMessage,expectedMessage);
        WebElement ok= driver.findElement(By.xpath("//button[@class='swal-button swal-button--confirm']"));
        ok.click();
        driver.close();


    }
}
