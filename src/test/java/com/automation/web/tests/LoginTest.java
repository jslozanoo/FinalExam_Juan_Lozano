package com.automation.web.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest{
    @Test
    public void testLogin() throws InterruptedException {
        Assert.assertEquals(homePage.getMainContainerTitle(), "Welcome!",
                "You are not in home page");
        LoginPage loginPage = homePage.clickLoginButton();
        Thread.sleep(2000); //remove this and the exception
        /*
        loginPage.setEmail("test-globant@gmail.com");
        loginPage.setPassword("142308Jslp");
        loginPage.clickLoginButton();
        driver.getDriver().close();

         */
    }
}
