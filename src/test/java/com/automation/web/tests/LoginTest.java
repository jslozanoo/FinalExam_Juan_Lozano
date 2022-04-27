package com.automation.web.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MainPage;
import pages.ProfilePage;

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
        mainPage.clickLogoutButton();
        Thread.sleep(7000); // delete this
    }
    @Test
    public void testLogout(){
        LoginPage loginPage = homePage.clickLoginButton();
        loginPage.setEmail(email);
        loginPage.setPassword(password);
        MainPage mainPage = loginPage.clickLoginButton();
        Assert.assertTrue(mainPage.isLoginButtonDisplayed());
        HomePage homePageReturned = mainPage.clickLogoutButton();
        Assert.assertEquals(homePageReturned.getMainContainerTitle(), "Welcome!",
                "You are not in home page");
    }
}
