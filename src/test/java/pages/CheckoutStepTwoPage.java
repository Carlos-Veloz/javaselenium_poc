package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutStepTwoPage extends Base {
    public CheckoutStepTwoPage(WebDriver driver) {
        super(driver);
    }

    private WebElement pageTitle() {
        return driver.findElement(By.xpath("//span[text() = 'Checkout: Overview']"));
    }

    public WebElement getInventoryItem(String itemInventoryName) {
        return driver.findElement(By.xpath("//div[@class = 'cart_item'][.//div[text() = '" + itemInventoryName + "']]"));
    }

    public WebElement finishButton() {
        return driver.findElement(By.id("finish"));
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
