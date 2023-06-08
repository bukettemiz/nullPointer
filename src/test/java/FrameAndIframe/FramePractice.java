package FrameAndIframe;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FramePractice {
    @Test
    public void practice(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/iframe");
        WebElement header= driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(header));
        driver.switchTo().frame("mce_0_ifr");//only id or name attribute value you can put here
        WebElement box= driver.findElement(By.xpath("//body[@id='tinymce']"));
        box.clear();
        box.sendKeys("I love Selenium");
        driver.switchTo().parentFrame();
        header= driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(header));
    }
    /*
TASK 1:
  1-Navigate to the website "https://skpatro.github.io/demo/iframes/"
  2-Click pavilion (new tab will be opened, consider switch window)
  3-Choose "Selenium-Java" from Selenium button (Action class is suggested)
  4-Validate the Header "Selenium-Java Tutorial – Basic to Advance"
  5-Print out(NO validation) Table of Content options on console(loop and getText())
  6-Wait for Second task
 */
    @Test
    public void practice1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://skpatro.github.io/demo/iframes/");
        WebElement pavalionClick= driver.findElement(By.linkText("Pavilion"));
        pavalionClick.click();

        BrowserUtils.switchByTitle(driver,"qavalidation");

        Actions action=new Actions(driver);
        WebElement TARGET= driver.findElement(By.linkText("Selenium"));
        action.moveToElement(TARGET).perform();
        WebElement seleniumPython= driver.findElement(By.linkText("Selenium-Python"));
        action.click(seleniumPython).perform();
        WebElement header= driver.findElement(By.tagName("h1"));
        String actualHeader=BrowserUtils.getText(header);
        String expectedHeader="Selenium-Python Tutorial";

        Assert.assertEquals(actualHeader,expectedHeader);
        List<WebElement> allLinks=driver.findElements(By.xpath("//p//a"));

        for(WebElement link:allLinks){
            System.out.println(BrowserUtils.getText(link));
        }
        /*
        Go back to main page
         */
        BrowserUtils.switchByTitle(driver,"iframes");//this is the part is specialized for
        // advertising when you need to reach out this part element you have to change the frame
        driver.switchTo().frame("Framename1");
        WebElement category1= driver.findElement(By.xpath("//a[.='Category1']"));
        category1.click();

        BrowserUtils.switchByTitle(driver,"Archives");

        WebElement headerCategory1= driver.findElement(By.xpath("//div[@class='page-title-head hgroup']"));
        String actualHeaderCategory1=BrowserUtils.getText(headerCategory1);
        String expectedHeaderCategory1="Category Archives: SeleniumTesting";
        Assert.assertEquals(actualHeaderCategory1,expectedHeaderCategory1);
        List<WebElement> allHeaders=driver.findElements(By.xpath("//h3[@class='entry-title']"));
        for (WebElement headers:allHeaders){
            System.out.println(BrowserUtils.getText(headers));
        }
        /*
        go back main
        click category3
        3-Validate the header "Category Archives: SoftwareTesting"
         */
        BrowserUtils.switchByTitle(driver,"iframes");
        driver.switchTo().frame("Frame1");// because this element at the different frame
        WebElement textt = driver.findElement(By.cssSelector("#frametext"));
        System.out.println(BrowserUtils.getText(textt));

        driver.switchTo().parentFrame();// you can not change the frames between them you have to go back parent frame

        driver.switchTo().frame("Frame2");
        WebElement click2 = driver.findElement(By.xpath("//a[.='Category3']"));
        click2.click();
        BrowserUtils.switchByTitle(driver,"SoftwareTesting Archives - qavalidation");

        WebElement category3 = driver.findElement(By.tagName("h1"));
        System.out.println(category3);



    }
}
