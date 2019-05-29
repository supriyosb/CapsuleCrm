package managers;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import pageObjects.cases.CasePageKeywords;
import pageObjects.home.HomePageKeyword;
import pageObjects.login.LoginPageKeyword;
import pageObjects.settings.SettingsPageKeywords;
import pageObjects.settings.SettingsPageLocators;
import pageObjects.user.UserPageKeyword;

public class PageObjectManager {

    private WebDriver driver;
    private ExtentTest reporter;
    private HomePageKeyword homePage;
    private LoginPageKeyword loginPage;
    private UserPageKeyword userPage;
    private CasePageKeywords casePage;
    private SettingsPageKeywords settingsPage;

    /**
     * Constructor
     * It will initialize the WebDriver instance
     * @param driver
     */
    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public void setReporter(ExtentTest reporter){
        this.reporter = reporter;
    }

    /**
     * It will return HomePageKeyword instance
     * @return
     */
    public HomePageKeyword getHomePage() {
        return (homePage == null) ? homePage = new HomePageKeyword(driver, reporter) : homePage;
    }

    /**
     * It will return LoginPageKeyword instance
     * @return
     */
    public LoginPageKeyword getLoginPage(){
        return (loginPage == null) ? loginPage = new LoginPageKeyword(driver, reporter) : loginPage;
    }

    /**
     * It will return UserPageKeyword instance
     * @return
     */
    public UserPageKeyword getUserPage(){
        return (userPage == null) ? userPage = new UserPageKeyword(driver, reporter) : userPage;
    }

    /**
     * It will return CasePageKeywords instance
     * @return
     */
    public CasePageKeywords getCasePage(){
        return (casePage == null) ? casePage = new CasePageKeywords(driver, reporter) : casePage;
    }

    public SettingsPageKeywords getSettingsPage(){
        return (settingsPage == null) ? settingsPage = new SettingsPageKeywords(driver, reporter) : settingsPage;
    }
}
