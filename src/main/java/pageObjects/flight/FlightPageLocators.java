package pageObjects.flight;

public class FlightPageLocators {

    /**
     * Constructor
     * It will initialize FlightPageLocators
     */
    public FlightPageLocators() {

    }

    String radioRoundTrip = "//li[contains(text(),'Round Trip')]";
    String labelFromCity = "//label[@for='fromCity']/span";
    String txtFromCity = "//li[@role='option']//div[text()='$cityCode$']";
    String labelToCity = "//label[@for='toCity']/span";
    String txtToCity = "//li[@role='option']//div[text()='$cityCode$']";
    String lableDateDeparture = "//label[@for='departure']//span[text()='DEPARTURE']";
    String labelDateReyurn = "//label[@for='return']//span[text()='RETURN']";
    String celldate = "//div[contains(text(),'$month$')]/parent::div/following-sibling::div[@class='DayPicker-Body']//p[text()='$day$']";
    String linkSearch = "//a[text()='Search']";
}
