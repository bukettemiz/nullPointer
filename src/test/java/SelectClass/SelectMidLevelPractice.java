package SelectClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SelectMidLevelPractice {
    @Test
    public void validateOrderMesage() throws InterruptedException {
               /*
        1-Navigate to the website
2-Select one way trip button
3-Choose 4 passangers(1 wife-1 husband-2 kids)
4-Validate the depart from is default "Acapulco"
5-Choose the depart from is Paris
6-Choose the date August 15th
7-Choose the arrive in is San Francisco
8-Choose the date December 15th
10-Click first class option.
11-Validate All the options from Airline
12-Choose the Unified option from airline list
13-Click Continue
14-Validate the message at the top.There is a bug here/
 "After flight finder - No Seats Avaialble"

 NOTE:Your test should fail and say available is not matching with Available.
 NOTE2:You can use any select method value,visibleText
         */
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.guru99.com/test/newtours/reservation.php");
        WebElement travelOptions=driver.findElement(By.xpath("//input[@value='oneway']"));
        travelOptions.click();
        WebElement Passengers= driver.findElement(By.xpath("//select[@name='passCount']"));
        Select passengerAmount=new Select(Passengers);
        passengerAmount.selectByValue("4");
        WebElement defaultDeparting=driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select departure=new Select(defaultDeparting);
        String actualFirstOption=departure.getFirstSelectedOption().getText().trim();
        String expectedFirstOption="Acapulco".trim();
        Assert.assertEquals(actualFirstOption,expectedFirstOption);
        Thread.sleep(2000);
        departure.selectByValue("Paris");
        WebElement months=driver.findElement(By.xpath("//select[@name='fromMonth']"));
        Select monthselection=new Select(months);
        Thread.sleep(2000);
        monthselection.selectByValue("8");
        WebElement dates= driver.findElement(By.xpath("//select[@name='fromDay']"));
        Select dateselection=new Select(dates);
        Thread.sleep(2000);
        dateselection.selectByIndex(14);
        WebElement arriving=driver.findElement(By.xpath("//select[@name='toPort']"));
        Select ArrivingDestinations=new Select(arriving);
        Thread.sleep(2000);
        ArrivingDestinations.selectByVisibleText("San Francisco");
        WebElement returningMonth=driver.findElement(By.xpath("//select[@name='toMonth']"));
        Select reDates=new Select(returningMonth);
        Thread.sleep(2000);
        reDates.selectByValue("12");
        WebElement returnDate=driver.findElement(By.xpath("//select[@name='toDay']"));
        Select reDate=new Select(returnDate);
        Thread.sleep(2000);
        reDate.selectByIndex(14);
        WebElement classOption=driver.findElement(By.xpath("//input[@value='First']"));
        Thread.sleep(1000);
        classOption.click();
        WebElement airlinesOptions=driver.findElement(By.xpath("//select[@name='airline']"));
        Select airlines=new Select(airlinesOptions);

        List<WebElement> ActualallAirlines=airlines.getOptions();
        List<WebElement> ExpectedAirlines=new ArrayList<>();
        for (WebElement airline:ActualallAirlines){
            ExpectedAirlines.add(airline);
        }
        Assert.assertEquals(ActualallAirlines,ExpectedAirlines);
        Thread.sleep(2000);
        airlines.selectByIndex(2);
        WebElement contine= driver.findElement(By.xpath("//input[@name='findFlights']"));
        Thread.sleep(2000);
        contine.click();
        WebElement bugfinder= driver.findElement(By.xpath("//font[@size=4]"));
        String expectedText="After flight finder - No Seats Available";
        Thread.sleep(2000);
        Assert.assertEquals(bugfinder,expectedText);
    }
    @Test
    public static void utils() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.guru99.com/test/newtours/reservation.php");
        WebElement travelOptions=driver.findElement(By.xpath("//input[@value='oneway']"));
        travelOptions.click();
        WebElement Passengers= driver.findElement(By.xpath("//select[@name='passCount']"));
        Select passengerAmount=new Select(Passengers);
        passengerAmount.selectByValue("4");
        WebElement defaultDeparting=driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select departure=new Select(defaultDeparting);
        String actualFirstOption=departure.getFirstSelectedOption().getText().trim();
        String expectedFirstOption="Acapulco".trim();
        Assert.assertEquals(actualFirstOption,expectedFirstOption);
        Thread.sleep(2000);
        departure.selectByValue("Paris");

        WebElement months=driver.findElement(By.xpath("//select[@name='fromMonth']"));
        BrowserUtils.selectBy(months,"8","value");
       // Select monthselection=new Select(months);
       // Thread.sleep(2000);
       // monthselection.selectByValue("8");
        WebElement dates= driver.findElement(By.xpath("//select[@name='fromDay']"));
        BrowserUtils.selectBy(dates,"14","index");
       // Select dateselection=new Select(dates);
       // Thread.sleep(2000);
       // dateselection.selectByIndex(14);
        WebElement arriving=driver.findElement(By.xpath("//select[@name='toPort']"));
        Select ArrivingDestinations=new Select(arriving);
        Thread.sleep(2000);
        ArrivingDestinations.selectByVisibleText("San Francisco");
        WebElement returningMonth=driver.findElement(By.xpath("//select[@name='toMonth']"));
        Select reDates=new Select(returningMonth);
        Thread.sleep(2000);
        reDates.selectByValue("12");
        WebElement returnDate=driver.findElement(By.xpath("//select[@name='toDay']"));
        Select reDate=new Select(returnDate);
        Thread.sleep(2000);
        reDate.selectByIndex(14);
        WebElement classOption=driver.findElement(By.xpath("//input[@value='First']"));
        Thread.sleep(1000);
        classOption.click();
        WebElement airlinesOptions=driver.findElement(By.xpath("//select[@name='airline']"));
        Select airlines=new Select(airlinesOptions);

        List<WebElement> ActualallAirlines=airlines.getOptions();
        List<WebElement> ExpectedAirlines=new ArrayList<>();
        for (WebElement airline:ActualallAirlines){
            ExpectedAirlines.add(airline);
        }
        Assert.assertEquals(ActualallAirlines,ExpectedAirlines);
        Thread.sleep(2000);
        airlines.selectByIndex(2);
        WebElement contine= driver.findElement(By.xpath("//input[@name='findFlights']"));
        Thread.sleep(2000);
        contine.click();
        WebElement bugfinder= driver.findElement(By.xpath("//font[@size=4]"));
        String expectedText="After flight finder - No Seats Available";
        Thread.sleep(2000);
        Assert.assertEquals(bugfinder,expectedText);

    }
}
