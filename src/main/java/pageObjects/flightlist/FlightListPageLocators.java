package pageObjects.flightlist;

public class FlightListPageLocators {

    /**
     * Constructor
     * It will initialize FlightListPageLocators
     */
    public FlightListPageLocators() {
    }

    String firstDepartureFlightRow = "(//input[@name='splitowJourney'])[1]/parent::div";
    String listDepartureFlights = "//input[@name='splitowJourney']";
    String listReturnFlights = "//input[@name='splitrtJourney']";
    String cbNonStop = "//div[@id='fli_filter__stops']//span[text()='Non Stop']";
    String cbOneStop = "//div[@id='fli_filter__stops']//span[text()='1 Stop']";
    String lablePriceDepartureFlight = "(//input[@name='splitowJourney'])[$index$]/parent::div//p[@class='actual-price']/span";
    String lablePricereturnFlight = "(//input[@name='splitrtJourney'])[$index$]/parent::div//p[@class='actual-price']/span";
    String finalPriceDepartureFlight = "//div[contains(@class, 'splitVw-footer-left')]//p[contains(@class, 'actual-price')]/span";
    String finalPriceReturnFlight = "//div[contains(@class, 'splitVw-footer-right')]//p[contains(@class, 'actual-price')]/span";
    String totalPrice = "//div[contains(@class, 'splitVw-footer-total')]//span[contains(@class, 'splitVw-total-fare')]/span";
}
