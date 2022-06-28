package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.NoSuchElementException;

public class InventoryPage extends Base {
    @FindBy(id = "inventory_container")
    WebElement invContainer;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement backpack;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    WebElement bikeLight;

    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    WebElement tshirt;

    @FindBy(css = ".product_sort_container")
    WebElement filterDropDown;

    @FindBy(css = "shopping_cart_link")
    WebElement shoppingCart;

    @FindBy(id = "react-burger-menu-btn")
    WebElement burgerMenu;

    @FindBy(id = "logout_sidebar_link")
    WebElement logout;

    public InventoryPage(WebDriver driver){
        super(driver);
    }

    public void waitUntilPageIsLoaded(){
        try{
            Base.waitForElementIsVisible(driver, invContainer);
        } catch (Exception ex) {
            throw new RuntimeException("Timeout exceeded while waiting for inventory page to load");
        }
    }

    public void waitUntilLogoutIsAvailable(){
        try{
            Base.waitForElementIsVisible(driver, logout);
        } catch (Exception ex) {
            throw new RuntimeException("Timeout exceeded ");
        }
    }

    public void logOut(){
        this.waitUntilPageIsLoaded();
        burgerMenu.click();
        this.waitUntilLogoutIsAvailable();
        logout.click();
    }

    public void sortByValue(String value){
        filterDropDown.click();
        Select sortDropdown = new Select(filterDropDown);
        try{
            sortDropdown.selectByValue(value);
        } catch (NoSuchElementException noSuchElementException) {
            throw new WebDriverException(String.format("Error while trying to sort elements"), noSuchElementException);
        }
    }
}
