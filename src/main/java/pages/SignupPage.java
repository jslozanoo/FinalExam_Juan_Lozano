package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Page to create an account
 */
public class SignupPage extends BasePage {

    @FindBy(id = "did-ui-view")
    private WebElement signupFormContainer;
    @FindBy(name = "firstName")
    private WebElement firstNameField;
    @FindBy(name = "lastName")
    private WebElement lastNameField;
    @FindBy(name = "email")
    private WebElement emailField;
    @FindBy(name = "newPassword")
    private WebElement passwordField;
    @FindBy(css = ".btn.btn")
    private WebElement signupButton;

    /**
     * Constructor
     * @param driver
     */
    public SignupPage(WebDriver driver){
        super(driver);
    }

    /**
     * Set Form in each field. No need to wait visibility of 4 elements.
     * @param firstName
     * @param lastName
     * @param email
     * @param password
     */
    public void setFormFields(String firstName, String lastName, String email, String password){
        waitElementVisibility(firstNameField);
        firstNameField.sendKeys(firstName);
        waitElementVisibility(lastNameField);
        lastNameField.sendKeys(lastName);
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
    }

    /**
     * Click signup button
     */
    public MainPage clickSignUpButton(){
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        waitElementToBeClickable(signupButton);
        signupButton.click();
        getWait().until(ExpectedConditions.invisibilityOfElementLocated(By.id("disneyid-iframe")));
        // getDriver().switchTo().defaultContent();
        return new MainPage(getDriver());
    }
}
