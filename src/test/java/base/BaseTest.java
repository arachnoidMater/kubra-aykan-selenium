package base;

import utils.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = Driver.getDriver();
    }

    @AfterMethod
    public void teardown() {
        Driver.quitDriver();
    }
}
