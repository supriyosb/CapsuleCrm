package pageObjects.user;

import com.aventstack.extentreports.ExtentTest;
import com.google.common.base.Strings;
import dataProviders.DataModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Sleeper;
import pageObjects.BaseKeywords;
import utils.Constant;

public class UserPageKeyword extends BaseKeywords {

    private WebDriver driver;
    private ExtentTest reporter;
    private UserPageLocators locators;

    /**
     * Constructor
     * It will initialize the WebDriver instance
     *
     * @param driver
     */
    public UserPageKeyword(WebDriver driver, ExtentTest reporter) {
        super(driver);
        this.driver = driver;
        this.reporter = reporter;
        locators = new UserPageLocators();
    }

    /**
     * It will click Add User button
     */
    public void clickAddUserButton(){
        getUiInstance().getElement(locators.linkAddUser, Constant.DEFAULT_TIMEOUT).click();
        reporter.info("Clicking Add Person button");
    }

    /**
     * It will add a tag
     */
    public void addTag(String tag){
        getUiInstance().getElement(locators.txtTag, Constant.DEFAULT_TIMEOUT).setText(tag);
        getUiInstance().getElement(locators.btnAddTag, Constant.DEFAULT_TIMEOUT).clickUsingJs();
        reporter.info("Adding Tag: '"+tag+"'");
    }

    /**
     * It will verify party title and return true or false if matched with expected
     * @param strTitle
     * @return
     */
    public boolean verifyPartyTitle(String strTitle){
        String actualtitle = getUiInstance().getElement(locators.lablePartyTitle, Constant.DEFAULT_TIMEOUT).getText();
        reporter.info("Getting party title from application: '"+actualtitle+"'");
        return strTitle.equals(actualtitle) ? true : false;
    }

    /**
     * It will add a person after filling up the form
     * @param model
     */
    public void addPerson(DataModel model){
        reporter.info("Adding person");
        getUiInstance().getElement(locators.txtFirstName, Constant.DEFAULT_TIMEOUT).setText(model.getFirstName());
        reporter.info("Providing first name: '"+model.getFirstName()+"'");
        getUiInstance().getElement(locators.txtLastName, Constant.DEFAULT_TIMEOUT).setText(model.getLastName());
        reporter.info("Providing last name: '"+model.getLastName()+"'");
        addTag(model.getTag());
        getUiInstance().getElement(locators.txtPhoneNumber, Constant.DEFAULT_TIMEOUT).setText(model.getPhone());
        reporter.info("Providing phone number: '"+model.getPhone()+"'");
        getUiInstance().getElement(locators.txtEmail, Constant.DEFAULT_TIMEOUT).setText(model.getEmail());
        reporter.info("Providing email: '"+model.getEmail()+"'");
        getUiInstance().getElement(locators.btnSave, Constant.DEFAULT_TIMEOUT).clickUsingJs();
        reporter.info("Clicking save button");
        sleep(2000);
        reporter.info("Verifying party title");
        verifyPartyTitle(model.getFullName());
    }

    /**
     * It will verify newly added person inside the table
     * @param model
     * @return
     */
    public boolean verifyNewlyAddedPerson(DataModel model){
        reporter.info("Verifying newly added person");
        String locator = locators.dynPartyRow.replace("$name$", model.getFullName())
                                                .replace("$email$", model.getEmail())
                                                    .replace("$phone$", model.getPhone());
        return getUiInstance().getElement(By.xpath(locator), Constant.DEFAULT_TIMEOUT).isDisplayed();
    }
}
