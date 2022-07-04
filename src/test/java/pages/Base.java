package pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Base {
    protected final WebDriver driver;

    public Base(WebDriver driver) {
        this.driver = driver;
    }

    protected abstract void waitForPageLoad();

    public static void waitForElementIsVisible(WebDriver driver, WebElement element) throws TimeoutException {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception ex) {
            throw new TimeoutException("Timeout exceeded while waiting for element: " + element);
        }
    }
}
