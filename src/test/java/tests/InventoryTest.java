package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;
import utilities.PropertiesConfig;

public class InventoryTest extends Hooks {
   private static LoginPage login;
   private static InventoryPage home;

   @BeforeMethod
   public void testInit(){
       login = new LoginPage(driver);
       home = new InventoryPage(driver);
   }

    @Test
    public void sortProducts(){
        driver.get(PropertiesConfig.URL);
        login.login(PropertiesConfig.VALID_USER, PropertiesConfig.VALID_PASSWORD);
        home.waitUntilPageIsLoaded();
        home.sortByValue(PropertiesConfig.SORT);
        //TODO Assert
    }
}
