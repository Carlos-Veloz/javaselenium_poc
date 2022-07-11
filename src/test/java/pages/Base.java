package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PropertiesConfig;

public abstract class Base {
    protected final WebDriver driver;
    protected WebDriverWait wait;

    public Base(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, PropertiesConfig.WAIT_TIME);
    }

    public void waitForElementVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementInvisibility(WebElement element) {
        wait.until(ExpectedConditions.invisibilityOf(element));
    }
}