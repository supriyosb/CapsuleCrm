package pageObjects.home;

import com.aventstack.extentreports.ExtentTest;
import managers.FileReaderManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObjects.BaseKeywords;
import utils.Constant;

public class HomePageKeyword extends BaseKeywords {
    private WebDriver driver;
    private ExtentTest reporter;
    private HomePageLocators locators;

    /**
     * Constructor
     * It will initialize HomePageKeyword with WebDriver and also create HomePageLocators instance
     * @param driver
     */
    public HomePageKeyword(WebDriver driver, ExtentTest reporter) {
        super(driver);
        this.driver = driver;
        this.reporter = reporter;
        locators = new HomePageLocators();
    }

    /**
     * It will click the user icon
     */
    public void clickUserIcon(){
        getUiInstance().getElement(locators.linkUser, Constant.DEFAULT_TIMEOUT).click();
        reporter.info("Clicking person icon");
    }

    /**
     * It will click the case icon
     */
    public void clickCaseIcon(){
        getUiInstance().getElement(locators.linkCase, Constant.DEFAULT_TIMEOUT).click();
        reporter.info("Clicking case icon");
    }

    /**
     * It will expand the settings option of profile by clicking user profile pic
     */
    public void expandSettingsOption(){
        getUiInstance().getElement(locators.imgProfilePic, Constant.DEFAULT_TIMEOUT).click();
    }

    /**
     * It will navigate to account settings option
     */
    public void navigateToAccountSettingsOption(){
        expandSettingsOption();
        reporter.info("Navigating to Account Settings page");
        getUiInstance().getElement(locators.linkAccountSetting, Constant.DEFAULT_TIMEOUT).click();
    }
}
