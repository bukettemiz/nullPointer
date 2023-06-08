package com.test.bank.pages;


import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BankLoginPage {
    public BankLoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);// It does same logic of driver.findElement
    }
    @FindBy(css =".mainHeading")
    WebElement header;

    @FindBy(xpath = "//button[.'Customer Login']")
    WebElement customerLogin;

    @FindBy(xpath ="//button[contains(text(),'Bank Manager')]")
    WebElement managerLogin;


    public void LoginPageComponentsValidation(String expectedHeader){
        Assert.assertEquals(BrowserUtils.getText(header),expectedHeader);
        Assert.assertTrue(customerLogin.isSelected() && customerLogin.isEnabled());
        Assert.assertTrue(managerLogin.isDisplayed()&& managerLogin.isEnabled());
    }
    public void clickManagerButton(){
        managerLogin.click();
    }
    public void clickCustomerLoginButton(){
        customerLogin.click();
    }
}
