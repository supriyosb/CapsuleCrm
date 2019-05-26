package pageObjects.login;

import managers.FileReaderManager;
import org.openqa.selenium.WebDriver;
import pageObjects.BaseKeywords;
import utils.Constant;

public class LoginPageKeyword extends BaseKeywords {

    private WebDriver driver;
    private LoginPageLocators locators;


    /**
     * Constructor
     * It will initialize the WebDriver instance
     *
     * @param driver
     */
    public LoginPageKeyword(WebDriver driver) {
        super(driver);
        this.driver = driver;
        locators = new LoginPageLocators();
    }

    /**
     * It will open the application
     */
    public void openApplication(){
        driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
    }

    /**
     * It will perform login operation
     * @param username
     * @param password
     */
    public void login(String username, String password){
        getUiInstance().getElement(locators.txtUsername, Constant.DEFAULT_TIMEOUT).setText(username);
        getUiInstance().getElement(locators.txtPassword, Constant.DEFAULT_TIMEOUT).setText(password);
        getUiInstance().getElement(locators.btnLogin).click();
    }
}
