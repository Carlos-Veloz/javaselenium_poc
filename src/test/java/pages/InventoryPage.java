package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.NoSuchElementException;

public class InventoryPage extends Base {

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    private WebElement inventoryContainer() {
        return driver.findElement(By.id("inventory_container"));
    }

    private WebElement addBackpackToCartButton() {
        return driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
    }

    private WebElement removeBackpackButton() {
        return driver.findElement(By.id("remove-sauce-labs-backpack"));
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

    public WebElement getItem(String itemName) { return driver.findElement(By.xpath("//div[@class = 'inventory_item'][.//div[text() = '"+itemName+"']]")); }

    public void waitUntilPageIsLoaded() {
        waitForElementVisibility(inventoryContainer());
    }

    public boolean isInventoryPageVisible() {
        return inventoryContainer().isDisplayed();
    }

    public void addBackpackToCart() {
        WebElement addBackpackToCartButton = addBackpackToCartButton();
        addBackpackToCartButton.click();
        waitForElementInvisibility(addBackpackToCartButton);
    }

    public boolean isRemoveBackpackButtonVisible() {
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

    public String getItemDescription(WebElement item) {
        return item.findElement(By.className("inventory_item_desc")).getText();
    }

    public String getItemPrice(WebElement item) {
        return item.findElement(By.className("inventory_item_price")).getText();
    }

    public String getItemImage(WebElement item) {
        return item.findElement(By.tagName("img")).getAttribute("alt");
    }
}
