package TESTNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class OpenChartTestNGpractice {
    @Test
    public void successfullogin() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.opencart.com/admin/");
        WebElement userName = driver.findElement(By.cssSelector("#input-username"));
        userName.sendKeys("demo");
        WebElement password = driver.findElement(By.cssSelector("#input-password"));
        password.sendKeys("demo");
        WebElement Login = driver.findElement(By.tagName("button"));
        Login.click();
        Thread.sleep(3000);
        String actualTitle = driver.getTitle();
        String expectedTitle = "Dashboard";
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void negativelogin() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.opencart.com/admin/");
        WebElement userName = driver.findElement(By.cssSelector("#input-username"));
        userName.sendKeys("demo");
        WebElement password = driver.findElement(By.cssSelector("#input-password"));
        password.sendKeys("DEMO");
        WebElement Login = driver.findElement(By.tagName("button"));
        Login.click();
        Thread.sleep(3000);
        WebElement errosMesage = driver.findElement(By.cssSelector("#alert"));
        String actualMesage = errosMesage.getText().trim();
        String expectedMesage = "No match for Username and/or Password.";
        Assert.assertEquals(actualMesage, expectedMesage);

    }

    @Test
    public void productclick() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.opencart.com/admin/");
        WebElement userName = driver.findElement(By.cssSelector("#input-username"));
        userName.sendKeys("demo");
        WebElement password = driver.findElement(By.cssSelector("#input-password"));
        password.sendKeys("demo");
        WebElement Login = driver.findElement(By.tagName("button"));
        Login.click();
        Thread.sleep(2000);
        WebElement xbutton = driver.findElement(By.cssSelector(".btn-close"));
        xbutton.click();
        WebElement catalog = driver.findElement(By.xpath("//a[contains(text(),'Catalog')]"));
        catalog.click();
        Thread.sleep(2000);
        WebElement productButton = driver.findElement(By.xpath("//a[.='Products']"));
        Assert.assertTrue(productButton.isDisplayed());
        Assert.assertTrue(productButton.isEnabled());
    }

    @Test
    public void ValidateBoxesFunctionality() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.opencart.com/admin/");
        WebElement userName = driver.findElement(By.cssSelector("#input-username"));
        userName.sendKeys("demo");
        WebElement password = driver.findElement(By.cssSelector("#input-password"));
        password.sendKeys("demo");
        WebElement Login = driver.findElement(By.tagName("button"));
        Login.click();
        Thread.sleep(2000);
        WebElement xbutton = driver.findElement(By.cssSelector(".btn-close"));
        xbutton.click();
        WebElement catalog = driver.findElement(By.xpath("//a[contains(text(),'Catalog')]"));
        catalog.click();
        Thread.sleep(2000);
        WebElement productButton = driver.findElement(By.xpath("//a[.='Products']"));
        productButton.click();
        /*
        Steps:
        1-Find the all boxes location
        2-Use regular for loop and start from 1(int i=1)
        3-Inside of loop you should have:
            1-Thread.sleep
            2-IsDisplayed(true)
            3-IsDisplayed(true)
            4-IsSelected(false)--> AssertFalse
            5-Click
            6-IsSelected(true)-->AssertTrue
            7-box.sendKeys(Keys.Arrow_Down)
         */
        List<WebElement> boxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        for (int i = 1; i < boxes.size(); i++) {
            Thread.sleep(2000);
            Assert.assertTrue(boxes.get(i).isDisplayed());
            Assert.assertTrue(boxes.get(i).isEnabled());
            Assert.assertFalse(boxes.get(i).isSelected());// as default it should not be selected
            boxes.get(i).click();
            Assert.assertTrue(boxes.get(i).isSelected());//this one should selected
            boxes.get(i).sendKeys(Keys.ARROW_DOWN);

        }
    }
    /*
    TEST CASE:
            1-You will click the productName button
           2-You should create 2 arraylist
       *-One of them will be actualData
       *-Another will be expectedData
            3-For(int i=1)
        *store all the names for both of the list.Please use at the end .toUpperCase or toLowerCase
      4-For expected List -->you will use Collections.sort(expectedList)
                    -->Collections.reverse(expected)
            Assert.equals(actualList,expectedlist)
            */
        @Test
        public void ValidateProductNameAscendingOrder() throws InterruptedException {
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--remote-allow-origins=*");
            WebDriver driver = new ChromeDriver(chromeOptions);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("https://demo.opencart.com/admin/");
            WebElement userName = driver.findElement(By.cssSelector("#input-username"));
            userName.sendKeys("demo");
            WebElement password = driver.findElement(By.cssSelector("#input-password"));
            password.sendKeys("demo");
            WebElement Login = driver.findElement(By.tagName("button"));
            Login.click();
            Thread.sleep(2000);
            WebElement xbutton = driver.findElement(By.cssSelector(".btn-close"));
            xbutton.click();
            WebElement catalog = driver.findElement(By.xpath("//a[contains(text(),'Catalog')]"));
            catalog.click();
            Thread.sleep(2000);
            WebElement productButton = driver.findElement(By.xpath("//a[.='Products']"));
            productButton.click();
            List<WebElement> PRODUCTS=driver.findElements(By.xpath("//td[@class='text-start']"));
            List<String> actualPruductOrder=new ArrayList<>();
            List<String> expectedPruductOrder=new ArrayList<>();
            for (int i=1;i<PRODUCTS.size();i++){
                actualPruductOrder.add(PRODUCTS.get(i).getText().toLowerCase().trim());
                expectedPruductOrder.add(PRODUCTS.get(i).getText().toLowerCase().trim());
            }
            Collections.sort(expectedPruductOrder);
            System.out.println(actualPruductOrder);
            System.out.println(expectedPruductOrder);
            Assert.assertEquals(actualPruductOrder,expectedPruductOrder); //this part is comparison


        }
        @Test
        public void validateDescendingOrder() throws InterruptedException {
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--remote-allow-origins=*");
            WebDriver driver = new ChromeDriver(chromeOptions);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("https://demo.opencart.com/admin/");
            WebElement userName = driver.findElement(By.cssSelector("#input-username"));
            userName.sendKeys("demo");
            WebElement password = driver.findElement(By.cssSelector("#input-password"));
            password.sendKeys("demo");
            WebElement Login = driver.findElement(By.tagName("button"));
            Login.click();
            Thread.sleep(2000);
            WebElement xbutton = driver.findElement(By.cssSelector(".btn-close"));
            xbutton.click();
            WebElement catalog = driver.findElement(By.xpath("//a[contains(text(),'Catalog')]"));
            catalog.click();
            Thread.sleep(2000);
            WebElement productButton = driver.findElement(By.xpath("//a[.='Products']"));
            productButton.click();
            Thread.sleep(2000);

            WebElement productName=driver.findElement(By.xpath("//a[.='Product Name']"));
            productName.click();
            Thread.sleep(2000);

            List<WebElement> PRODUCTS=driver.findElements(By.xpath("//td[@class='text-start']"));
            List<String> actualPruductOrder=new ArrayList<>();
            List<String> expectedPruductOrder=new ArrayList<>();
            Thread.sleep(2000);
            for (int i=1;i<PRODUCTS.size();i++){

                actualPruductOrder.add(PRODUCTS.get(i).getText().toLowerCase().trim());
                expectedPruductOrder.add(PRODUCTS.get(i).getText().toLowerCase().trim());
            }
            Collections.sort(expectedPruductOrder);
            Collections.reverse(expectedPruductOrder);// this one will make reversed
            System.out.println(actualPruductOrder);
            System.out.println(expectedPruductOrder);
            Assert.assertEquals(actualPruductOrder,expectedPruductOrder);

        }
    }

