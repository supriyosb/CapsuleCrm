package pageObjects.settings.tags;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObjects.BaseKeywords;
import utils.Constant;

import java.util.List;

public class TagsPageKeywords extends BaseKeywords {

    private WebDriver driver;
    private ExtentTest reporter;
    private TagsPageLocators locators;


    /**
     * Constructor
     * It will initialize the WebDriver instance
     *
     * @param driver
     */
    public TagsPageKeywords(WebDriver driver, ExtentTest reporter) {
        super(driver);
        this.driver = driver;
        this.reporter = reporter;
        this.locators = new TagsPageLocators();
    }

    /**
     * It will delete existing matched tag and will add new tag
     * @param tagName
     */
    public void addNewTag(String tagName){
        List<WebElement> elementList = getUiInstance().getAllElements(By.linkText(tagName));
        if (elementList.size() > 0){
            deleteExistingTag(tagName);
        }
        reporter.info("Clicking Add New Tag button");
        getUiInstance().getElement(locators.linkAddNewTag, Constant.DEFAULT_TIMEOUT).click();
        reporter.info("Giving tag name: " + tagName);
        getUiInstance().getElement(locators.txtTagName, Constant.DEFAULT_TIMEOUT).setText(tagName);
        reporter.info("Clicking save button");
        getUiInstance().getElement(locators.btnSave, Constant.DEFAULT_TIMEOUT).click();
    }

    /**
     * It will verify the tag name is present or not in the list
     * @param tagName
     */
    public void verifyTagPresent(String tagName){
        reporter.info("Verifying tag name is present or not in the list: " + tagName);
        boolean flag = getUiInstance().getElement(By.linkText(tagName), Constant.DEFAULT_TIMEOUT).isDisplayed();
        if (flag){
            reporter.pass("Tag name is present: " + tagName);
        } else {
            reporter.fail("Tag name is not present: " + tagName);
        }
    }

    /**
     * It will delete existing tag
     * @param tagName
     */
    public void deleteExistingTag(String tagName){
        reporter.info("Deleting existing tag: " + tagName);
        String locator = locators.dynTagDelete.replace("$tagName$", tagName);
        getUiInstance().getElement(By.xpath(locator), Constant.DEFAULT_TIMEOUT).click();
        getUiInstance().getElement(locators.deleteTagConf, Constant.DEFAULT_TIMEOUT).click();
        reporter.info("Delete completed");
        getUiInstance().waitForElementToInvisible(locators.deletePopup, Constant.DEFAULT_TIMEOUT);
    }
}
