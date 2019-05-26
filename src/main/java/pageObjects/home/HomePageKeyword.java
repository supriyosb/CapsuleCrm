package pageObjects.home;

import managers.FileReaderManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObjects.BaseKeywords;
import utils.Constant;

public class HomePageKeyword extends BaseKeywords {
    private WebDriver driver;
    private HomePageLocators locators;

    /**
     * Constructor
     * It will initialize HomePageKeyword with WebDriver and also create HomePageLocators instance
     * @param driver
     */
    public HomePageKeyword(WebDriver driver) {
        super(driver);
        this.driver = driver;
        locators = new HomePageLocators();
    }

    /**
     * It will click the user icon
     */
    public void clickUserIcon(){
        getUiInstance().getElement(locators.linkUser, Constant.DEFAULT_TIMEOUT).click();
    }
}
