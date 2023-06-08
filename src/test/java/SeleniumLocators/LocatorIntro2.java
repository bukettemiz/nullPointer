package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LocatorIntro2 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("file:///C:/Users/Laptop/Downloads/Techtorial%20(1).html");

        //LINKTEXT LOCATORS: To be able to use this locator it has to be like <a> <a/>


        WebElement javalink=driver.findElement(By.linkText("Java"));
        javalink.click();
        WebElement javaHeader=driver.findElement(By.tagName("h1"));
        String actualHeader=javaHeader.getText().trim();
        String expectedHeader="Java";
        System.out.println(actualHeader.equals(expectedHeader)?"CORRECT":"FALSE");
        /*
1-Click Selenium and validate(ternary) header -->Selenium automates browsers. That's it!
2-Go back to the main page
3-Click Cucumber and validate(ternary) header -->Tools & techniques that elevate teams to greatness
4-Go back to the main page
5-Click TestNG and validate(ternary) header -->TestNG
6-Go back to the main page
7-Validate(ternary) the url is "file:///Users/codefish/Downloads/Techtorial.html"
 */
        driver.navigate().back();
        WebElement selenium=driver.findElement(By.linkText("Selenium")); //it has <a tag and name that's why we use linkText
        selenium.click();
        WebElement seleniumHeader=driver.findElement(By.tagName("h1"));
        String actualSeleniumHeader=seleniumHeader.getText().trim();
        String expectedSeleniumHeader="Selenium automates browsers. That's it!";
        System.out.println(actualHeader.equals(expectedSeleniumHeader)? "PASSED SELENIUM" :"FAILED SELENIUM");

        driver.navigate().back();
        WebElement testNGlink=driver.findElement(By.linkText("TestNG"));
        testNGlink.click();
        WebElement headertestNG=driver.findElement(By.tagName("h2"));
        System.out.println(headertestNG.getText());

        driver.navigate().back();
        String actualURL=driver.getCurrentUrl();
        String expectedURL="file:///C:/Users/Laptop/Downloads/Techtorial%20(1).html";
        System.out.println(actualURL.equals(expectedURL)? "PASSED URL":"FAILED URL");





    }
}
