package com.automation.web.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;

public class LoginTest extends BaseTest{
    @Test
    public void testLogin() throws InterruptedException {
        Assert.assertEquals(homePage.getMainContainerTitle(), "Welcome!",
                "You are not in home page");
        LoginPage loginPage = homePage.clickLoginButton();
        Assert.assertEquals(loginPage.getValidationLinkText(), "Need help logging in?",
                "You are not in the login interface");
        loginPage.setEmail(email);
        loginPage.setPassword(password);
        MainPage mainPage = loginPage.clickLoginButton();
        Assert.assertTrue(mainPage.isProfileButtonVisible());
        Thread.sleep(7000); // delete this
    }
}
