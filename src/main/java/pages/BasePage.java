package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    private WebDriver driver;
    private WebDriverWait wait;
    public Logger log = Logger.getLogger(BasePage.class);

    public BasePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 15);
        this.driver = driver;
    }

    public void waitElementVisibility(WebElement element){
        getWait().until(ExpectedConditions.visibilityOf(element));
    }

    public void waitElementToBeClickable(WebElement element){
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }
}
