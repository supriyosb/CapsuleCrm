package pageObjects.user;

import com.google.common.base.Strings;
import dataProviders.DataModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Sleeper;
import pageObjects.BaseKeywords;
import utils.Constant;

public class UserPageKeyword extends BaseKeywords {

    private WebDriver driver;
    private UserPageLocators locators;

    /**
     * Constructor
     * It will initialize the WebDriver instance
     *
     * @param driver
     */
    public UserPageKeyword(WebDriver driver) {
        super(driver);
        this.driver = driver;
        locators = new UserPageLocators();
    }

    /**
     * It will click Add User button
     */
    public void clickAddUserButton(){
        getUiInstance().getElement(locators.linkAddUser, Constant.DEFAULT_TIMEOUT).click();
    }

    /**
     * It will add a tag
     */
    public void addTag(String tag){
        getUiInstance().getElement(locators.txtTag, Constant.DEFAULT_TIMEOUT).setText(tag);
        getUiInstance().getElement(locators.btnAddTag, Constant.DEFAULT_TIMEOUT).click();
    }

    /**
     * It will verify party title and return true or false if matched with expected
     * @param strTitle
     * @return
     */
    public boolean verifyPartyTitle(String strTitle){
        String actualtitle = getUiInstance().getElement(locators.lablePartyTitle, Constant.DEFAULT_TIMEOUT).getText();
        return strTitle.equals(actualtitle) ? true : false;
    }

    /**
     * It will add a person after filling up the form
     * @param model
     */
    public void addPerson(DataModel model){
        getUiInstance().getElement(locators.txtFirstName, Constant.DEFAULT_TIMEOUT).setText(model.getFirstName());
        getUiInstance().getElement(locators.txtLastName, Constant.DEFAULT_TIMEOUT).setText(model.getLastName());
        addTag(model.getTag());
        getUiInstance().getElement(locators.txtPhoneNumber, Constant.DEFAULT_TIMEOUT).setText(model.getPhone());
        getUiInstance().getElement(locators.txtEmail, Constant.DEFAULT_TIMEOUT).setText(model.getEmail());
        getUiInstance().getElement(locators.btnSave, Constant.DEFAULT_TIMEOUT).click();
        sleep(2000);
        verifyPartyTitle(model.getFullName());
    }

    /**
     * It will verify newly added person inside the table
     * @param model
     * @return
     */
    public boolean verifyNewlyAddedPerson(DataModel model){
        String locator = locators.dynPartyRow.replace("$name$", model.getFullName())
                                                .replace("$email$", model.getEmail())
                                                    .replace("$phone$", model.getPhone());
        return getUiInstance().getElement(By.xpath(locator), Constant.DEFAULT_TIMEOUT).isDisplayed();
    }
}
