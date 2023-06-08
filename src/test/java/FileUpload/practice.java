package FileUpload;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class practice {
    @Test
    public void practice1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver=new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/upload");
        WebElement chooseFile=driver.findElement(By.cssSelector("#file-upload"));
        chooseFile.sendKeys("C:\\Users\\Laptop\\Desktop\\interview.pdf");
        Thread.sleep(3000);
        WebElement uploadButton= driver.findElement(By.cssSelector("#file-submit"));
        Thread.sleep(3000);
        //uploadButton.submit();
        uploadButton.click();
        WebElement validateFile= driver.findElement(By.cssSelector("#uploaded-files"));
        String actualName= BrowserUtils.getText(validateFile);
        String expectedName="interview.pdf";
        Assert.assertEquals(expectedName,actualName);
    }
}
