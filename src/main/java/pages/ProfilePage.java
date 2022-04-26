package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasePage{

    @FindBy(id = "cancel-account")
    private WebElement deleteAccountLink;
    @FindBy(css = "section.main button:first-of-type")
    private WebElement confirmDeleteAccountButton;

    public ProfilePage(WebDriver driver){
        super(driver);
    }

    public void clickToDeleteAccountLink(){
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        waitElementToBeClickable(deleteAccountLink);
        deleteAccountLink.click();
    }

    public void clickConfirmDeleteAccount(){
        waitElementToBeClickable(confirmDeleteAccountButton);
        // After delete appears an alert
    }
}
