package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.PropertiesUtils;

public class CareersPage {
    private WebDriver driver;

    @FindBy(xpath = "//a[@id='wt-cli-reject-btn']")
    private WebElement declineToCookies;

    @FindBy(xpath = "//a[contains(text(),'Company')]")
    private WebElement companyMenu;

    @FindBy(xpath = "//a[contains(text(),'Careers')]")
    private WebElement careersMenu;

    @FindBy(xpath = "//div[@class='col-12 col-lg-6 order-2 order-lg-1']")
    private WebElement careersHeader;

    @FindBy(xpath = "//div[@id='location-slider']")
    private WebElement locationsBlock;

    @FindBy(xpath = "//section[@id='career-find-our-calling']")
    private WebElement teamsBlock;

    @FindBy(xpath = "//div[@class='elementor-swiper']")
    private WebElement lifeAtInsiderBlock;


    public CareersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openHomePage() {
        driver.get(PropertiesUtils.getProperty("homePageUrl"));
    }

    public void declineToCookies() {
        if (declineToCookies.isDisplayed()) {
            declineToCookies.click();
        }
    }

    public void clickOnCompany(){
        companyMenu.click();
    }

    public void navigateToCareers() {
        careersMenu.click();
    }

    public boolean isCareerPageDisplayed() {
        return careersHeader.isDisplayed();

    }

    public boolean areLocationBlock() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,2200)");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return locationsBlock.isDisplayed();

    }

    public boolean areTeamsBlock() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1200)");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return teamsBlock.isDisplayed();
    }

    public boolean areLifeAtInsiderBlock(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return lifeAtInsiderBlock.isDisplayed();

    }

}
