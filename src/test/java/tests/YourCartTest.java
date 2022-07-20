package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import pages.*;
import utils.PropertiesConfig;

public class YourCartTest extends BaseTest{
    private Assertion asserts;
    private LoginPage login;
    private InventoryPage home;
    private MenuSection menu;
    private YourCart yourCart;

    @BeforeMethod
    public void testInit() {
        asserts = new Assertion();
        login = new LoginPage(driver);
        home = new InventoryPage(driver);
        menu = new MenuSection(driver);
        yourCart = new YourCart(driver);

    }

    @Test(groups = {"smoketest"})
    public void validate_product_in_cart(){
        driver.get(PropertiesConfig.URL);
        login.login(PropertiesConfig.VALID_USER, PropertiesConfig.VALID_PASSWORD);
        home.waitUntilPageIsLoaded();
        menu.resetApp();
        home.addBackpackToCart();
        yourCart.clickShoppingCartLink();
        yourCart.waitUntilPageIsLoaded();

    }
}
