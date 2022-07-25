package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * InventoryPage Class models the Inventory page from SauceDemo website.
 * It defines the Page Variables, WebElements and Page Methods.
 *
 * @lastmodifier Cecilia Ocampo
 */
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

    public WebElement getItem(String itemName) {
        return driver.findElement(By.xpath("//div[@class = 'inventory_item'][.//div[text() = '" + itemName + "']]"));
    }

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
