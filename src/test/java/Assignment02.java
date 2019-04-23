import base.TestBase;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Assignment02 extends TestBase {

    /**
     * This test will verify launch the application
     * It will also verify search operation of flights
     */
    @Test (priority = 0)
    public void LaunchApplicationAndSearchFlightTest(){

        //Initializing reporter log
        reporter = extentReports.createTest("Launch Application And Search Flight", "To verify application is launching and user is able to search flights");

        //Navigating to Make My Trip application home page
        getPageObjectManager().getHomePage().navigateToHomePage();
        reporter.log(Status.PASS, "Navigated to Make My Trip application");

        //Clicking flight link
        getPageObjectManager().getHomePage().clickFlightLink();
        reporter.log(Status.PASS, "Flight link is clicked");

        //Selecting round trip option
        getPageObjectManager().getFlightPage().selectRoundTripOption();
        reporter.log(Status.PASS, "Round Trip option is selected");

        //Selecting departure city
        getPageObjectManager().getFlightPage().selectDepartureCity(model.getDepartureCityCode());
        reporter.log(Status.PASS, "'"+model.getDepartureCityCode()+"' is selected as departure city");

        //Selecting return city
        getPageObjectManager().getFlightPage().selectReturnCity(model.getArrivalCityCode());
        reporter.log(Status.PASS, "'"+model.getArrivalCityCode()+"' is selected as arrival city");

        //Selecting departure date
        String departureDate = new SimpleDateFormat("d-MMMM-yyyy").format(Calendar.getInstance().getTime());
        getPageObjectManager().getFlightPage().selectDepartureDateFromCalender(departureDate);
        reporter.log(Status.PASS, "'"+departureDate+"' is selected as departure date");

        //Selecting return date
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, Integer.valueOf(model.getDateInterval()));
        String returndate = new SimpleDateFormat("d-MMMM-yyyy").format(calendar.getTime());
        getPageObjectManager().getFlightPage().selectReturnDateFromCalender(returndate);
        reporter.log(Status.PASS, "'"+returndate+"' is selected as return date");

        //Clicking search button
        getPageObjectManager().getFlightPage().clickSearchButton();
        reporter.log(Status.PASS, "Search button is clicked");
    }

    /**
     * This test will verify the number of flights present in list of departure flight and return flight
     */
    @Test(priority = 1)
    public void FetchNumberOfFlightFromFlightListTest(){

        //Initializing reporter log
        reporter = extentReports.createTest("Fetch Number Of Flights From Flight List", "To verify the number of flights present in list of departure flight and return flight");

        //Wait for flight list to appear
        getPageObjectManager().getFlightListPage().waitForListOfFlightToAppear();
        reporter.info("Waiting for loading flight list");

        //Get number of departure flight
        Integer numberOfDepartureFlights = getPageObjectManager().getFlightListPage().getNumberOfDepartureFlight();
        System.out.println("Number of departure flight by default: " + numberOfDepartureFlights);
        reporter.info("Number of departure flight by default: " + numberOfDepartureFlights);

        //Get number of departure flight
        Integer numberOfReturnFlights = getPageObjectManager().getFlightListPage().getNumberOfReturnFlight();
        System.out.println("Number of return flight by default: " + numberOfReturnFlights);
        reporter.info("Number of return flight by default: " + numberOfReturnFlights);

        //Selecting non stop option
        getPageObjectManager().getFlightListPage().clickNonStopOption();
        reporter.log(Status.PASS, "Non Stop option is selected");

        //Get number of departure flight
        numberOfDepartureFlights = getPageObjectManager().getFlightListPage().getNumberOfDepartureFlight();
        System.out.println("Number of departure flight for non stop option: " + numberOfDepartureFlights);
        reporter.info("Number of departure flight for non stop option: " + numberOfDepartureFlights);

        //Get number of departure flight
        numberOfReturnFlights = getPageObjectManager().getFlightListPage().getNumberOfReturnFlight();
        System.out.println("Number of return flight for non stop option: " + numberOfReturnFlights);
        reporter.info("Number of return flight for non stop option: " + numberOfReturnFlights);

        //Deselecting non stop option
        getPageObjectManager().getFlightListPage().deselectNonStopOption();
        reporter.info("Deslecting Non Stop option");

        //Selecting one stop option
        getPageObjectManager().getFlightListPage().clickOneStopOption();
        reporter.log(Status.PASS, "One Stop option is selected");

        //Get number of departure flight
        numberOfDepartureFlights = getPageObjectManager().getFlightListPage().getNumberOfDepartureFlight();
        System.out.println("Number of departure flight for one stop option: " + numberOfDepartureFlights);
        reporter.info("Number of departure flight for one stop option: " + numberOfDepartureFlights);

        //Get number of departure flight
        numberOfReturnFlights = getPageObjectManager().getFlightListPage().getNumberOfReturnFlight();
        System.out.println("Number of return flight for one stop option: " + numberOfReturnFlights);
        reporter.info("Number of return flight for one stop option: " + numberOfReturnFlights);

        //Deselecting one stop option
        getPageObjectManager().getFlightListPage().deselectOneStopOption();
        reporter.info("Deslecting Non Stop option");
    }

    /**
     * This test will compare the price of selected departure price and return flight with total price
     */
    @Test(priority = 2)
    public void SelectFlightAndComparePriceTest(){

        //Initializing reporter log
        reporter = extentReports.createTest("Select Flight And Compare Price", "To compare the price of selected departure price and return flight with total price");

        //Selecting departure flight and getting price for that
        Double priceDepartureFlight = getPageObjectManager().getFlightListPage().getPriceBySelectingDepartureFlightWithIndex(Integer.valueOf(model.getDepartureFlightIndex()));
        System.out.println("Price of selected departure flight: " + priceDepartureFlight);
        reporter.log(Status.PASS, "Departure flight is selected");
        reporter.info("Price of selected departure flight: " + priceDepartureFlight);

        Double finalPriceDepartureFlight = getPageObjectManager().getFlightListPage().getFinalPriceOfDepartureFlight();
        System.out.println("Final Price of selected departure flight: " + finalPriceDepartureFlight);
        reporter.info("Final Price of selected departure flight: " + finalPriceDepartureFlight);

        //Comparing selected departure flight price with final price
        Assert.assertEquals(priceDepartureFlight, finalPriceDepartureFlight);
        reporter.log(Status.PASS, "Departure flight price is same with final price");

        //Selecting return flight and getting price for that
        Double priceReturnFlight = getPageObjectManager().getFlightListPage().getPriceBySelectingReturnFlightWithIndex(Integer.valueOf(model.getArrivalFlightIndex()));
        System.out.println("Price of selected return flight" + priceReturnFlight);
        reporter.log(Status.PASS, "Return flight is selected");
        reporter.info("Price of selected return flight" + priceReturnFlight);

        Double finalPriceReturnFlight = getPageObjectManager().getFlightListPage().getFinalPriceOfReturnFlight();
        System.out.println("Final Price of selected return flight: " + finalPriceReturnFlight);
        reporter.info("Final Price of selected return flight: " + finalPriceReturnFlight);

        //Comparing selected return flight price with final price
        Assert.assertEquals(priceReturnFlight, finalPriceReturnFlight);
        reporter.log(Status.PASS, "Return flight price is same with final price");

        //Getting total price
        Double totalPrice = getPageObjectManager().getFlightListPage().getTotalPrice();
        System.out.println("Total price from screen: " + totalPrice);
        reporter.info("Total price from screen: " + totalPrice);

        //Comparing actual total price with expected price
        Double actualPrice = finalPriceDepartureFlight + finalPriceReturnFlight;
        System.out.println("Actual price after adding departure price with return price: " + totalPrice);
        Assert.assertEquals(actualPrice, totalPrice);
        reporter.log(Status.PASS, "Actual price is same after adding departure price with return price");

    }
}
