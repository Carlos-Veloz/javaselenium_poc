import common.DataProviderReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;

public class LoginTest {
    private WebDriver driver;
    DataProviderReader reader = DataProviderReader.getInstance();

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void ValidLogin() {
        driver = new ChromeDriver();
        driver.get(reader.getValue("url"));
        LoginPage login = new LoginPage(driver);
        login.login(reader.getValue("valid.username"), reader.getValue("valid.pwd"));
        InventoryPage home = new InventoryPage(driver);
        home.logOut();
        Assert.assertTrue(login.formIsDisplayed());
    }

    @Test
    public void IncorrectLogin() {
        driver = new ChromeDriver();
        driver.get(reader.getValue("url"));
        LoginPage login = new LoginPage(driver);
        login.login("","");
        String errorMsg = login.getErrorMsgText();
        Assert.assertEquals(errorMsg, "Epic sadface: Username is required");
    }
}
