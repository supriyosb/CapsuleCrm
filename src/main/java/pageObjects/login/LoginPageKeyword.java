package pageObjects.login;

import com.aventstack.extentreports.ExtentTest;
import managers.FileReaderManager;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import pageObjects.BaseKeywords;
import utils.Constant;

public class LoginPageKeyword extends BaseKeywords {

    private WebDriver driver;
    private ExtentTest reporter;
    private LoginPageLocators locators;


    /**
     * Constructor
     * It will initialize the WebDriver instance
     *
     * @param driver
     */
    public LoginPageKeyword(WebDriver driver, ExtentTest reporter) {
        super(driver);
        this.driver = driver;
        this.reporter = reporter;
        locators = new LoginPageLocators();
    }

    /**
     * It will open the application
     */
    public void openApplication(){
        driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
        reporter.info("Opening application");
    }

    /**
     * It will perform login operation
     * @param username
     * @param password
     */
    public void login(String username, String password){
        reporter.info("Doing login with username: '"+username+"' and password: '"+password+"'");
        getUiInstance().getElement(locators.txtUsername, Constant.DEFAULT_TIMEOUT).setText(username);
        password = org.apache.commons.codec.binary.StringUtils.newStringUtf8(Base64.decodeBase64(password));
        getUiInstance().getElement(locators.txtPassword, Constant.DEFAULT_TIMEOUT).setText(password);
        getUiInstance().getElement(locators.btnLogin).click();
    }
}
