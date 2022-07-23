package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutStepOnePage extends Base {

    public CheckoutStepOnePage(WebDriver driver) {
        super(driver);
    }

    private WebElement title() { return driver.findElement(By.className("title")); }
    private WebElement firstnameField() { return driver.findElement(By.id("first-name")); }
    private WebElement lastnameField() { return driver.findElement(By.id("last-name")); }
    private WebElement postalCodeField() { return driver.findElement(By.id("postal-code")); }
    private WebElement continueButton(){ return driver.findElement(By.id("continue")); }

    public void waitUntilPageIsLoaded() {
        waitForElementVisibility(title());
    }

    public void fillYourInformationForm (String firstname, String lastname, String postalCode) {
        writeText(firstnameField(), firstname);
        writeText(lastnameField(), lastname);
        writeText(postalCodeField(), postalCode);
    }


}
