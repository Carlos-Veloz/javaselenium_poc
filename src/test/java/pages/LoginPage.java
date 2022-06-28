package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Objects;

public class LoginPage extends Base {
    @FindBy(id = "user-name")
    WebElement userNameInput;

    @FindBy(id = "password")
    WebElement passwordInput;

    @FindBy(id = "login-button")
    WebElement loginButton;

    @FindBy(css = ".error-message-container")
    WebElement errorMessage;

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void login(String username, String pwd){
        userNameInput.sendKeys(username);
        passwordInput.sendKeys((pwd));
        loginButton.click();
    }

    public String getErrorMsgText(){
        Base.waitForElementIsVisible(driver, errorMessage);
        String text = errorMessage.getText();
        if (Objects.nonNull(text)) {
            return text.trim();
        }
        return "";
    }

    public boolean formIsDisplayed(){
        try{
            Base.waitForElementIsVisible(driver, userNameInput);
            return true;
        } catch (Exception ex) {
            throw new RuntimeException("Timeout exceeded while waiting for login page to load");
        }
    }
}
