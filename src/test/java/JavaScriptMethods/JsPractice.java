package JavaScriptMethods;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class JsPractice {
    @Test
    public void prctice1(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://codefish.io/");
        WebElement yesRdioButton= driver.findElement(By.cssSelector("#yesRadio"));
       // yesRdioButton.click(); when this one is not working try action
      //  Actions action=new Actions(driver);
       // action.click(yesRdioButton).perform(); when action also is not working try javascript
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].click",yesRdioButton);

        WebElement mesage=driver.findElement(By.cssSelector(".mt-3"));
        String actualMesage= BrowserUtils.getText(mesage);
        String expectedMesage="";
        Assert.assertEquals(actualMesage,expectedMesage);
        WebElement noRadioButton= driver.findElement(By.cssSelector("#noRadio"));
        Assert.assertFalse(noRadioButton.isEnabled());

    }
    @Test
    public void test2(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.techtorialacademy.com/");
        WebElement copyRight= driver.findElement(By.xpath("//div[contains(text(),'Copyright')]"));
        BrowserUtils.scrollWithJS(driver,copyRight);
        String actualText=BrowserUtils.getText(copyRight);
        String expectedText="Copy 2023";
        Assert.assertEquals(actualText,expectedText);
        WebElement applyNow= driver.findElement(By.linkText("Apply Now"));
        BrowserUtils.scrollWithJS(driver,applyNow);
        String actualTitle = BrowserUtils.getTitleWithJS(driver);
        String expectedTitle="Apply Now";
        Assert.assertEquals(actualTitle,expectedTitle);

        List<WebElement> allInformation = driver.findElements(By.xpath("//h3[@data-element-id='heading3Normal']"));
        List<String> expectedInformation = Arrays.asList("info@techtorialacademy.com","+ 1 (224) 570 91 91","Chicago & Houston");

        for(int i=0; i<allInformation.size();i++){
            Assert.assertEquals(BrowserUtils.getText(allInformation.get(i)),expectedInformation.get(i));

        }



    }
}
