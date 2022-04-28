package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

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

    @FindBy(css = ".block p a")
    private WebElement paragraphLink; // Only element that is not repeated in both interfaces

    public ProfilePage(WebDriver driver){
        super(driver);
    }

    /**
     * Get Main title (not the page title) of the interface displayed
     * @return
     */
    public String getMainTitlePage(){
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
     * Get text in link in the paragraph in delete account confirm interface
     * @return
     */
    public String getTextInLinkConfirmDeleteAccount(){
        waitElementVisibility(paragraphLink);
        return paragraphLink.getText();
    }

    /**
     * Click delete account link
     */
    public void clickToDeleteAccountLink(){
        try{
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
            deleteAccountLink.click();
        }catch (Exception e){ // To manage staleElementReferenceException
            WebElement deleteAccountLink = getDriver().findElement(By.id("cancel-account"));
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
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
