package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class XPATHRealHealthProject {
             /*
//THESE PARTS SHOULD BE DONE BY XPATH:
1-Navigate to the https://katalon-demo-cura.herokuapp.com/ -->DONE
2-Click Make an Appointment
3-Login the username and password provided and Login successfully
4-Choose the facility either HongKong or Seoul -->send keys
5-Click apply for hospital admission box if it is displayed and validate it is selected
6-Healthcare program 'Medicaid'
7-Visit date should be provided -->send keys
8-Put your comment for this box -->send keys
9-Book your appointment
THESE PARTS SHOULD BE DONE BY CONTAINS or . XPATH METHOD
10-Validate the header is "Appointment confirmation" (if statement)
11-Print out the headers and values(only values) on your console.
12)Click go to homepage and print out url
13)Driver.quit or close. */


    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(chromeOptions);
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        //CSS WITH ID
       // WebElement makeappoitment=driver.findElement(By.xpath("//a[@id='#btn-make-appointment']"));
        //makeappoitment.click();
        WebElement makeAppoitment=driver.findElement(By.cssSelector("#btn-make-appointment"));
        makeAppoitment.click();
        WebElement userName=driver.findElement(By.xpath("//input [@id='txt-username']"));
        userName.sendKeys("John Doe");
        WebElement password=driver.findElement(By.xpath("//input [@id='txt-password']"));
        password.sendKeys("ThisIsNotAPassword");
        WebElement login=driver.findElement(By.xpath("//button[@id='btn-login']"));
        login.click();
        Thread. sleep (  3000);
        WebElement choose=driver.findElement(By.name("facility"));
        choose.sendKeys("Hongkong CURA Healthcare Center");
        WebElement readmission=driver.findElement(By.xpath("//input[@name='hospital_readmission']"));
        if (readmission.isDisplayed()&&!readmission.isSelected()){
            readmission.click();
        }
        WebElement healthcareProgram=driver.findElement(By.xpath("//input[@valve= 'Medicaid']"));
        healthcareProgram.click();
        WebElement healthCareProgram=driver .findElement (By.xpath (" / /input [@valve= 'Medicaid']"));
        healthCareProgram.click();
        Thread. sleep (  3000);
        WebElement date=driver.findElement (By.xpath ( "//input[@name='visit_date']"));
        date.sendKeys("06/02/2023");
        WebElement comment=driver.findElement (By .xpath ( "//textarea[@id='tt_comment']")) ;
        comment.sendKeys( "Selenium Is Awesome");
        WebElement button=driver.findElement (By.xpath( "//button[@id='btn-book-appointment']"));
        //CSS WITH CLASS
        WebElement buton=driver.findElement(By.cssSelector(".btn-default"));
        button. click();
        Thread. sleep (  3000);
        WebElement confirmationHeader=driver.findElement (By.xpath ("/ /h2[. = 'Appointment Confirmation']"));
        String actualHeader=confirmationHeader.getText().trim();
        String expectedHeader="Appointment Confirmation";
        System.out.println (actualHeader. equals (expectedHeader) ? "PASSED" : "FAILED");
        WebElement commentValidation=driver.findElement (By. xpath ("//p[contains (text (), 'Selenium')]"));
        System.out.println(commentValidation.getText().trim());

        Thread. sleep (  3000);
        driver.quit ();







    }
}
