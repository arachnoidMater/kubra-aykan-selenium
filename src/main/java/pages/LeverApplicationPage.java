package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PropertiesUtils;

import java.time.Duration;

public class LeverApplicationPage {

    private WebDriver driver;

    @FindBy(xpath = "//a[@id='wt-cli-reject-btn']")
    private WebElement declineToCookies;

    @FindBy(xpath = "(//div[@class='position-list-item-wrapper bg-light'])[1]")
    private WebElement jobTitleElement;

    @FindBy(xpath = "(//a[contains(text(),'View Role')])[1]")
    private WebElement viewRoleButton;

    public LeverApplicationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openJobsPositionsPage() {
        driver.get(PropertiesUtils.getProperty("qaJobsPositionPageUrl"));
    }

    public void declineToCookies() {
        if (declineToCookies.isDisplayed()) {
            declineToCookies.click();
        }
    }

    public void scrollToJobTitles() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,600)");

    }

    public void hoverOverJobTitle() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(jobTitleElement));

        Actions actions = new Actions(driver);
        actions.moveToElement(jobTitleElement).perform();
    }

    public void clickViewRoleButton() {

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        viewRoleButton.click();
    }

    public boolean isLeverApplicationPageDisplayed() {
        return driver.getCurrentUrl().contains("lever");
    }
}
