package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;
import utils.PropertiesConfig;

/**
 * This class contains the test cases related to Login.
 *
 * @lastmodifier Cecilia Ocampo
 */
public class LoginTest extends BaseTest {
    private LoginPage login;
    private InventoryPage home;
    private String errorMsg;

    @BeforeMethod
    public void testInit() {
        login = new LoginPage(driver);
        home = new InventoryPage(driver);
        driver.get(PropertiesConfig.URL);
    }

    @Test(groups = {"smoketest"})
    public void ValidLogin() {
        login.login(PropertiesConfig.VALID_USER, PropertiesConfig.VALID_PASSWORD);
        Assert.assertTrue(home.isInventoryPageVisible());
    }

    @Test
    public void IncorrectLogin() {
        login.login("", "");
        errorMsg = login.getErrorMsgText();
        Assert.assertEquals(errorMsg, "Epic sadface: Username is required");
    }
}
