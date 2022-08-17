package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
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

    @BeforeMethod
    public void testInit() {
        login = new LoginPage(driver);
        home = new InventoryPage(driver);
        driver.get(PropertiesConfig.URL);
    }

    @Test(groups = {"smoketest"})
    public void validate_login() {
        login.login(PropertiesConfig.VALID_USER, PropertiesConfig.VALID_PASSWORD);
        Assert.assertTrue(home.isInventoryPageVisible());
    }

    @DataProvider(name = "incorrect_login")
    public Object[][] createData1() {
        return new Object[][] {
                { "", "", "Epic sadface: Username is required" },
                { "Username", "", "Epic sadface: Password is required"},
                { "", "pass", "Epic sadface: Username is required"},
                { "User", "pass", "Epic sadface: Username and password do not match any user in this service"}
        };
    }

    @Test(dataProvider = "incorrect_login")
    public void validate_incorrect_login(String userName, String password, String expectedError) {
        login.login(userName, password);
        String errorMsg = login.getErrorMsgText();
        Assert.assertEquals(errorMsg, expectedError);
    }
}
