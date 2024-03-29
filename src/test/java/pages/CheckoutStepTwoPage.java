package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * CheckoutStepTwoPage Class models the "Checkout: Overview" Page.
 * It defines the Page Variables, WebElements and Page Methods.
 *
 * @lastmodifier Cecilia Ocampo
 */
public class CheckoutStepTwoPage extends Base {
    public CheckoutStepTwoPage(WebDriver driver) {
        super(driver);
    }

    private WebElement pageTitle() {
        return driver.findElement(By.xpath("//span[text() = 'Checkout: Overview']"));
    }

    private WebElement finishButton() {
        return driver.findElement(By.id("finish"));
    }

    public WebElement getInventoryItem(String itemInventoryName) {
        return driver.findElement(By.xpath("//div[@class = 'cart_item'][.//div[text() = '" + itemInventoryName + "']]"));
    }

    public void waitUntilPageIsLoaded() {
        waitForElementVisibility(pageTitle());
    }

    public String getItemDescription(WebElement item) {
        return item.findElement(By.className("inventory_item_desc")).getText();
    }

    public String getItemPrice(WebElement item) {
        return item.findElement(By.className("inventory_item_price")).getText();
    }

    public void clickFinish() {
        finishButton().click();
    }
}
