package FileUpload;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Practice2 {
    @Test
    public void practice2(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver=new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://demo.guru99.com/test/upload/");
        WebElement chooseFile=driver.findElement(By.cssSelector(".upload_txt"));
        chooseFile.sendKeys("C:\\Users\\Laptop\\Desktop\\_final_round__interview");
        WebElement text= driver.findElement(By.xpath("//b[contains(text(),'Select file')]"));
        String actualText= BrowserUtils.getText(text);
        String expectedText="Select file to send(max 196.45 MB)";
        Assert.assertEquals(actualText,expectedText);
        WebElement checkBox= driver.findElement(By.cssSelector("#terms"));
        if (checkBox.isDisplayed()&&!checkBox.isSelected()&& checkBox.isEnabled()){
            checkBox.click();
        }
        WebElement submitButton= driver.findElement(By.tagName("button"));
        submitButton.click();
        WebElement validateMessage= driver.findElement(By.tagName("h3"));
        String actualMessage=BrowserUtils.getText(validateMessage);
        String expectedMessage="1 file\n"+
                "has been successfully uploaded.";
        Assert.assertEquals(actualMessage,expectedMessage);
    }
}
