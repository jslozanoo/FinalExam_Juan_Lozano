package com.automation.web.tests;

import com.automation.web.data.User;
import driver.Driver;
import org.apache.log4j.Logger;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LoginPage;
import pages.MainPage;
import pages.SignupPage;

import java.util.Random;

public class BaseTest {
    Driver driver;

    protected HomePage homePage;
    public Logger log = Logger.getLogger(BaseTest.class);
    protected String email;
    protected String password;

    @BeforeTest
    @Parameters({"browser", "url"})
    public void beforeTest(String browser, String url){
        driver = new Driver(browser);
        driver.getDriver().manage().window().maximize();
        driver.getDriver().get(url);
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
        String email = generateRandomEmail();
        this.email = email;
        String password = generateRandomString();
        this.password = password;
        log.info(email);
        log.info(password);
        User user = new User("juan", "lozano", email,
                password);
        signupPage.setFormFields(user.getFirstName() , user.getLastName(), user.getEmail(),
                user.getPassword());
        MainPage mainPage = signupPage.clickSignUpButton();
        mainPage.clickLogoutButton();
    }

    /**
     * Delete the account created
     */
    @AfterClass
    public void afterClass(){

    }

    private String generateRandomString(){
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int lengthOfString = 6;
        for(int i = 0; i < lengthOfString; i++){
            int index = random.nextInt(alphabet.length());
            char randomChar = alphabet.charAt(index);
            sb.append(randomChar);
        }
        int randomNumber = random.nextInt(10);
        sb.append(randomNumber); // We need a number to complete password requirements

        return sb.toString();
    }

    private String generateRandomEmail(){
        email = generateRandomString();
        return email + "@gmail.com";
    }
}
