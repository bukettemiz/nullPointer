package com.test.bank.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class BankManagerPage {
    public BankManagerPage(WebDriver driver){
        PageFactory.initElements(driver,this);

    }
    @FindBy(xpath = "//button[contains(text(),'Add Customer')]")
    WebElement addCustomerButton;

    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement firstname;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lastname;

    @FindBy(xpath = "//input[@placeholder='Post Code']")
    WebElement postcode;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitAddCustomerButton;

    @FindBy(xpath = "//button[contains(text(),'Open Account')] \t\t")
    WebElement openAccount;

    @FindBy(css = "#userSelect")
    WebElement customerName;

    @FindBy(css = "#currency")
    WebElement currency;

    @FindBy(xpath = "//button[.='Process']")
    WebElement processButton;

    @FindBy(xpath = "//button[contains(text(),'Customers')] ")
    WebElement customerButton;

    @FindBy(xpath = "//input[@placeholder='Search Customer']")
    WebElement searchBox;

    @FindBy(xpath = "//td[@class='ng-binding']")
    List<WebElement> allInformation;
    @FindBy(xpath = "//button[contains(text(),'Home')]")
    WebElement homeButton;


    public void AddCustomerFunctionality(WebDriver driver, String firstname,String lastname,String postcode, String expectedMessage){
        //Provide driver because we need to call method in test class
        addCustomerButton.click();
        this.firstname.sendKeys(firstname);
        this.lastname.sendKeys(lastname);
        this.postcode.sendKeys(postcode);
        submitAddCustomerButton.submit();// When the html have type of 'submit and under form >> use submit (act click)

        Alert alert= driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains(expectedMessage));
        alert.accept();
    }
    public void OpenAccountFunctionality(WebDriver driver,String CustomerName,String currency,String expectedMessage) throws InterruptedException {
        openAccount.click();
        BrowserUtils.selectBy(this.customerName,CustomerName,"text");
        BrowserUtils.selectBy(this.currency,currency,"value");//we use this because there is 2 same name not for confusing
        processButton.click();
        Thread.sleep(2000);
        Alert alert=driver.switchTo().alert();
        Assert.assertTrue(alert.getText().trim().contains("Account created successfully with account Number"));
        alert.accept();
    }
    public void customersFunctionality(String customerName,String lastname, String postcode) throws InterruptedException {

        customerButton.click();
        Thread.sleep(2000);
        searchBox.sendKeys(customerName);
        List<String> exceptedNames= Arrays.asList(customerName,lastname,postcode);

        for (int i=0;i<allInformation.size();i++){
            Assert.assertEquals(BrowserUtils.getText(allInformation.get(i)),exceptedNames.get(i));
        }
    }
    public void clickhomeButton(){
        homeButton.click();
    }
}
