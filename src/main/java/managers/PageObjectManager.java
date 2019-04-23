package managers;

import org.openqa.selenium.WebDriver;
import pageObjects.flight.FlightPageKeyword;
import pageObjects.flightlist.FlightListPageKeyword;
import pageObjects.home.HomePageKeyword;

public class PageObjectManager {

    private WebDriver driver;
    private HomePageKeyword homePage;
    private FlightPageKeyword flightPage;
    private FlightListPageKeyword flightListPage;

    /**
     * Constructor
     * It will initialize the WebDriver instance
     * @param driver
     */
    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * It will return HomePageKeyword instance
     * @return
     */
    public HomePageKeyword getHomePage() {
        return (homePage == null) ? homePage = new HomePageKeyword(driver) : homePage;
    }

    /**
     * It will return FlightPageKeyword instance
     * @return
     */
    public FlightPageKeyword getFlightPage(){
        return (flightPage == null) ? flightPage = new FlightPageKeyword(driver) : flightPage;
    }

    /**
     * It will return FlightListPageKeyword instance
     * @return
     */
    public FlightListPageKeyword getFlightListPage(){
        return (flightListPage == null) ? flightListPage = new FlightListPageKeyword(driver) : flightListPage;
    }
}
