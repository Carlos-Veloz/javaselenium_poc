package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;
import utilities.PropertiesConfig;

public class LoginTest extends Hooks{

    @Test
    public void ValidLogin() {
        driver = new ChromeDriver();
        driver.get(PropertiesConfig.URL);
        LoginPage login = new LoginPage(driver);
        login.login(PropertiesConfig.VALID_USER, PropertiesConfig.VALID_PASSWORD);
        InventoryPage home = new InventoryPage(driver);
        home.logOut();
        Assert.assertTrue(login.formIsDisplayed());
    }

    @Test
    public void IncorrectLogin() {
        driver = new ChromeDriver();
        driver.get(PropertiesConfig.URL);
        LoginPage login = new LoginPage(driver);
        login.login("","");
        String errorMsg = login.getErrorMsgText();
        Assert.assertEquals(errorMsg, "Epic sadface: Username is required");
    }
}
