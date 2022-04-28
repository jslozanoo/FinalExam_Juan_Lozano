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
        MainPage mainPage = loginPage.clickLoginButton();
        Assert.assertTrue(mainPage.isProfileButtonVisible());
        mainPage.clickLogoutButton();
    }

    @Test
    public void testLogout(){
        MainPage mainPage = new MainPage(driver.getDriver());
        Assert.assertTrue(mainPage.isLogoutButtonDisplayed());
        HomePage homePageReturned = mainPage.clickLogoutButton();
        Assert.assertEquals(homePageReturned.getMainContainerTitle(), "Welcome!",
                "You are not in home page");
    }
    @Test
    public void testDeleteAccount(){
        MainPage mainPage = new MainPage(driver.getDriver());
        Assert.assertTrue(mainPage.isProfileButtonVisible());
        ProfilePage profilePage = mainPage.clickProfileButton();
        Assert.assertEquals(profilePage.getMainTitlePage(), "Update Your Account",
                "You are not in the profile page");
        Assert.assertEquals(profilePage.getChangePasswordTitle(), "Change Password",
                "You are not in the profile page");
        profilePage.clickToDeleteAccountLink();
        Assert.assertEquals(profilePage.getTextInLinkConfirmDeleteAccount(),
                "Disney Guest Services", "You are not in the confirm delete account page");
        Assert.assertEquals(profilePage.getMainTitlePage(), "Are you sure?",
                "You are not in the confirm delete account page");
        profilePage.clickConfirmDeleteAccount();
    }
}
