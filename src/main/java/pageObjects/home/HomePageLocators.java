package pageObjects.home;

import org.openqa.selenium.By;

public class HomePageLocators {

    /**
     * Constructor
     * It will initialize HomePageLocators
     */
    public HomePageLocators() {
    }

    By linkUser = By.xpath("//a[@aria-label='People & Organisations']");
    By linkCase = By.xpath("//a[@aria-label='Cases']");
}
