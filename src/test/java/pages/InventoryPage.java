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

    private WebElement addBackpackToCartButton() {
        return driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
    }

    private WebElement removeBackpackButton(){
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

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public void waitUntilPageIsLoaded() {
        waitForElementVisibility(inventoryContainer());
    }

    public boolean isInventoryPageVisible(){
        return inventoryContainer().isDisplayed();
    }

    public void addBackpackToCart(){
        addBackpackToCartButton().click();
    }

    public boolean isRemoveBackpackButtonVisible(){
       return removeBackpackButton().isDisplayed();
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
