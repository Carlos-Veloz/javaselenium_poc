package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutCompletePage extends Base {
    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    private WebElement pageTitle() {
        return driver.findElement(By.xpath("//span[text() = 'Checkout: Complete!']"));
    }

    private WebElement pageHeader() {
        return driver.findElement(By.className("complete-header"));
    }

    public void waitUntilPageIsLoaded() {
        waitForElementVisibility(pageTitle());
    }

    public String getHeaderText() {
        return pageHeader().getText();
    }

}
