package tests;

import base.BaseTest;
import pages.CareersPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CareersPageTest extends BaseTest {
    private CareersPage careersPage;

    @Test
    public void testCareersPageNavigationAndBlocks() {
        careersPage = new CareersPage(driver);

        careersPage.openHomePage();
        careersPage.declineToCookies();
        careersPage.clickOnCompany();
        careersPage.navigateToCareers();

        Assert.assertTrue(careersPage.isCareerPageDisplayed(), "Careers Page is NOT displayed!");
        Assert.assertTrue(careersPage.areLocationBlock(),"Location Block is NOT displayed!");
        Assert.assertTrue(careersPage.areTeamsBlock(), "Teams Block is NOT displayed!");
        Assert.assertTrue(careersPage.areLifeAtInsiderBlock(),"Life At Insider Block is NOT displayed!");
    }
}
