package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;
import utilities.PropertiesConfig;

public class LoginTest extends Hooks {
    private static LoginPage login;
    private static InventoryPage home;
    private static String errorMsg;

    @BeforeMethod
    public void testInit() {
        login = new LoginPage(driver);
        home = new InventoryPage(driver);
    }

    @Test(groups = {"smoketest"})
    public void ValidLogin() {
        driver.get(PropertiesConfig.URL);
        login.login(PropertiesConfig.VALID_USER, PropertiesConfig.VALID_PASSWORD);
        home.logOut();
        Assert.assertTrue(login.formIsDisplayed());
    }

    @Test
    public void IncorrectLogin() {
        driver.get(PropertiesConfig.URL);
        login.login("", "");
        errorMsg = login.getErrorMsgText();
        Assert.assertEquals(errorMsg, "Epic sadface: Username is required");
    }
}
