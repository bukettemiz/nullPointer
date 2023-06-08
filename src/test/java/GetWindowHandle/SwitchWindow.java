package GetWindowHandle;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class SwitchWindow {
    @Test
    public void switchPractice() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/windows");
        WebElement clickHere = driver.findElement(By.xpath("//a[.='Click Here']"));
        clickHere.click();
        WebElement header = driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(header));//Open a new window-->instead of using .trim() we call BrowserUtils
        // Because we already create trim() in the BrowserUtils class
        System.out.println(driver.getWindowHandle()); // Main pageId-->The internet
        //C14E3D7B4AFE85565401D5F6DA1CFF02
        Set<String> allPagesId = driver.getWindowHandles();
        String mainPageId = driver.getWindowHandle();

        for (String id : allPagesId) {
            if (!id.equals(mainPageId)) {
                driver.switchTo().window(id);
                break;
            }
        }
        header = driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(header));
    }

    @Test
    public void practice() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
        WebElement button2 = driver.findElement(By.cssSelector("#newTabBtn"));
        JavascriptExecutor js = (JavascriptExecutor) driver;    //instead of this we call browserUtils because there is a shortcut there
        js.executeScript("arguments[0].scrollIntoView(true)", button2);
        button2.click();
        String mainPageId=driver.getWindowHandle();//this is my current driver page id
        Set<String> allPagesId=driver.getWindowHandles();// all pages id(include second page)
        for (String id:allPagesId){
            if (!id.equals(mainPageId)){
                driver.switchTo().window(id);
                break;
            }
        }
        String actualTitle = driver.getTitle().trim();
        String expectedTitle = "AlertsDemo - H Y R Tutorials";
        Assert.assertEquals(actualTitle, expectedTitle);

        WebElement header = driver.findElement(By.xpath("//h1[@class='post-title entry-title']"));
        String actualHeader=BrowserUtils.getText(header);
        String expectedHeader="AlertsDemo";
        Assert.assertEquals(actualHeader,expectedHeader);
        WebElement clickHereFirstOne= driver.findElement(By.cssSelector("#alertBox"));
        clickHereFirstOne.click();



    }
}
