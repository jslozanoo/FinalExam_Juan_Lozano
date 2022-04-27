package com.automation.web.tests;

import com.automation.web.data.User;
import driver.Driver;
import org.testng.annotations.Test;
import pages.*;

public class CreateAccountTest {
    @Test
    public void testLogin(){
        Driver driver = new Driver("chrome");
        driver.getDriver().manage().window().maximize();
        driver.getDriver().get("https://www.espnqa.com/?src=com&_adblock=true&espn=cloud");
        HomePage homePage = new HomePage(driver.getDriver());
        LoginPage loginPage = homePage.clickLoginButton();
        loginPage.setEmail("test-globant@gmail.com");
        loginPage.setPassword("142308Jslp");
        loginPage.clickLoginButton();
        driver.getDriver().close();
        // Ok method
    }

    @Test
    public void testCreateAccount(){
        Driver driver = new Driver("chrome");
        driver.getDriver().manage().window().maximize();
        driver.getDriver().get("https://www.espnqa.com/?src=com&_adblock=true&espn=cloud");
        HomePage homePage = new HomePage(driver.getDriver());
        LoginPage loginPage = homePage.clickLoginButton(); // I'm in the iframe
        SignupPage signupPage = loginPage.clickSignupButton();
        User user = new User("sofia", "acosta", "sofiaacosta@gmail.com",
                "sofi2008");
        signupPage.setFormFields(user.getFirstName() , user.getLastName(), user.getEmail(),
                user.getPassword());
        signupPage.clickSignUpButton();
        driver.getDriver().close();
    }
    // With the assumption that we are in the main page (logged)
    @Test
    public void testDeleteAccount() throws InterruptedException {
        Driver driver = new Driver("chrome");
        driver.getDriver().manage().window().maximize();
        driver.getDriver().get("https://www.espnqa.com/?src=com&_adblock=true&espn=cloud");
        HomePage homePage = new HomePage(driver.getDriver());
        LoginPage loginPage = homePage.clickLoginButton();
        loginPage.setEmail("test-globant2@gmail.com");
        loginPage.setPassword("mirta2008");
        MainPage mainpage = loginPage.clickLoginButton();
        ProfilePage profilePage = mainpage.clickProfileButton();
        profilePage.clickToDeleteAccountLink();
        Thread.sleep(3000); //Left to confirm account delete
        profilePage.clickConfirmDeleteAccount();
        Thread.sleep(4000);
        driver.getDriver().quit();
    }

    @Test
    public void testLogout() throws InterruptedException {
        Driver driver = new Driver("chrome");
        driver.getDriver().manage().window().maximize();
        driver.getDriver().get("https://www.espnqa.com/?src=com&_adblock=true&espn=cloud");
        HomePage homePage = new HomePage(driver.getDriver());
        LoginPage loginPage = homePage.clickLoginButton();
        loginPage.setEmail("test-globant@gmail.com");
        loginPage.setPassword("142308Jslp");
        MainPage mainPage = loginPage.clickLoginButton();
        mainPage.clickLogoutButton();
        Thread.sleep(5000);
        driver.getDriver().close();
    }
}
