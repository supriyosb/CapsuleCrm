package pageObjects.settings.taskcatagory;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObjects.BaseKeywords;
import utils.Constant;

import java.util.List;

public class TaskCatagoryPageKeywords extends BaseKeywords {

    private WebDriver driver;
    private ExtentTest reporter;
    private TaskCatagoryPageLocators locators;


    /**
     * Constructor
     * It will initialize the WebDriver instance
     *
     * @param driver
     */
    public TaskCatagoryPageKeywords(WebDriver driver, ExtentTest reporter) {
        super(driver);
        this.driver = driver;
        this.reporter = reporter;
        this.locators = new TaskCatagoryPageLocators();
    }

    /**
     * It will delete existing task category if matched then it will add task category
     * @param categoryName
     */
    public void addTaskcategoryAndVerify(String categoryName){
        List<WebElement> elementList = getUiInstance().getAllElements(By.linkText(categoryName));
        if (elementList.size() > 0){
            deleteExistingCategory(categoryName);
        }
        reporter.info("Clicking Add Task Category button");
        getUiInstance().getElement(locators.linkAddTaskCategory, Constant.DEFAULT_TIMEOUT).click();
        reporter.info("Giving task catagory name: " + categoryName);
        getUiInstance().getElement(locators.txtName, Constant.DEFAULT_TIMEOUT).setText(categoryName);
        reporter.info("Clicking save button");
        getUiInstance().getElement(locators.btnSave, Constant.DEFAULT_TIMEOUT).click();
    }

    /**
     * It will verify task category is present in the list or not
     * @param categoryName
     */
    public void verifyTaskCatagoryPresent(String categoryName){
        reporter.info("Verifying task category is present or not in the list: " + categoryName);
        boolean flag = getUiInstance().getElement(By.linkText(categoryName), Constant.DEFAULT_TIMEOUT).isDisplayed();
        if (flag){
            reporter.pass("Task category is present: " + categoryName);
        } else {
            reporter.fail("Task category is not present: " + categoryName);
        }
    }

    /**
     * It will delete existing task category
     * @param categoryName
     */
    public void deleteExistingCategory(String categoryName){
        reporter.info("Delete existing task category: " + categoryName);
        String locator = locators.dynLinkCatagoryDelete.replace("$category$", categoryName);
        getUiInstance().getElement(By.xpath(locator), Constant.DEFAULT_TIMEOUT).click();
        getUiInstance().getElement(locators.btnDeleteConf, Constant.DEFAULT_TIMEOUT).click();
        reporter.info("Delete completed");
        getUiInstance().waitForElementToInvisible(locators.deletePopup, Constant.DEFAULT_TIMEOUT);
    }
}
