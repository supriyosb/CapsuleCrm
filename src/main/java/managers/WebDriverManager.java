package managers;

import enums.DriverType;
import enums.EnvironmentType;
import exceptions.AutomationFrameworkException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class WebDriverManager {
    private WebDriver driver;
    private static DriverType driverType;
    private static EnvironmentType environmentType;
    private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";

    /**
     * Constructor
     * It will initialize DriverType and EnvironmentType object
     */
    public WebDriverManager() {
        driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();
        environmentType = FileReaderManager.getInstance().getConfigReader().getEnvironment();
    }

    /**
     * It will return WebDriver instance
     * @return
     */
    public WebDriver getDriver() {
        if(driver == null) driver = createDriver();
        return driver;
    }

    /**
     * It will create WebDriver instance depends on environment type and will return WebDriver instance
     * @return
     */
    private WebDriver createDriver() {
        switch (environmentType) {
            case LOCAL : driver = createLocalDriver();
                break;
            case REMOTE : driver = createRemoteDriver();
                break;
        }
        return driver;
    }

    /**
     * It will create WebDriver instance for selenium grid implementation
     * @return
     */
    private WebDriver createRemoteDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browser", FileReaderManager.getInstance().getConfigReader().getBrowserName());
        capabilities.setCapability("browser_version", FileReaderManager.getInstance().getConfigReader().getBrowserVersion());
        capabilities.setCapability("os", FileReaderManager.getInstance().getConfigReader().getOsName());
        capabilities.setCapability("os_version", FileReaderManager.getInstance().getConfigReader().getOsVersion());
        capabilities.setCapability("resolution", FileReaderManager.getInstance().getConfigReader().getResolution());
        capabilities.setCapability("browserstack.debug", "true");

        try {
            driver = new RemoteWebDriver(new URL(FileReaderManager.getInstance().getConfigReader().getBrowserStackUrl()), capabilities);
        } catch (MalformedURLException e) {
            throw new AutomationFrameworkException("Remote driver is not initialized properly. Error: "+ e.getMessage());
        }

        if(FileReaderManager.getInstance().getConfigReader().getBrowserWindowSize()) driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(), TimeUnit.SECONDS);
        return driver;
    }

    /**
     * It will create local WebDriver instance and return the same
     * @return
     */
    private WebDriver createLocalDriver() {
        switch (driverType) {
            case FIREFOX : driver = new FirefoxDriver();
                break;
            case CHROME :
                System.setProperty(CHROME_DRIVER_PROPERTY, System.getProperty("user.dir") + FileReaderManager.getInstance().getConfigReader().getDriverPath());
                driver = new ChromeDriver();
                break;
            case INTERNETEXPLORER : driver = new InternetExplorerDriver();
                break;
        }

        if(FileReaderManager.getInstance().getConfigReader().getBrowserWindowSize()) driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(), TimeUnit.SECONDS);
        return driver;
    }

    /**
     * It will end the WebDriver instance
     */
    public void closeDriver() {
        driver.close();
        driver.quit();
    }
}
