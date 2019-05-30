package pageObjects.settings.opportunities;

import com.aventstack.extentreports.ExtentTest;
import dataProviders.DataModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjects.BaseKeywords;
import utils.Constant;

import java.util.Random;

public class OpportunitiesPageKeywords extends BaseKeywords {

    private WebDriver driver;
    private ExtentTest reporter;
    private OpportunitiesPageLocators locators;


    /**
     * Constructor
     * It will initialize the WebDriver instance
     *
     * @param driver
     */
    public OpportunitiesPageKeywords(WebDriver driver, ExtentTest reporter) {
        super(driver);
        this.driver = driver;
        this.reporter = reporter;
        this.locators = new OpportunitiesPageLocators();
    }

    /**
     * It will add new milestone and verify it has been added or not
     * @param model
     */
    public void addNewMilestoneAndVerify(DataModel model){
        int milestoneId = new Random().nextInt(100) * new Random().nextInt(100);
        String milestoneName = model.getMilestoneName() + "_" + milestoneId;
        reporter.info("Clicking Add Milestone button");
        getUiInstance().getElement(locators.btnAddMilestone, Constant.DEFAULT_TIMEOUT).click();
        reporter.info("Verify milestone popup opened");
        verifyMilestonePopupOpen();
        reporter.info("Giving Milestone name: " + milestoneName);
        getUiInstance().getElement(locators.txtName, Constant.DEFAULT_TIMEOUT).setText(milestoneName);
        reporter.info("Giving Milestone description: " + model.getMilestoneDesc());
        getUiInstance().getElement(locators.txtDescription, Constant.DEFAULT_TIMEOUT).setText(model.getMilestoneDesc());
        reporter.info("Giving Milestone probability: " + model.getMilestoneProbability());
        getUiInstance().getElement(locators.txtProbability, Constant.DEFAULT_TIMEOUT).setText(model.getMilestoneProbability());
        reporter.info("Giving Milestone days until stale: " + model.getMilestoneDaysUntilStale());
        getUiInstance().getElement(locators.txtDaysUntilStale, Constant.DEFAULT_TIMEOUT).setText(model.getMilestoneDaysUntilStale());
        reporter.info("Clicking save button");
        getUiInstance().getElement(locators.btnSave, Constant.DEFAULT_TIMEOUT).click();
        reporter.info("Verifying newly added milestone is present or not: " + milestoneName);
        verifyMilestonePresent(milestoneName);
    }

    /**
     * It will verify milestone popup form is opened or not
     */
    public void verifyMilestonePopupOpen(){
        boolean flag = getUiInstance().getElement(locators.popupMilestoneForm, Constant.DEFAULT_TIMEOUT).isDisplayed();
        if (flag){
            reporter.pass("Milestone popup form is opened");
        } else {
            reporter.fail("Milestone popup form is not opened");
        }
    }

    /**
     * It will verify milestone is present or not
     * @param milestoneName
     */
    public void verifyMilestonePresent(String milestoneName){
        String locator = locators.dynMilestoneName.replace("$milestoneName$", milestoneName);
        boolean flag = getUiInstance().getElement(By.xpath(locator), Constant.DEFAULT_TIMEOUT).isDisplayed();
        if (flag){
            reporter.pass("Milestone is present: " + milestoneName);
        } else {
            reporter.fail("Milestone is not present" + milestoneName);
        }
    }
}
