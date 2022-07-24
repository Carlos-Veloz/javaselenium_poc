package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;
import pages.*;
import utils.PropertiesConfig;

public class CheckoutTest extends BaseTest {
    private SoftAssert softAssert;
    private Assertion asserts;
    private LoginPage login;
    private InventoryPage home;
    private MenuSection menu;
    private YourCart yourCart;
    private CheckoutStepOnePage yourInformation;
    private CheckoutStepTwoPage overview;

    @BeforeMethod
    public void testInit() {
        softAssert = new SoftAssert();
        asserts = new Assertion();
        login = new LoginPage(driver);
        home = new InventoryPage(driver);
        menu = new MenuSection(driver);
        yourCart = new YourCart(driver);
        yourInformation = new CheckoutStepOnePage(driver);
        overview = new CheckoutStepTwoPage(driver);
        driver.get(PropertiesConfig.URL);
        login.login(PropertiesConfig.VALID_USER, PropertiesConfig.VALID_PASSWORD);

    }

    @Test(groups = {"smoketest"})
    public void validate_item_at_checkout() {
        String itemName = "Sauce Labs Backpack";
        String itemDescription = "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.";
        String itemPrice = "$29.99";
        WebElement item;
        home.waitUntilPageIsLoaded();
        menu.resetApp();
        home.addBackpackToCart();
        yourCart.clickShoppingCartLink();
        yourCart.waitUntilPageIsLoaded();
        yourCart.clickCheckoutButton();
        yourInformation.waitUntilPageIsLoaded();
        yourInformation.fillYourInformationForm("Juan", "Lopez", "244545");
        yourInformation.clickContinueButton();
        overview.waitUntilPageIsLoaded();
        item = overview.getInventoryItem(itemName);
        softAssert.assertEquals(overview.getItemDescription(item), itemDescription);
        softAssert.assertEquals(overview.getItemPrice(item), itemPrice);
        softAssert.assertAll();

    }
}
