package tests;

import base.BaseTest;
import pages.QAJobsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class QAJobsPageTest extends BaseTest {
    private QAJobsPage qaJobsPage;

    @Test
    public void testJobListingsAreVisible() {
        qaJobsPage = new QAJobsPage(driver);

        qaJobsPage.openQAJobsPage();
        qaJobsPage.declineToCookies();

        qaJobsPage.clickSeeAllQAJobs();
        qaJobsPage.waitForPageLoad();

        qaJobsPage.clickJobLocation();
        qaJobsPage.clickJobDepartment();

        qaJobsPage.scrollToJobTitles();

        Assert.assertTrue(qaJobsPage.areJobDetailsCorrect(), "Job details are incorrect!");
    }
}
