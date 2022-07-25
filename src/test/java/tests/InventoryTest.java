package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.InventoryPage;
import pages.LoginPage;
import pages.MenuSection;
import pages.YourCart;
import utils.PropertiesConfig;

/**
 * This class contains the test that validate the Inventory page.
 *
 * @lastmodifier Cecilia Ocampo
 */
public class InventoryTest extends BaseTest {
    private SoftAssert softAssert;
    private LoginPage login;
    private InventoryPage home;
    private MenuSection menu;
    private YourCart yourCart;

    @BeforeMethod
    public void testInit() {
        softAssert = new SoftAssert();
        login = new LoginPage(driver);
        home = new InventoryPage(driver);
        menu = new MenuSection(driver);
        yourCart = new YourCart(driver);
        driver.get(PropertiesConfig.URL);
    }

    @Test(groups = {"smoketest"})
    public void validate_add_to_cart() {
        login.login(PropertiesConfig.VALID_USER, PropertiesConfig.VALID_PASSWORD);
        home.waitUntilPageIsLoaded();
        menu.resetApp();
        home.addBackpackToCart();
        softAssert.assertTrue(home.isRemoveBackpackButtonVisible());
        softAssert.assertTrue(yourCart.isOneProductAddedToCart());
        softAssert.assertAll();
    }

    @Test(groups = {"smoketest"})
    public void validate_item_details() {
        //TODO Add to data provider
        String itemName = "Sauce Labs Backpack";
        String itemDescription = "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.";
        String itemPrice = "$29.99";
        String itemImage = "Sauce Labs Backpack";
        WebElement item;
        login.login(PropertiesConfig.VALID_USER, PropertiesConfig.VALID_PASSWORD);
        home.waitUntilPageIsLoaded();
        menu.resetApp();
        item = home.getItem(itemName);
        softAssert.assertEquals(home.getItemDescription(item), itemDescription);
        softAssert.assertEquals(home.getItemPrice(item), itemPrice);
        softAssert.assertEquals(home.getItemImage(item), itemImage);
        softAssert.assertAll();
    }
}
