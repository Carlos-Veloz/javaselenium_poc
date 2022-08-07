package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;
import pages.InventoryPage;
import pages.LoginPage;
import pages.MenuSection;
import pages.YourCartPage;
import utils.PropertiesConfig;
import utils.data.DataProviderReader;

/**
 * This class contains the test cases related to the Cart feature.
 *
 * @lastmodifier Cecilia Ocampo
 */
public class YourCartTest extends BaseTest {
    private SoftAssert softAssert;
    private Assertion asserts;
    private LoginPage login;
    private InventoryPage home;
    private MenuSection menu;
    private YourCartPage yourCart;

    @BeforeMethod
    public void testInit() {
        softAssert = new SoftAssert();
        asserts = new Assertion();
        login = new LoginPage(driver);
        home = new InventoryPage(driver);
        menu = new MenuSection(driver);
        yourCart = new YourCartPage(driver);

    }

    @Test(groups = {"smoketest"}, dataProvider = "product-provider", dataProviderClass = DataProviderReader.class)
    public void validate_product_in_cart(String itemName, String itemDescription, String itemPrice) {
        WebElement item;
        driver.get(PropertiesConfig.URL);
        login.login(PropertiesConfig.VALID_USER, PropertiesConfig.VALID_PASSWORD);
        home.waitUntilPageIsLoaded();
        menu.resetApp();
        home.addBackpackToCart();
        yourCart.clickShoppingCartLink();
        yourCart.waitUntilPageIsLoaded();
        item = yourCart.getCartItem(itemName);
        softAssert.assertEquals(yourCart.getItemDescription(item), itemDescription);
        softAssert.assertEquals(yourCart.getItemPrice(item), itemPrice);
        softAssert.assertAll();
    }
}
