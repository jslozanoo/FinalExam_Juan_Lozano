package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page for interface displayed after click login button on main menu. It's an iframe
 */
public class LoginPage extends BasePage{

    @FindBy(css = "form input[type='email']")
    private WebElement emailFieldLoginForm;

    @FindBy(css = "form input[type='password']")
    private WebElement passwordFieldLoginForm;

    @FindBy(css = "form button")
    private WebElement loginButtonLoginForm;

    @FindBy(css = "div.block a")
    private WebElement needHelpText;

    @FindBy(css = "a.btn")
    private WebElement signUpLink;

    public LoginPage(WebDriver driver){
        super(driver);
    }

    /**
     * Send email to input email field
     * @param email
     */
    public void setEmail(String email){
        waitElementVisibility(emailFieldLoginForm);
        emailFieldLoginForm.click();
        emailFieldLoginForm.sendKeys(email);
    }

    /**
     * Send email to input email field
     * @param password
     */
    public void setPassword(String password){
        waitElementVisibility(passwordFieldLoginForm);
        passwordFieldLoginForm.click();
        passwordFieldLoginForm.sendKeys(password);
    }

    /**
     * Click on login button
     * @return
     */
    public MainPage clickLoginButton(){
        loginButtonLoginForm.click();
        return new MainPage(getDriver());
    }

    /**
     * Click on sign up to create an account
     * @return
     */
    public SignupPage clickSignupButton() {
        waitElementToBeClickable(signUpLink);
        signUpLink.click();
        return new SignupPage(getDriver());
    }
}
