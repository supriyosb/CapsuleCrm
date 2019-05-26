package managers;

import org.openqa.selenium.WebDriver;
import pageObjects.flight.FlightPageKeyword;
import pageObjects.flightlist.FlightListPageKeyword;
import pageObjects.home.HomePageKeyword;
import pageObjects.login.LoginPageKeyword;
import pageObjects.user.UserPageKeyword;

public class PageObjectManager {

    private WebDriver driver;
    private HomePageKeyword homePage;
    private LoginPageKeyword loginPage;
    private UserPageKeyword userPage;

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
     * It will return LoginPageKeyword instance
     * @return
     */
    public LoginPageKeyword getLoginPage(){
        return (loginPage == null) ? loginPage = new LoginPageKeyword(driver) : loginPage;
    }

    public UserPageKeyword getUserPage(){
        return (userPage == null) ? userPage = new UserPageKeyword(driver) : userPage;
    }
}
