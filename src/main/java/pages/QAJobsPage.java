package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import java.time.Duration;
import java.util.List;
import utils.PropertiesUtils;

public class QAJobsPage {
    private WebDriver driver;

    @FindBy(xpath = "//a[@id='wt-cli-reject-btn']")
    private WebElement declineToCookies;

    @FindBy(xpath = "//div[@class='button-group d-flex flex-row']")
    private WebElement seeAllQAJobsButton;

    @FindBy(xpath = "//span[@id='select2-filter-by-location-container']")
    private WebElement locationDropdown;

    @FindBy(xpath = "//li[contains(text(),'Istanbul, Turkiye')]")
    private WebElement selectLocation;

    @FindBy(xpath = "//span[@id='select2-filter-by-department-container']")
    private WebElement departmentDropdown;

    @FindBy(xpath = "//li[contains(text(),'Quality Assurance')]")
    private WebElement selectDepartment;

    @FindBy (xpath = "(//p[@class='position-title font-weight-bold'])[1]")
    private WebElement jobTitlesHeader;

    @FindBy(xpath = "//p[@class='position-title font-weight-bold']")
    private List<WebElement> jobTitle;

    @FindBy(xpath = "//div[@class='position-location text-large']")
    private List<WebElement> jobLocation;

    @FindBy(xpath = "//span[@class='position-department text-large font-weight-600 text-primary']")
    private  List<WebElement> jobDepartment;

    public QAJobsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void declineToCookies() {
        if (declineToCookies.isDisplayed()) {
            declineToCookies.click();
        }
    }

    public void openQAJobsPage() {
        driver.get(PropertiesUtils.getProperty("qaJobsPageUrl"));
    }

    public void clickSeeAllQAJobs() {
        seeAllQAJobsButton.click();
    }

    public void waitForPageLoad() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.jsReturnsValue("return document.readyState == 'complete';"));
    }

    public void clickJobLocation(){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        locationDropdown.click();
        selectLocation.click();
    }

    public void clickJobDepartment(){
        departmentDropdown.click();
        selectDepartment.click();
    }

    public void scrollToJobTitles() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,770)");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean areJobDetailsCorrect() {
        for (WebElement jobTitle : jobTitle) {
            if (!jobTitle.getText().contains("Software")) {
                return false;
            }
        }
        for (WebElement jobLocation : jobLocation) {
            if (!jobLocation.getText().contains("Istanbul, Turkiye")) {
                return false;
            }
        }
        for (WebElement jobDepartment : jobDepartment) {
            if (!jobDepartment.getText().contains("Quality Assurance")) {
                return false;
            }
        }
        return true;
    }

    

}
