package com.automation.web.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MainPage;
import pages.ProfilePage;

public class AccountTest extends BaseTest{
    @Test
    public void testLogin(){
        Assert.assertEquals(homePage.getMainContainerTitle(), "Welcome!",
                "You are not in home page");
        LoginPage loginPage = homePage.clickLoginButton();
        Assert.assertEquals(loginPage.getValidationLinkText(), "Need help logging in?",
                "You are not in the login interface");
        loginPage.setEmail(email);
        loginPage.setPassword(password);
        log.info("email: " + email + ", password: " + password);
        MainPage mainPage = loginPage.clickLoginButton();
        Assert.assertTrue(mainPage.isProfileButtonVisible());
        mainPage.clickLogoutButton();
    }

    @Test
    public void testLogout(){
        LoginPage loginPage = homePage.clickLoginButton();
        loginPage.setEmail(email);
        loginPage.setPassword(password);
        log.info("email: " + email + ", password: " + password);
        MainPage mainPage = loginPage.clickLoginButton();
        Assert.assertTrue(mainPage.isLogoutButtonDisplayed());
        HomePage homePageReturned = mainPage.clickLogoutButton();
        Assert.assertEquals(homePageReturned.getMainContainerTitle(), "Welcome!",
                "You are not in home page");
    }
    @Test
    public void testDeleteAccount() throws InterruptedException {
        LoginPage loginPage = homePage.clickLoginButton();
        loginPage.setEmail(email);
        loginPage.setPassword(password);
        MainPage mainPage = loginPage.clickLoginButton();

        Assert.assertTrue(mainPage.isProfileButtonVisible());

        ProfilePage profilePage = mainPage.clickProfileButton();

        Assert.assertEquals(profilePage.getPageMainTitle(), "Update Your Account",
                "You are not in the profile page");
        Assert.assertEquals(profilePage.getChangePasswordTitle(), "Change Password",
                "You are not in the profile page");

        profilePage.clickToDeleteAccountLink();

        Assert.assertTrue(profilePage.getConfirmDeleteParagraph().contains("By deleting your account"),
                "You are not in the confirm delete account page");
        profilePage.clickConfirmDeleteAccount();
    }
}
