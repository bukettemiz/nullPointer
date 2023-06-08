package ActionsClass;

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

public class DragAndDrop {
    @Test
    public void dragAndDrop() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demos.telerik.com/kendo-ui/dragdrop/area");

        WebElement orangebox= driver.findElement(By.xpath("//div[@id='droptarget']//div[@class='test2']"));
        String actualMessage= BrowserUtils.getText(orangebox);
        String expectedMesage="... Or here.";
        Assert.assertEquals(actualMessage,expectedMesage);
        String ActualBackgroundColor=orangebox.getCssValue("background-color");
        String expectedBackgroundColor="rgba(238, 111, 11, 1";
        Assert.assertEquals(expectedBackgroundColor,expectedBackgroundColor);
        WebElement dragger=driver.findElement(By.xpath("//div[@id='draggable']"));
        Actions aaction=new Actions(driver);
        aaction.dragAndDrop(dragger,orangebox).perform();
        Thread.sleep(2000);//staleElementException you can solve with this
        orangebox= driver.findElement(By.xpath("//div[@id='droptarget']//div[@class='test2']"));//and reassing it for passing the exception
        //actions.scrollByAmount(200,200).perform();--->this will scroll down the page
        String actualAfterDragAndDrop=BrowserUtils.getText(orangebox);
        String expectedAfterDragAndDrop="You did great!";
        Assert.assertEquals(actualAfterDragAndDrop,expectedAfterDragAndDrop);
    }
    @Test
    public void DragAndDropPractice1(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demos.telerik.com/kendo-ui/dragdrop/area");
        WebElement blueBox= driver.findElement(By.xpath("//div[@class='test1']"));
        String actualMessage=BrowserUtils.getText(blueBox);
        String expectedMessage="Drag thesmall circle here ...";
        Assert.assertEquals(actualMessage,expectedMessage);
        String actualColor=blueBox.getCssValue("background-color".trim());
        String expectedColor="";
        Assert.assertEquals(actualColor,expectedColor);
        WebElement draggable=driver.findElement(By.xpath("//div[@id='draggable']"));
        Actions actions=new Actions(driver);
        actions.clickAndHold(draggable).moveToElement(blueBox).release().perform();
        blueBox= driver.findElement(By.xpath("//div[@class='test1']"));
        String actualAfterAction=BrowserUtils.getText(blueBox);
        String expectedAfterActions="You did great!";
        Assert.assertEquals(actualAfterAction,expectedAfterActions);
    }
    @Test
    public void Practice2(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demoqa.com/droppable");
        WebElement dropBox=driver. findElement (By.xpath( "//div[@id='simpleDropContainer']//div[@id='droppable']"));
        String actualMessage = BrowserUtils.getText(dropBox);
        String expectedMessage= "Drop here";
        Assert.assertEquals (actualMessage, expectedMessage);
        WebElement drag=driver. findElement (By.xpath( "//div[@id='draggable ']"));
        Actions actions=new Actions (driver);
        actions.dragAndDrop (drag, dropBox) . perform () ;
        dropBox=driver.findElement (By.xpath ( "/ /div[@id='simpleDropContainer']//div[@id='droppable ']"));
        String actualAfterDragAndDrop=BrowserUtils.getText(dropBox);
        String expectedAfterDragAndDrop="";
        Assert.assertEquals (actualAfterDragAndDrop, expectedAfterDragAndDrop);
    }
    @Test
    public void Practice3(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demoqa.com/droppable");
        WebElement accept= driver.findElement(By.cssSelector("#droppableExample-tab-accept"));
        accept.click();
        WebElement notAcceptButton= driver.findElement(By.cssSelector("#notAcceptable"));
        String actualText=BrowserUtils.getText(notAcceptButton);
        String expectedText="Not Acceptable";
        Assert.assertEquals (actualText, expectedText) ;
        WebElement box=driver.findElement (By.xpath("//div[@id='simpleDropContainer']//div[@id='droppable']"));
        String actualMessage=BrowserUtils.getText(box);
        String expectedMessage="Drop here";
        Assert.assertEquals (actualMessage, expectedMessage);
        Actions actions=new Actions(driver);
        actions.clickAndHold(notAcceptButton).moveToElement(box).release().perform();
        String ActualMessageAfterAction=BrowserUtils.getText(box);
        String expectedMessageAfterAction="Drop here";
        Assert.assertEquals(ActualMessageAfterAction,expectedMessageAfterAction);

    }
}
