package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasePage{

    @FindBy(id = "disneyid-iframe")
    private WebElement profileFrame;

    @FindBy(id = "cancel-account")
    private WebElement deleteAccountLink;
    @FindBy(css = "section.main button:first-of-type")
    private WebElement confirmDeleteAccountButton;

    public ProfilePage(WebDriver driver){
        super(driver);
    }

    public void clickToDeleteAccountLink(){
        try{
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
            waitElementToBeClickable(deleteAccountLink);
            deleteAccountLink.click();
        }catch (Exception e){ // To manage staleElementReferenceException
            WebElement deleteAccountLink = getDriver().findElement(By.id("cancel-account"));
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
            waitElementToBeClickable(deleteAccountLink);
            deleteAccountLink.click();
        }
    }

    public void clickConfirmDeleteAccount(){
        waitElementToBeClickable(confirmDeleteAccountButton);
        confirmDeleteAccountButton.click();
        // After delete appears an alert
    }
}
