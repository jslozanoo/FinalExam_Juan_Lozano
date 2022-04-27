package com.automation.web.tests;

import driver.Driver;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import pages.HomePage;

public class LoginTest {
    Driver driver;

    private HomePage homePage;
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
}
