package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;
import pages.MenuSection;
import utils.PropertiesConfig;

public class InventoryTest extends BaseTest {
    private LoginPage login;
    private InventoryPage home;
    private MenuSection menu;

    @BeforeMethod
    public void testInit() {
        login = new LoginPage(driver);
        home = new InventoryPage(driver);
        menu = new MenuSection(driver);
    }

    @Test
    public void sortProducts() {
        driver.get(PropertiesConfig.URL);
        login.login(PropertiesConfig.VALID_USER, PropertiesConfig.VALID_PASSWORD);
        home.waitUntilPageIsLoaded();
        home.sortByValue(PropertiesConfig.SORT);
        //TODO Assert
    }

    @Test
    public void validate_add_to_cart(){
        driver.get(PropertiesConfig.URL);
        login.login(PropertiesConfig.VALID_USER, PropertiesConfig.VALID_PASSWORD);
        home.waitUntilPageIsLoaded();
        menu.waitForMenuVisibility();
        menu.resetApp();
        menu.waitForMenuToBeClosed();
        home.addBackpackToCart();
    }
}
