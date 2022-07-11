package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MenuSection extends Base{

    public MenuSection(WebDriver driver) {
        super(driver);
    }

    private WebElement burgerMenu() {
        return driver.findElement(By.id("react-burger-menu-btn"));
    }

    private WebElement logout() {
        return driver.findElement(By.id("logout_sidebar_link"));
    }

    private WebElement resetAppState() {return driver.findElement(By.id("reset_sidebar_link"));}

    public void waitForMenuVisibility(){
        waitForElementVisibility(burgerMenu());
    }

    public void waitForMenuToBeClosed(){
        waitForElementInvisibility(logout());
    }

    public void logOut() {
        waitForMenuVisibility();
        burgerMenu().click();
        waitForElementVisibility(logout());
        logout().click();
    }

    public void resetApp(){
        waitForMenuVisibility();
        burgerMenu().click();
        waitForElementVisibility(resetAppState());
        resetAppState().click();
        driver.navigate().refresh();
    }
}
