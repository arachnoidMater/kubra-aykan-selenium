package tests;

import base.BaseTest;
import pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    private HomePage homePage;

    @Test
    public void testHomePageIsDisplayed() {
        homePage = new HomePage(driver);
        homePage.openHomePage();
        Assert.assertTrue(homePage.isHomePageDisplayed(), "Home Page is NOT displayed!");
    }
}
