package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


/**
 * home page
 */
public class HomePage extends BasePage{

    @FindBy(id = "disneyid-iframe")
    private WebElement loginFrame;

    @FindBy(id = "global-user-trigger")
    private WebElement dropdownMainMenuButton;

    @FindBy(css = ".global-user[style]")
    private WebElement dropdownMainMenuContainer; //To find this, the container must be displayed

    @FindBy(css = ".global-user[style] div ul:first-child li:first-child")
    private WebElement dropdownMainMenuTitle;

    @FindBy(css = ".global-user[style] a[data-regformid]")
    private WebElement dropdownMainMenuLoginButton;

    /**
     * Constructor
     * @param driver
     */
    public HomePage(WebDriver driver){
        super(driver);
    }

    /**
     * Click main menu to display login container
     */
    public void clickDropdownMenu(){
        getWait().until(ExpectedConditions.elementToBeClickable(dropdownMainMenuButton));
        dropdownMainMenuButton.click();
        getWait().until(ExpectedConditions.visibilityOf(dropdownMainMenuContainer));
    }

    /**
     * Get title on main menu container
     * @return
     */
    public String getMainContainerTitle(){
        clickDropdownMenu();
        return dropdownMainMenuTitle.getText();
    }

    /**
     * True if the user is logged, false if not
     * @return
     */
    public boolean isLogged(){
        return !(getMainContainerTitle().equals("Welcome"));
    }

    /**
     * Switch to iframe for login
     * @param loginFrame
     */
    public void switchToLoginFrame(WebElement loginFrame){
        getDriver().switchTo().frame(loginFrame);
    }

    /**
     * Click on login button to display login form
     * @return LoginPage instance
     */
    public LoginPage clickLoginButton(){
        clickDropdownMenu();
        getWait().until(ExpectedConditions.elementToBeClickable(dropdownMainMenuLoginButton));
        dropdownMainMenuLoginButton.click();
        switchToLoginFrame(loginFrame);

        return new LoginPage(getDriver());
    }
}
