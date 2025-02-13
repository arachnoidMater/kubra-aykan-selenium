package tests;

import base.BaseTest;
import pages.LeverApplicationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LeverApplicationPageTest extends BaseTest {
    private LeverApplicationPage leverApplicationPage;

    @Test
    public void testViewRoleRedirection() {
        leverApplicationPage = new LeverApplicationPage(driver);
        leverApplicationPage.openJobsPositionsPage();
        leverApplicationPage.declineToCookies();
        leverApplicationPage.scrollToJobTitles();
        leverApplicationPage.hoverOverJobTitle();
        leverApplicationPage.clickViewRoleButton();
        Assert.assertTrue(leverApplicationPage.isLeverApplicationPageDisplayed(), "The application form page is NOT displayed!");
    }
}
