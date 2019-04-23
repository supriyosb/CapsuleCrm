import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assignment02 extends TestBase {

    /**
     * This test will verify launch the application
     * It will also verify search operation of flights
     */
    @Test (priority = 0)
    public void LaunchApplicationAndSearchFlightTest(){

        //Navigating to Make My Trip application home page
        getPageObjectManager().getHomePage().navigateToHomePage();

        //Clicking flight link
        getPageObjectManager().getHomePage().clickFlightLink();

        //Selecting round trip option
        getPageObjectManager().getFlightPage().selectRoundTripOption();

        //Selecting departure city
        getPageObjectManager().getFlightPage().selectDepartureCity("DEL");

        //Selecting return city
        getPageObjectManager().getFlightPage().selectReturnCity("BLR");

        //Selecting departure date
        String date = "23-April-2019";
        getPageObjectManager().getFlightPage().selectDepartureDateFromCalender(date);

        //Selecting return date
        date = "29-April-2019";
        getPageObjectManager().getFlightPage().selectReturnDateFromCalender(date);

        //Clicking search button
        getPageObjectManager().getFlightPage().clickSearchButton();
    }

    /**
     * This test will verify the number of flights present in list of departure flight and return flight
     */
    @Test(priority = 1)
    public void FetchNumberOfFlightFromFlightListTest(){

        //Wait for flight list to appear
        getPageObjectManager().getFlightListPage().waitForListOfFlightToAppear();

        //Get number of departure flight
        Integer numberOfDepartureFlights = getPageObjectManager().getFlightListPage().getNumberOfDepartureFlight();
        System.out.println("Number of departure flight by default: " + numberOfDepartureFlights);

        //Get number of departure flight
        Integer numberOfReturnFlights = getPageObjectManager().getFlightListPage().getNumberOfReturnFlight();
        System.out.println("Number of return flight by default: " + numberOfReturnFlights);

        //Selecting non stop option
        getPageObjectManager().getFlightListPage().clickNonStopOption();

        //Get number of departure flight
        numberOfDepartureFlights = getPageObjectManager().getFlightListPage().getNumberOfDepartureFlight();
        System.out.println("Number of departure flight for non stop option: " + numberOfDepartureFlights);

        //Get number of departure flight
        numberOfReturnFlights = getPageObjectManager().getFlightListPage().getNumberOfReturnFlight();
        System.out.println("Number of return flight for non stop option: " + numberOfReturnFlights);

        //Deselecting non stop option
        getPageObjectManager().getFlightListPage().deselectNonStopOption();

        //Selecting one stop option
        getPageObjectManager().getFlightListPage().clickOneStopOption();

        //Get number of departure flight
        numberOfDepartureFlights = getPageObjectManager().getFlightListPage().getNumberOfDepartureFlight();
        System.out.println("Number of departure flight for one stop option: " + numberOfDepartureFlights);

        //Get number of departure flight
        numberOfReturnFlights = getPageObjectManager().getFlightListPage().getNumberOfReturnFlight();
        System.out.println("Number of return flight for one stop option: " + numberOfReturnFlights);

        //Deselecting one stop option
        getPageObjectManager().getFlightListPage().deselectOneStopOption();
    }

    /**
     * This test will compare the price of selected departure price and return flight with total price
     */
    @Test(priority = 2)
    public void SelectFlightAndComparePriceTest(){

        //Selecting departure flight and getting price for that
        Double priceDepartureFlight = getPageObjectManager().getFlightListPage().getPriceBySelectingDepartureFlightWithIndex(3);
        System.out.println("Price of selected departure flight: " + priceDepartureFlight);

        Double finalPriceDepartureFlight = getPageObjectManager().getFlightListPage().getFinalPriceOfDepartureFlight();
        System.out.println("Final Price of selected departure flight: " + finalPriceDepartureFlight);

        //Comparing selected departure flight price with final price
        Assert.assertEquals(priceDepartureFlight, finalPriceDepartureFlight);

        //Selecting return flight and getting price for that
        Double priceReturnFlight = getPageObjectManager().getFlightListPage().getPriceBySelectingReturnFlightWithIndex(2);
        System.out.println("Price of selected return flight" + priceReturnFlight);

        Double finalPriceReturnFlight = getPageObjectManager().getFlightListPage().getFinalPriceOfReturnFlight();
        System.out.println("Final Price of selected return flight: " + finalPriceReturnFlight);

        //Comparing selected return flight price with final price
        Assert.assertEquals(priceReturnFlight, finalPriceReturnFlight);

        //Getting total price
        Double totalPrice = getPageObjectManager().getFlightListPage().getTotalPrice();
        System.out.println("Total price from screen: " + totalPrice);

        //Comparing actual total price with expected price
        Double actualPrice = finalPriceDepartureFlight + finalPriceReturnFlight;
        System.out.println("Actual price after adding departure price with return price: " + totalPrice);
        Assert.assertEquals(actualPrice, totalPrice);

    }
}
