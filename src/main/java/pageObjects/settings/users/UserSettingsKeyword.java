package pageObjects.settings.users;

import com.aventstack.extentreports.ExtentTest;
import dataProviders.DataModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObjects.BaseKeywords;
import utils.Constant;

import java.util.List;

public class UserSettingsKeyword extends BaseKeywords {

    private WebDriver driver;
    private ExtentTest reporter;
    private UserSettingsLocators locators;

    /**
     * Constructor
     * It will initialize the WebDriver instance
     *
     * @param driver
     */
    public UserSettingsKeyword(WebDriver driver, ExtentTest reporter) {
        super(driver);
        this.driver = driver;
        this.reporter = reporter;
        this.locators = new UserSettingsLocators();
    }

    /**
     * It will delete existing user
     * @param user
     */
    public void deleteExistingUser(String user){
        reporter.info("Deleting user: " + user);
        getUiInstance().getElement(By.partialLinkText(user), Constant.DEFAULT_TIMEOUT).click();
        getUiInstance().getElement(locators.linkDeleteUser, Constant.DEFAULT_TIMEOUT).click();
        getUiInstance().getElement(locators.linkDeletePopup, Constant.DEFAULT_TIMEOUT).click();
        reporter.info("Deletion complete");
    }

    /**
     * It will delete existing user if any and then invite new user
     * @param model
     */
    public void inviteUser(DataModel model){
        List<WebElement> elementList = getUiInstance().getAllElements(By.partialLinkText(model.getFullName()));
        if (elementList.size() > 0) {
            reporter.info("Already user exist with name: " + model.getFullName());
            deleteExistingUser(model.getFullName());
        }
        reporter.info("Clicking Add New User button");
        getUiInstance().getElement(locators.btnAddNewUser, Constant.DEFAULT_TIMEOUT).click();
        reporter.info("Providing first name: " + model.getFirstName());
        getUiInstance().getElement(locators.txtFirstName, Constant.DEFAULT_TIMEOUT).setText(model.getFirstName());
        reporter.info("Providing last name: " + model.getLastName());
        getUiInstance().getElement(locators.txtLastname, Constant.DEFAULT_TIMEOUT).setText(model.getLastName());
        reporter.info("Providing email: " + model.getEmail());
        getUiInstance().getElement(locators.txtEmail, Constant.DEFAULT_TIMEOUT).setText(model.getEmail());
        reporter.info("Providing username: " + model.getSettingsUserName());
        getUiInstance().getElement(locators.txtUsername, Constant.DEFAULT_TIMEOUT).setText(model.getSettingsUserName());
        reporter.info("Clicking Invite User button");
        getUiInstance().getElement(locators.btnInviteUser, Constant.DEFAULT_TIMEOUT).click();
    }

    /**
     * It will verify the newly invited user in the list
     * @param username
     * @param email
     */
    public void verifyNewlyInvitedUser(String username, String email){
        String locator = locators.dynUser.replace("$username$", username).replace("$email$", email);
        boolean flag = getUiInstance().getElement(By.xpath(locator), Constant.DEFAULT_TIMEOUT).isDisplayed();
        if (flag){
            reporter.pass("Newly invited user is verified: " + username);
        } else {
            reporter.fail("Newly invited user is not verified: " + username);
        }
    }
}
