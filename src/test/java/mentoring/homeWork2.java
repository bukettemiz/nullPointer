package mentoring;

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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class homeWork2 {
    @Test
    public void firstPart(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        String expectedTitle="Web Orders Login";
        String actualTitle=driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);

        WebElement userNameInput= driver.findElement(By.xpath("//input[@type='text']"));
        userNameInput.sendKeys("Tester");
        WebElement password= driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("test");
        WebElement Login= driver.findElement(By.xpath("//input[@class='button']"));
        Login.click();

        BrowserUtils.switchByTitle(driver,"Orders");
        String SecondActualTitile=driver.getTitle();
        String SecondExpectedTitle="Web Orders";
        Assert.assertEquals(SecondActualTitile,SecondExpectedTitle);
        WebElement header= driver.findElement(By.tagName("h2"));
        String expectedHeader="List of All Orders";
        String actualHeader=BrowserUtils.getText(header);
        Assert.assertEquals(expectedHeader,actualHeader);
    }
    @Test
    public void practice2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        WebElement userNameInput= driver.findElement(By.xpath("//input[@type='text']"));
        userNameInput.sendKeys("Tester");
        WebElement password= driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("test");
        WebElement Login= driver.findElement(By.xpath("//input[@class='button']"));
        Login.click();
        BrowserUtils.switchByTitle(driver,"Orders");
        WebElement ViewAllProducts= driver.findElement(By.linkText("View all products"));
        Thread.sleep(2000);
        ViewAllProducts.click();
        Thread.sleep(2000);

        WebElement selected= driver.findElement(By.xpath("//li[@class='selected']"));
        Assert.assertEquals(selected.getAttribute("class"), "selected");

        WebElement header=driver.findElement(By.tagName("h2"));
        String expectedHeader="List of Products";
        String actualHeader=BrowserUtils.getText(header);
        Assert.assertEquals(expectedHeader,actualHeader);
    }
    @Test
    public void practice3(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        WebElement userNameInput= driver.findElement(By.xpath("//input[@type='text']"));
        userNameInput.sendKeys("Tester");
        WebElement password= driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("test");
        WebElement Login= driver.findElement(By.xpath("//input[@class='button']"));
        Login.click();

        List<WebElement> allLinks=driver.findElements(By.xpath("//li//a"));

       List<String> expectedLinks= Arrays.asList("Default.aspx","Products.aspx","Process.aspx");

        for (int i=0;i<allLinks.size();i++){
            Assert.assertTrue(allLinks.get(i).getAttribute("href").contains(expectedLinks.get(i)));
        }
    }
    @Test
    public void practice4() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        WebElement userNameInput= driver.findElement(By.xpath("//input[@type='text']"));
        userNameInput.sendKeys("Tester");
        WebElement password= driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("test");
        WebElement Login= driver.findElement(By.xpath("//input[@class='button']"));
        Login.click();
        Thread.sleep(1000);
        WebElement order= driver.findElement(By.linkText("Order"));
        order.click();
        WebElement selections= driver.findElement(By.xpath("//select[@onchange='productsChanged()']"));
        BrowserUtils.selectBy(selections,"2","index");
        WebElement input= driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$txtQuantity']"));
        input.click();
        Thread.sleep(1000);
        input.clear();
        Thread.sleep(1000);
        input.sendKeys("5");


    }
}
