package pageObjects.settings.tracks;

import com.aventstack.extentreports.ExtentTest;
import dataProviders.DataModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObjects.BaseKeywords;
import utils.Constant;

import java.util.List;
import java.util.Random;

public class TrackPageKeywords extends BaseKeywords {

    private WebDriver driver;
    private ExtentTest reporter;
    private TrackPageLocators locators;


    /**
     * Constructor
     * It will initialize the WebDriver instance
     *
     * @param driver
     */
    public TrackPageKeywords(WebDriver driver, ExtentTest reporter) {
        super(driver);
        this.driver = driver;
        this.reporter = reporter;
        this.locators = new TrackPageLocators();
    }

    /**
     * It will add new track and verify it has been added or not
     * @param model
     */
    public void addNewTrack(DataModel model){
        String trackName = model.getTrackName();
        List<WebElement> elementList = getUiInstance().getAllElements(By.linkText(trackName));
        if (elementList.size() > 0){
            deleteExistingTrack(trackName);
        }
        reporter.info("Clicking Add New Track button");
        getUiInstance().getElement(locators.linkAddNewTrack, Constant.DEFAULT_TIMEOUT).click();
        reporter.info("Giving track name: " + trackName);
        getUiInstance().getElement(locators.txtTrackName, Constant.DEFAULT_TIMEOUT).setText(trackName);
        reporter.info("Giving track tag: " + model.getTrackTag());
        getUiInstance().getElement(locators.txtTrackTag, Constant.DEFAULT_TIMEOUT).setText(model.getTrackTag());
        reporter.info("Giving Task Description: " + model.getTaskDesc());
        getUiInstance().getElement(locators.txtTaskDecription, Constant.DEFAULT_TIMEOUT).setText(model.getTaskDesc());
        reporter.info("Selecting task catagory: " + model.getTaskcatagory());
        getUiInstance().getElement(locators.ddCatagory, Constant.DEFAULT_TIMEOUT).click();
        String locator = locators.dynCatagoryItem.replace("$catagory$", model.getTaskcatagory());
        getUiInstance().getElement(By.xpath(locator), Constant.DEFAULT_TIMEOUT).click();
        reporter.info("Giving task days: " + model.getTaskDays());
        getUiInstance().getElement(locators.txtTaskDays, Constant.DEFAULT_TIMEOUT).setText(model.getTaskDays());
        reporter.info("Clicking save button");
        getUiInstance().getElement(locators.linkSave, Constant.DEFAULT_TIMEOUT).click();
        reporter.info("Verifying newly added track is present or not in track list");
        verifyTrackPresent(trackName);
    }

    /**
     * It will verify the track name is present or not
     * @param trackName
     */
    public void verifyTrackPresent(String trackName){
        boolean flag = getUiInstance().getElement(By.linkText(trackName), Constant.DEFAULT_TIMEOUT).isDisplayed();
        if (flag){
            reporter.pass("Track is present in the list: " + trackName);
        } else {
            reporter.fail("Track is not present in the list" + trackName);
        }
    }

    /**
     * It will delete existing track
     * @param trackName
     */
    public void deleteExistingTrack(String trackName){
        reporter.info("Deleting existing track: " + trackName);
        String locator = locators.dynTrackDelete.replace("$trackName$", trackName);
        getUiInstance().getElement(By.xpath(locator), Constant.DEFAULT_TIMEOUT).click();
        getUiInstance().getElement(locators.linkDeleteTrack, Constant.DEFAULT_TIMEOUT).click();
        reporter.info("Delete completed");
        getUiInstance().waitForElementToInvisible(locators.deletePopup, Constant.DEFAULT_TIMEOUT);
    }
}
