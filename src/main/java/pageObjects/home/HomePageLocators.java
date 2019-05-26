package pageObjects.home;

import org.openqa.selenium.By;

public class HomePageLocators {

    /**
     * Constructor
     * It will initialize HomePageLocators
     */
    public HomePageLocators() {
    }

    String linkFlights = "//span[text()='Flights']/parent::a";
    By linkUser = By.xpath("//a[@aria-label='People & Organisations']");
}
