package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class XPATHPractice {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");
        WebElement firstname=driver.findElement(By.xpath("//input[@id='input-firstname']"));
        firstname.sendKeys("Buket");
        WebElement lastname=driver.findElement(By.xpath("//input[@id='input-lastname']"));
        lastname.sendKeys("Kedisi");
        WebElement email=driver.findElement(By.id("input-email"));
        email.sendKeys("buki@gmail.com");
        WebElement phonenumber=driver.findElement(By.xpath("//input[@id='input-telephone']"));
        phonenumber.sendKeys("123321345");
        WebElement password=driver. findElement (By.xpath ( "//input [@id='input-password']"));
        password. sendKeys ( "ahmet1234");
        WebElement confirmPassword=driver.findElement (By.name ("confirm"));
        confirmPassword. sendKeys ("ahmet1234");
        WebElement confirmBox=driver.findElement (By.xpath( "//input[@name='agree']"));
        confirmBox.click();
        WebElement continueButton=driver.findElement (By.xpath ( "//input[@value= 'Continue ']"));
        continueButton .click();
        WebElement header=driver .findElement (By.xpath ( "//h1[contains (text(), 'Been Created!')]")) ;

        String actualHeader=header.getText().trim();
        String expectedHeader="Your Account Has Been Created!";

        System.out.println(actualHeader. equals (expectedHeader) ? "PASSED" : "FAILED");

        WebElement continueButton2=driver. findElement (By. xpath ("//a[.='Continue']"));

        continueButton2.click();

    }
}
