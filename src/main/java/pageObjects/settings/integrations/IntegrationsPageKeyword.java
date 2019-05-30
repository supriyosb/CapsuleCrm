package pageObjects.settings.integrations;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObjects.BaseKeywords;

import java.util.List;

public class IntegrationsPageKeyword extends BaseKeywords {

    private WebDriver driver;
    private ExtentTest reporter;
    private IntegrationsPageLocators locators;


    /**
     * Constructor
     * It will initialize the WebDriver instance
     *
     * @param driver
     */
    public IntegrationsPageKeyword(WebDriver driver, ExtentTest reporter) {
        super(driver);
        this.driver = driver;
        this.reporter = reporter;
        this.locators = new IntegrationsPageLocators();
    }

    /**
     * It will return total number of Configure button is present in the page
     * @return
     */
    public int getTotalNoOfConfigureButton(){
        getUiInstance().waitForPageLoading();
        List<WebElement> elementList = getUiInstance().getAllElements(locators.linkConfigure);
        return elementList.size();
    }
}
