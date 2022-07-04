package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Objects;

public class LoginPage extends Base {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private WebElement userNameInput() {
        return driver.findElement(By.id("user-name"));
    }

    private WebElement passwordInput() {
        return driver.findElement(By.id("password"));
    }

    private WebElement loginButton() {
        return driver.findElement(By.id("login-button"));
    }

    private WebElement errorMessage() {
        return driver.findElement(By.cssSelector(".error-message-container"));
    }


    @Override
    protected void waitForPageLoad() {

    }

    public void login(String username, String pwd) {
        userNameInput().sendKeys(username);
        passwordInput().sendKeys((pwd));
        loginButton().click();
    }

    public String getErrorMsgText() {
        Base.waitForElementIsVisible(driver, errorMessage());
        String text = errorMessage().getText();
        if (Objects.nonNull(text)) {
            return text.trim();
        }
        return "";
    }

    public boolean formIsDisplayed() {
        try {
            Base.waitForElementIsVisible(driver, userNameInput());
            return true;
        } catch (Exception ex) {
            throw new RuntimeException("Timeout exceeded while waiting for login page to load");
        }
    }
}
