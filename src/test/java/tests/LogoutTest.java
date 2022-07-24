package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MenuSection;
import utils.PropertiesConfig;

/**
 * This class contains the test cases related to Logout.
 *
 * @lastmodifier Cecilia Ocampo
 */
public class LogoutTest extends BaseTest {
    private LoginPage login;
    private MenuSection menu;

    @BeforeMethod
    public void testInit() {
        login = new LoginPage(driver);
        menu = new MenuSection(driver);
        driver.get(PropertiesConfig.URL);
    }

    @Test(groups = {"smoketest"})
    public void logOut() {
        login.login(PropertiesConfig.VALID_USER, PropertiesConfig.VALID_PASSWORD);
        menu.logOut();
        Assert.assertTrue(login.formIsDisplayed());
    }

}
