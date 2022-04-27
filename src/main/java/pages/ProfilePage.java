package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProfilePage extends BasePage{

    @FindBy(id = "disneyid-iframe")
    private WebElement profileFrame;

    @FindBy(id = "cancel-account")
    private WebElement deleteAccountLink;
    @FindBy(css = "section.main button:first-of-type")
    private WebElement confirmDeleteAccountButton;
    @FindBy(css = "section.workflow h2")
    private WebElement interfaceTitle;
    @FindBy(css = "section .section-password h3")
    private WebElement changePasswordTitle;

    @FindBy(css = "div.block p")
    private WebElement confirmDeleteAccountParagraph;

    public ProfilePage(WebDriver driver){
        super(driver);
    }

    /**
     * Get Main title (not the page title) of the interface displayed
     * @return
     */
    public String getPageMainTitle(){
        waitElementVisibility(interfaceTitle);
        return interfaceTitle.getText();
    }

    /**
     * Get change password title in the interface
     * @return
     */
    public String getChangePasswordTitle(){
        waitElementVisibility(changePasswordTitle);
        return changePasswordTitle.getText();
    }

    /**
     * Click delete account link
     */
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

    /**
     * Click confirm delete account button
     */
    public void clickConfirmDeleteAccount(){
        waitElementToBeClickable(confirmDeleteAccountButton);
        confirmDeleteAccountButton.click();
    }
}
