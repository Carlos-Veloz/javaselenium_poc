package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.NoSuchElementException;

public class InventoryPage extends Base {

    private WebElement inventoryContainer() {
        return driver.findElement(By.id("inventory_container"));
    }

    private WebElement backpack() {
        return driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
    }

    private WebElement bikeLight() {
        return driver.findElement(By.id("add-to-cart-sauce-labs-bike-light"));
    }

    private WebElement tshirt() {
        return driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt"));
    }

    private WebElement filterDropDown() {
        return driver.findElement(By.cssSelector(".product_sort_container"));
    }

    private WebElement shoppingCart() {
        return driver.findElement(By.cssSelector("shopping_cart_link"));
    }

    private WebElement burgerMenu() {
        return driver.findElement(By.id("react-burger-menu-btn"));
    }

    private WebElement logout() {
        return driver.findElement(By.id("logout_sidebar_link"));
    }

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void waitForPageLoad() {

    }

    public void waitUntilPageIsLoaded() {
        try {
            Base.waitForElementIsVisible(driver, inventoryContainer());
        } catch (Exception ex) {
            throw new RuntimeException("Timeout exceeded while waiting for inventory page to load");
        }
    }

    public void waitUntilLogoutIsAvailable() {
        try {
            Base.waitForElementIsVisible(driver, logout());
        } catch (Exception ex) {
            throw new RuntimeException("Timeout exceeded ");
        }
    }

    public void logOut() {
        this.waitUntilPageIsLoaded();
        burgerMenu().click();
        this.waitUntilLogoutIsAvailable();
        logout().click();
    }

    public void sortByValue(String value) {
        filterDropDown().click();
        Select sortDropdown = new Select(filterDropDown());
        try {
            sortDropdown.selectByValue(value);
        } catch (NoSuchElementException noSuchElementException) {
            throw new WebDriverException(String.format("Error while trying to sort elements"), noSuchElementException);
        }
    }
}
