package pageObjects.settings;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObjects.BaseKeywords;
import pageObjects.settings.appearrance.AppearancePageKeywords;
import pageObjects.settings.users.UserSettingsKeyword;
import utils.Constant;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SettingsPageKeywords extends BaseKeywords {

    private WebDriver driver;
    private ExtentTest reporter;
    private SettingsPageLocators locators;
    private AppearancePageKeywords appearancePage;
    private UserSettingsKeyword userPage;

    /**
     * Constructor
     * It will initialize the WebDriver instance
     *
     * @param driver
     */
    public SettingsPageKeywords(WebDriver driver, ExtentTest reporter) {
        super(driver);
        this.driver = driver;
        this.reporter = reporter;
        this.locators = new SettingsPageLocators();
    }

    /**
     * It will return AppearancePageKeywords instance
     * @return
     */
    public AppearancePageKeywords getAppearancePage(){
        return (appearancePage == null) ? appearancePage = new AppearancePageKeywords(driver, reporter) : appearancePage;
    }

    /**
     * It will return UserSettingsKeyword instance
     * @return
     */
    public UserSettingsKeyword getUserPage(){
        return (userPage == null) ? userPage = new UserSettingsKeyword(driver, reporter) : userPage;
    }

    /**
     * It will verify the account settings page has opened or not by matching header label
     */
    public void verifyAccountSettingsPageOpened(){
        boolean flag = getUiInstance().getElement(locators.lableSettingsHeader, Constant.DEFAULT_TIMEOUT).isDisplayed();
        if(flag){
            reporter.pass("Account Settings page is opened and header is Account Setting");
        } else {
            reporter.fail("Account Settings page is not opened and header is not Account Setting");
        }
    }

    /**
     * It will verify header sections of each options
     */
    public void verifyHeadersOfEachOptions(){
        List<WebElement> elementList = getUiInstance().getAllElements(locators.linkAllOptions);
        List<String> allLinks = new ArrayList<>();
        for (WebElement element : elementList){
            String linkText = element.getText();
            allLinks.add(linkText);
        }
        for (String link : allLinks){
            clickLinkOptions(link);
            String headerText = getUiInstance().getElement(locators.labelOptionsHeader, Constant.DEFAULT_TIMEOUT).getText();
            if(headerText.contains(link)){
                reporter.pass("Header matched of option '"+link+"': '"+headerText+"'");
            } else {
                reporter.fail("Header not matched of option '"+link+"': '"+headerText+"'");
            }
        }
    }

    /**
     * It will click options in settings page
     */
    public void clickLinkOptions(String linkText){
        reporter.info("Clicking link: '"+linkText+"'");
        getUiInstance().getElement(By.linkText(linkText), Constant.DEFAULT_TIMEOUT).click();
    }
}