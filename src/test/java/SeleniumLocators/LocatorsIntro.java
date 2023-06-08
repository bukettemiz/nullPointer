package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LocatorsIntro {
    public static void main(String[] args) throws InterruptedException {

   //Locators: Is a way to locate(find) element and manipulate on it

   //ID LOCATOR:
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.navigate().to("file:///C:/Users/Laptop/Downloads/Techtorial%20(1).html");
        driver.manage().window().maximize();
        WebElement header=driver.findElement(By.id("techtorial1"));
        String actualHeader=header.getText().trim();//it gets text from the element
        String expectedHeader="Techtorial Academy";
        System.out.println(header.getText());
        System.out.println(actualHeader.equals(expectedHeader)?"CORRECT":"WRONG");
        WebElement paragraph=driver.findElement(By.id("details2"));
        System.out.println(paragraph.getText());// you will see the paragraph which you've choose

        // NAME LOCATOR
        WebElement firstName=driver.findElement(By.name("firstName"));
        firstName.sendKeys("Buket");
        WebElement LastName=driver.findElement(By.name("lastName"));
        LastName.sendKeys("Temiz");
        WebElement phone=driver.findElement(By.name("phone"));
        phone.sendKeys("1234567");
        WebElement email=driver.findElement(By.id("userName"));
        email.sendKeys("buki@gmail.com");
        WebElement address=driver.findElement(By.name("address1"));
        address.sendKeys("yukari mahalle");
        WebElement city=driver.findElement(By.name("city"));
        city.sendKeys("avanos");

        // CLASS LOCATORS

        WebElement allTools=driver.findElement(By.className("group_checkbox"));
        System.out.println(allTools.getText());
        WebElement javaBox=driver.findElement(By.id("cond3"));
        if (javaBox.isDisplayed()&& !javaBox.isSelected()){
            javaBox.click();//this will click the box
        }
        System.out.println(javaBox.isSelected()?"SELECTED":"NOT SELECTED");//WE ARE CHECKING IS THAT SELECTED OR NOT

     WebElement testNG=driver.findElement(By.id("cond3"));
     if (testNG.isDisplayed()&& !testNG.isSelected()){
         testNG.click();
     }
        System.out.println(testNG.isSelected()?"CHECKED":"NOT CHECKED");

    //TAG NAME LOCATOR: only <letter> <letter> letter will be enough

  WebElement header2=driver.findElement(By.tagName("h1"));
        System.out.println(header2.getText());

        WebElement javaVersion=driver.findElement(By.tagName("u"));
        System.out.println(javaVersion.getText());
        Thread.sleep(3000);
        driver.quit();




    }
}
