package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Home Page with user logged
 */
public class MainPage extends BasePage {
    @FindBy(id = "disneyid-iframe")
    private WebElement profileFrame;

    @FindBy(id = "global-user-trigger")
    private WebElement dropdownMainMenuButton;

    @FindBy(css = ".global-user[style]")
    private WebElement dropdownMainMenuContainer; //To find this, the container must be displayed

    @FindBy(css = ".global-user[style] div ul:first-child li:first-child")
    private WebElement dropdownMainMenuTitle;

    @FindBy(css = ".global-user[style] li:nth-child(5) a")
    private WebElement profileButton;

    public MainPage(WebDriver driver){
        super(driver);
    }

    /**
     * Click main menu to display login container
     */
    public void clickDropdownMenuButton(){
        waitElementToBeClickable(dropdownMainMenuButton);
        dropdownMainMenuButton.click();
        waitElementVisibility(dropdownMainMenuContainer);
    }

    /**
     * Switch to iframe profile interface
     * @param profileFrame
     */
    public void switchToProfileFrame(WebElement profileFrame){
        getDriver().switchTo().frame(profileFrame);
    }

    public ProfilePage clickProfileButton(){
        clickDropdownMenuButton();
        waitElementToBeClickable(profileButton);
        profileButton.click();
        switchToProfileFrame(profileFrame);

        return new ProfilePage(getDriver());
    }
}
