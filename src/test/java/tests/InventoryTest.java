package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;
import utilities.PropertiesConfig;

public class InventoryTest extends Hooks {

    @Test
    public void sortProducts(){
        driver = new ChromeDriver();
        driver.get(PropertiesConfig.URL);
        LoginPage login = new LoginPage(driver);
        login.login(PropertiesConfig.VALID_USER, PropertiesConfig.VALID_PASSWORD);
        InventoryPage home = new InventoryPage(driver);
        home.waitUntilPageIsLoaded();
        home.sortByValue(PropertiesConfig.SORT);
    }
}
