import common.DataProviderReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;

public class InventoryTest {
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
    public void sortProducts(){
        driver = new ChromeDriver();
        driver.get(reader.getValue("url"));
        LoginPage login = new LoginPage(driver);
        login.login(reader.getValue("valid.username"), reader.getValue("valid.pwd"));
        InventoryPage home = new InventoryPage(driver);
        home.waitUntilPageIsLoaded();
        home.sortByValue(reader.getValue("sort.LoToHi"));
    }
}
