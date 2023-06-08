package com.test.bank.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CustomerPage {
    public CustomerPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = "#userSelect")
    WebElement nameList;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;

    @FindBy(xpath = "//strong[contains(text(),'Welcome')]")
    WebElement header;

    @FindBy(xpath = "//button[contains(text(),'Deposit')]")
    WebElement depositButton;

    @FindBy(xpath = "//input[@placeholder='amount']")
    WebElement depositAmount;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement depositTheAmountButton;

    @FindBy(xpath = "//span[contains(text(), 'Deposit Successful')]")
    WebElement message;

    @FindBy(xpath = "//button[contains(text(), 'Withdrawl')]")
    WebElement withdrawlButton;

    @FindBy(xpath = "//input[@placeholder='amount']")
    WebElement withdrawlAmount;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement withdrawlNowButton;

    @FindBy(xpath = "//span[@ng-show='message']")
    WebElement withdrawlMessage;

    @FindBy(xpath = "//strong[contains(text(),'200')]")
    WebElement remainderAmount;

    @FindBy(xpath = "//button[@ng-click='transactions()']")
    WebElement transactionButton;

    @FindBy(xpath = "//td[contains(text(), '500')]")
    WebElement depositAmountAsNumber;

    @FindBy(xpath = "//td[contains(text(), '300')]")
    WebElement withdrawlAmountAsNumber;

    public void CustomerLoginFunctionality(String name, String expectedHeader) throws InterruptedException {
        BrowserUtils.selectBy(nameList, name, "text");
        Thread.sleep(2000);
        loginButton.click();
        Assert.assertEquals(BrowserUtils.getText(header), expectedHeader);
    }

    public void CustomerAccountDepositFunctionality(String amount, String expectedMessage) throws InterruptedException {
        depositButton.click();
        this.depositAmount.sendKeys(amount);
        depositTheAmountButton.click();
        Thread.sleep(2000);
        Assert.assertEquals(BrowserUtils.getText(message), expectedMessage);
    }
    public void CustomerAccountWithdrawlFunctionality(String withdrawlAmount1, String expectedMessage) throws InterruptedException {
        withdrawlButton.click();
        Thread.sleep(2000);
        this.withdrawlAmount.sendKeys(withdrawlAmount1);
        withdrawlNowButton.click();
        Assert.assertEquals(BrowserUtils.getText(withdrawlMessage), expectedMessage);
    }
    public void ValidateTransactionAmountFunctionality() throws InterruptedException {
        int actualBalance=Integer.parseInt(BrowserUtils.getText(remainderAmount));//200
        Thread.sleep(2000);
        transactionButton.click();
        int expectedBalance=(Integer.parseInt(BrowserUtils.getText(depositAmountAsNumber))-
                Integer.parseInt(BrowserUtils.getText(withdrawlAmountAsNumber)));
        Assert.assertEquals(actualBalance, expectedBalance);

    }

}

