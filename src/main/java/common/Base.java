package common;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Base {
    protected WebDriver driver;

    public Base(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static void waitForElementIsVisible(WebDriver driver, WebElement element) throws TimeoutException {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch(Exception ex){
            throw new TimeoutException("Timeout exceeded while waiting for element: " + element);
        }
    }
}
