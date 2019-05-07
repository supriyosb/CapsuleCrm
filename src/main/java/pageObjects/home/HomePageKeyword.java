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
     * It will navigate to home page of the application
     */
    public void navigateToHomePage(){
        driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
    }

    /**
     * It will click the Flight link option from the menu bar
     */
    public void clickFlightLink(){
        //WebElement element = waitForVisibilityOfElement(By.xpath(locators.linkFlights), Constant.DEFAULT_TIMEOUT);
        //element.click();
        getUiInstance().getElement(By.xpath(locators.linkFlights), Constant.DEFAULT_TIMEOUT).clickUsingJs();

    }
}
