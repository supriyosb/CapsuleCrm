package pageObjects.cases;

import com.aventstack.extentreports.ExtentTest;
import dataProviders.DataModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjects.BaseKeywords;
import utils.Constant;

public class CasePageKeywords extends BaseKeywords {

    private WebDriver driver;
    private ExtentTest reporter;
    private CasePageLocator locator;

    /**
     * Constructor
     * It will initialize the WebDriver instance
     *
     * @param driver
     */
    public CasePageKeywords(WebDriver driver, ExtentTest reporter) {
        super(driver);
        this.driver = driver;
        this.reporter = reporter;
        locator = new CasePageLocator();
    }

    /**
     * It will click Add Case Button
     */
    public void clickAddCaseButton(){
        reporter.info("Clicking Add Case button");
        getUiInstance().getElement(locator.btnAddCase, Constant.DEFAULT_TIMEOUT).click();
    }

    /**
     * It will add case
     * @param model
     */
    public void addCase(DataModel model){
        reporter.info("Adding case");
        selectRelatesToPerson(model.getFullName());
        reporter.info("Providing case name: '"+model.getCaseName()+"'");
        getUiInstance().getElement(locator.txtCaseName, Constant.DEFAULT_TIMEOUT).setText(model.getCaseName());
        addTag(model.getCaseTag());
        reporter.info("Providing case description: '"+model.getCaseDescription()+"'");
        getUiInstance().getElement(locator.txtCaseDescription, Constant.DEFAULT_TIMEOUT).setText(model.getCaseDescription());
        reporter.info("Clicking save button");
        getUiInstance().getElement(locator.btnSave, Constant.DEFAULT_TIMEOUT).clickUsingJs();
        sleep(2000);
    }

    /**
     * It will search the person name and select it
     * @param personName
     */
    public void selectRelatesToPerson(String personName){
        reporter.info("Selecting related person name: '"+personName+"'");
        getUiInstance().getElement(locator.txtPartySearch, Constant.DEFAULT_TIMEOUT).setText(personName);
        String locators = locator.dynSearchResult.replace("$name$", personName);
        getUiInstance().getElement(By.xpath(locators), Constant.DEFAULT_TIMEOUT).click();
    }

    /**
     * It will add a tag
     */
    public void addTag(String tag){
        reporter.info("Adding tag: '"+tag+"'");
        getUiInstance().getElement(locator.txtTag, Constant.DEFAULT_TIMEOUT).setText(tag);
        getUiInstance().getElement(locator.btnAddTag, Constant.DEFAULT_TIMEOUT).clickUsingJs();
    }

    /**
     * It will verify case name and return true if matched with expected
     * @return
     */
    public boolean verifyCaseName(String expectedCaseName){
        String actualCaseName = getUiInstance().getElement(locator.labelCaseName, Constant.DEFAULT_TIMEOUT).getText();
        reporter.info("Getting case name from application: '"+actualCaseName+"'");
        return actualCaseName.equals(expectedCaseName) ? true : false;
    }

    /**
     * It will verify case owner and return true if matched with expected
     * @param expectedCaseOwner
     * @return
     */
    public boolean verifyCaseOwner(String expectedCaseOwner){
        String actualCaseOwner = getUiInstance().getElement(locator.labelCaseOwner, Constant.DEFAULT_TIMEOUT).getText();
        reporter.info("Getting case owner from application: '"+actualCaseOwner+"'");
        return actualCaseOwner.equals(expectedCaseOwner) ? true : false;
    }

    /**
     * It will verify case status and return true if matched with expected
     * @param expectedStatus
     * @return
     */
    public boolean verifyCaseStatus(String expectedStatus){
        String actualStatus = getUiInstance().getElement(locator.labelCaseStatus, Constant.DEFAULT_TIMEOUT).getText();
        reporter.info("Getting case status from application: '"+actualStatus+"'");
        return actualStatus.equals(expectedStatus) ? true : false;
    }
}
