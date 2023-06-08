package com.test.bank.tests;

import com.test.bank.pages.BankLoginPage;
import com.test.bank.pages.BankManagerPage;
import com.test.bank.pages.CustomerPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

public class CustomerPageTest extends BankTestBase {
    @Test
    public void ValidateCustomerLoginFunctionality() throws InterruptedException {

        BankLoginPage loginPage = new BankLoginPage(driver);
        loginPage.clickManagerButton();
        BankManagerPage bankManagerPage = new BankManagerPage(driver);
        bankManagerPage.AddCustomerFunctionality(driver, "buket", "temiz",
                "60181", "Customer added successfully with customer id");
        bankManagerPage.OpenAccountFunctionality(driver, "buket temiz", "Dollar",
                "Account created successfully with account Number");
        bankManagerPage.customersFunctionality("buket", "temiz", "60181");
        bankManagerPage.clickhomeButton();
        Thread.sleep(1000);
        loginPage.clickCustomerLoginButton();
        CustomerPage customerPage = new CustomerPage(driver);
        customerPage.CustomerLoginFunctionality("buket temiz", "Welcome buket temiz !!");
        customerPage.CustomerAccountDepositFunctionality("500", "Deposit Successful");
        Thread.sleep(2000);
        customerPage.CustomerAccountWithdrawlFunctionality("300", "Transaction successful");
        Thread.sleep(2000);
        customerPage.ValidateTransactionAmountFunctionality();
        driver.quit();

    }
}
