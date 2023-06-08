package com.test.openChart.tests;

import com.test.openChart.pages.openChartLoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends openChartTestBase {

    @Test
    public void HappyPathLogin() throws InterruptedException {

    openChartLoginPage loginpage = new openChartLoginPage(driver);

    loginpage.loginFunctionality("demo","demo");

        Assert.assertEquals(driver.getTitle().trim(),"Dashboard");
}
@Test
    public void validateNegativeLogin() throws InterruptedException {
        openChartLoginPage loginPage=new openChartLoginPage(driver);
        loginPage.loginFunctionality("wrongusername","wrongpassword");
        Assert.assertEquals(loginPage.alertMessage(),"No match for Username and/or Password.");

}
}
