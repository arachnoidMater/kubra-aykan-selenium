package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.PropertiesUtils;

public class HomePage {
    private WebDriver driver;

    @FindBy(xpath = "//h1[contains(text(),'#1 AI-native')]")
    private WebElement homePageHeader;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openHomePage() {
        driver.get(PropertiesUtils.getProperty("homePageUrl"));
    }

    public boolean isHomePageDisplayed() {
        return homePageHeader.isDisplayed();
    }

}
