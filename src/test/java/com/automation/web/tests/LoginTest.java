package com.automation.web.tests;

import com.automation.web.data.User;
import driver.Driver;
import org.apache.log4j.Logger;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LoginPage;
import pages.MainPage;
import pages.SignupPage;

import java.nio.charset.StandardCharsets;
import java.util.Random;

public class LoginTest {
    Driver driver;

    protected HomePage homePage;
    public Logger log = Logger.getLogger(LoginTest.class);

    @BeforeTest
    @Parameters({"browser", "url"})
    public void beforeTest(){
        driver = new Driver("chrome");
        driver.getDriver().manage().window().maximize();
        driver.getDriver().get("https://www.espnqa.com/?src=com&_adblock=true&espn=cloud");
        homePage = new HomePage(driver.getDriver());
    }

    @AfterTest
    public void afterTest(){
        driver.getDriver().quit();
    }

    /**
     * Create an account before each class
     */
    @BeforeClass
    public void beforeClass() {
        LoginPage loginPage = homePage.clickLoginButton();
        SignupPage signupPage = loginPage.clickSignupButton();
        String email = generateRandomString();
        String password = generateRandomString();
        User user = new User("juan", "lozano", email,
                password);
        signupPage.setFormFields(user.getFirstName() , user.getLastName(), user.getEmail(),
                user.getPassword());
        MainPage mainPage = signupPage.clickSignUpButton();
    }

    private String generateRandomString(){
        byte[] array = new byte[6];
        new Random().nextBytes(array);
        return new String(array, StandardCharsets.UTF_8);
    }
}
