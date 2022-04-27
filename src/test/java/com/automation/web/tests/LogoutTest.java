package com.automation.web.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MainPage;

public class LogoutTest extends BaseTest {
    @Test
    public void testLogout(){
        LoginPage loginPage = homePage.clickLoginButton();
        loginPage.setEmail(email);
        loginPage.setPassword(password);
        MainPage mainPage = loginPage.clickLoginButton();
        Assert.assertTrue(mainPage.isLogoutButtonDisplayed());
        HomePage homePageReturned = mainPage.clickLogoutButton();
        Assert.assertEquals(homePageReturned.getMainContainerTitle(), "Welcome!",
                "You are not in home page");
    }
}
