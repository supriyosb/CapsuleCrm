package pageObjects.settings.appearrance;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import pageObjects.BaseKeywords;
import utils.Constant;

public class AppearancePageKeywords extends BaseKeywords {

    private WebDriver driver;
    private ExtentTest reporter;
    private AppearancePageLocators locators;


    /**
     * Constructor
     * It will initialize the WebDriver instance
     *
     * @param driver
     */
    public AppearancePageKeywords(WebDriver driver, ExtentTest reporter) {
        super(driver);
        this.driver = driver;
        this.reporter = reporter;
        this.locators = new AppearancePageLocators();
    }

    /**
     * It will upload a logo
     * @param fileName
     */
    public void uploadLogo(String fileName){
        reporter.info("Uploading file: '"+fileName+"'");
        String logoPath = System.getProperty("user.dir") + "/data-files/" + fileName;
        getUiInstance().getElement(locators.fileLogoInput, Constant.DEFAULT_TIMEOUT).setText(logoPath);
        reporter.info("Clicking save button");
        getUiInstance().getElement(locators.linkSave, Constant.DEFAULT_TIMEOUT).click();
        getUiInstance().waitForPageLoading();
    }
}
