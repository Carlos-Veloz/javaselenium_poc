package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * YourCart Class models the YourCart page from SauceDemo website.
 * It defines the Page Variables, WebElements and Page Methods.
 *
 * @lastmodifier Cecilia Ocampo
 */
public class YourCartPage extends Base {
    public YourCartPage(WebDriver driver) {
        super(driver);
    }

    private WebElement shoppingCartBadge() {
        return driver.findElement(By.className("shopping_cart_badge"));
    }

    private WebElement shoppingCartLink() {
        return driver.findElement(By.id("shopping_cart_container"));
    }

    private WebElement shoppingCartContainer() {
        return driver.findElement(By.id("cart_contents_container"));
    }

    private WebElement checkoutButton() {
        return driver.findElement(By.id("checkout"));
    }

    public WebElement getCartItem(String itemName) {
        return driver.findElement(By.xpath("//div[@class = 'cart_item'][.//div[text() = '" + itemName + "']]"));
    }


    public boolean isOneProductAddedToCart() {
        String numberOfItemsInShoppingCart = "1";
        return shoppingCartBadge().getText().equals(numberOfItemsInShoppingCart);
    }

    public void clickShoppingCartLink() {
        shoppingCartLink().click();
    }

    public void waitUntilPageIsLoaded() {
        waitForElementVisibility(shoppingCartContainer());
    }

    public String getItemDescription(WebElement item) {
        return item.findElement(By.className("inventory_item_desc")).getText();
    }

    public String getItemPrice(WebElement item) {
        return item.findElement(By.className("inventory_item_price")).getText();
    }

    public void clickCheckoutButton() {
        checkoutButton().click();
    }
}
