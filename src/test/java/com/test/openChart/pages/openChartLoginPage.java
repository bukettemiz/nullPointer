package com.test.openChart.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class openChartLoginPage {
    public openChartLoginPage(WebDriver driver){

        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//input[@id='input-username']")
    WebElement userName;
    @FindBy(xpath = "//input[@name='password']")
    WebElement password;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitButton;
    @FindBy(css = "#alert")
    WebElement alertMessage;

    public void loginFunctionality(String userName,String password) throws InterruptedException {
        this.userName.sendKeys(userName);
        Thread.sleep(2000);
        this.password.sendKeys(password);
        Thread.sleep(2000);
        submitButton.click();
        Thread.sleep(2000);
    }
    public String alertMessage(){

        return BrowserUtils.getText(alertMessage);
    }
}
