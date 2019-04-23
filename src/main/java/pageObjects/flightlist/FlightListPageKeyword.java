package pageObjects.flightlist;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObjects.BaseKeywords;
import utils.Constant;

import java.util.List;

public class FlightListPageKeyword extends BaseKeywords {

    private WebDriver driver;
    private FlightListPageLocators locators;

    /**
     * Constructor
     * It will initialize FlightListPageKeyword with WebDriver and also create FlightListPageLocators instance
     * @param driver
     */
    public FlightListPageKeyword(WebDriver driver) {
        super(driver);
        this.driver = driver;
        locators = new FlightListPageLocators();
    }

    /**
     * It will wait until first flight row appear in the screen
     */
    public void waitForListOfFlightToAppear(){
        waitForVisibilityOfElement(By.xpath(locators.firstDepartureFlightRow), Constant.DEFAULT_TIMEOUT);
    }

    /**
     * It will return number of departure flights from the list.
     * @return
     */
    public Integer getNumberOfDepartureFlight(){
        return getNumberOfFlights(By.xpath(locators.listDepartureFlights));
    }

    /**
     * It will return number of return flights from the list
     * @return
     */
    public Integer getNumberOfReturnFlight(){
        return getNumberOfFlights(By.xpath(locators.listReturnFlights));
    }

    /**
     * It will select Non Stop option from application while searching flight
     */
    public void clickNonStopOption(){
        scrollToTop();
        WebElement element = waitForVisibilityOfElement(By.xpath(locators.cbNonStop), Constant.DEFAULT_TIMEOUT);
        element.click();
    }

    /**
     * It will deselect Non Stop option from application if already selected
     */
    public void deselectNonStopOption(){
        scrollToTop();
        WebElement element = waitForVisibilityOfElement(By.xpath(locators.cbNonStop), Constant.DEFAULT_TIMEOUT);
        element.click();
    }

    /**
     * It will select One Stop option from application while searching flight
     */
    public void clickOneStopOption(){
        scrollToTop();
        WebElement element = waitForVisibilityOfElement(By.xpath(locators.cbOneStop), Constant.DEFAULT_TIMEOUT);
        element.click();
    }

    /**
     * It will deselect One Stop option from application if already selected
     */
    public void deselectOneStopOption(){
        scrollToTop();
        WebElement element = waitForVisibilityOfElement(By.xpath(locators.cbOneStop), Constant.DEFAULT_TIMEOUT);
        element.click();
    }

    /**
     * It will first select departure flight from departure list by index
     * It will return the price of selected departure flight
     * @param index
     * @return
     */
    public Double getPriceBySelectingDepartureFlightWithIndex(Integer index){
        String strIndex = index.toString();
        WebElement element = waitForVisibilityOfElement(By.xpath(locators.lablePriceDepartureFlight.replace("$index$", strIndex)), Constant.DEFAULT_TIMEOUT);
        clickUsingJS(element);
        String strPrice = element.getText();
        return convertPriceToDouble(strPrice);
    }

    /**
     * It will first select return flight from return list by index
     * It will return the price of selected return flight
     * @param index
     * @return
     */
    public Double getPriceBySelectingReturnFlightWithIndex(Integer index){
        String strIndex = index.toString();
        WebElement element = waitForVisibilityOfElement(By.xpath(locators.lablePricereturnFlight.replace("$index$", strIndex)), Constant.DEFAULT_TIMEOUT);
        clickUsingJS(element);
        String strPrice = element.getText();
        return convertPriceToDouble(strPrice);
    }

    /**
     * It will return the final price of selected departure flight from bottom of the page
     * @return
     */
    public Double getFinalPriceOfDepartureFlight(){
        WebElement element = waitForVisibilityOfElement(By.xpath(locators.finalPriceDepartureFlight), Constant.DEFAULT_TIMEOUT);
        String strPrice = element.getText();
        return convertPriceToDouble(strPrice);
    }

    /**
     * It will return the final price of selected return flight from bottom of the page
     * @return
     */
    public Double getFinalPriceOfReturnFlight(){
        WebElement element = waitForVisibilityOfElement(By.xpath(locators.finalPriceReturnFlight), Constant.DEFAULT_TIMEOUT);
        String strPrice = element.getText();
        return convertPriceToDouble(strPrice);
    }

    /**
     * It will return the total price from the bottom of the page including price of departure flight and return flight
     * @return
     */
    public Double getTotalPrice(){
        WebElement element = waitForVisibilityOfElement(By.xpath(locators.totalPrice), Constant.DEFAULT_TIMEOUT);
        String strPrice = element.getText();
        return convertPriceToDouble(strPrice);
    }

    /**
     * It will convert the price String to Double
     * E.g Rs. 1,500 to 1500.0
     * @param strPrice
     * @return
     */
    private Double convertPriceToDouble(String strPrice){
        Double price = null;
        strPrice = strPrice.split(" ")[1].replace(",", "");
        price = Double.valueOf(strPrice);
        return price;
    }

    /**
     * It will first scroll until all the flights got listed by handling lazy loading
     * It will return the number of flights by locator
     * @param locator
     * @return
     */
    private Integer getNumberOfFlights(By locator){
        Boolean flag = true;
        List<WebElement> elementList = driver.findElements(locator);
        int initialSize = elementList.size();
        verticalScrollUsingJS();
        while (flag){
            sleep(1000);
            elementList = driver.findElements(locator);
            int newSize = elementList.size();
            if(initialSize == newSize){
                flag = false;
            } else {
                initialSize = newSize;
                verticalScrollUsingJS();
            }
        }
        return initialSize;
    }
}
