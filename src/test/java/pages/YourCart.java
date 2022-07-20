package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class YourCart extends Base{
    public YourCart(WebDriver driver) {
        super(driver);
    }

    private WebElement shoppingCartBadge() {
        return driver.findElement(By.className("shopping_cart_badge"));
    }

    private WebElement shoppingCartLink() { return driver.findElement(By.id("shopping_cart_container")); }

    private WebElement shoppingCartContainer() { return driver.findElement(By.id("cart_contents_container"));}

    public boolean isOneProductAddedToCart(){
        String numberOfItemsInShoppingCart = "1";
        return shoppingCartBadge().getText().equals(numberOfItemsInShoppingCart);
    }

    public void clickShoppingCartLink() {
        shoppingCartLink().click();
    }

    public void waitUntilPageIsLoaded() {
        waitForElementVisibility(shoppingCartContainer());
    }
}
