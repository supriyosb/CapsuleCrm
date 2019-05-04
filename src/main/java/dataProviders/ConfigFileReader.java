package dataProviders;

import enums.DriverType;
import enums.EnvironmentType;
import exceptions.AutomationFrameworkException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

    private Properties properties;
    private final String propertyFilePath= "configs/Configuration.properties";

    /**
     * Constructor
     * This will read the property file and load it
     */
    public ConfigFileReader() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new AutomationFrameworkException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    /**
     * It will return the driver path
     * @return
     */
    public String getDriverPath(){
        String driverPath = properties.getProperty("driverPath");
        if(driverPath!= null) return driverPath;
        else throw new AutomationFrameworkException("driverPath not specified in the Configuration.properties file.");
    }

    /**
     * It will return value of implicitly wait from Configuration.properties file
     * @return
     */
    public long getImplicitlyWait() {
        String implicitlyWait = properties.getProperty("implicitlyWait");
        if(implicitlyWait != null) return Long.parseLong(implicitlyWait);
        else throw new AutomationFrameworkException("implicitlyWait not specified in the Configuration.properties file.");
    }

    /**
     * It will return the application url from Configuration.properties file
     * @return
     */
    public String getApplicationUrl() {
        String url = properties.getProperty("url");
        if(url != null) return url;
        else throw new AutomationFrameworkException("url not specified in the Configuration.properties file.");
    }

    /**
     * It will return the browser type from Configuration.properties file
     * E.g. Chrome, Firefox, IE
     * @return
     */
    public DriverType getBrowser() {
        String browserName = properties.getProperty("browser");
        if(browserName == null || browserName.equals("chrome")) return DriverType.CHROME;
        else if(browserName.equalsIgnoreCase("firefox")) return DriverType.FIREFOX;
        else if(browserName.equals("iexplorer")) return DriverType.INTERNETEXPLORER;
        else throw new AutomationFrameworkException("Browser Name Key value in Configuration.properties is not matched : " + browserName);
    }

    /**
     * It will return environment type from Configuration.properties file
     * E.g. local, remote
     * @return
     */
    public EnvironmentType getEnvironment() {
        String environmentName = properties.getProperty("environment");
        if(environmentName == null || environmentName.equalsIgnoreCase("local")) return EnvironmentType.LOCAL;
        else if(environmentName.equals("remote")) return EnvironmentType.REMOTE;
        else throw new AutomationFrameworkException("Environment Type Key value in Configuration.properties is not matched : " + environmentName);
    }

    /**
     * It will return the boolean value to maximize window from Configuration.properties file
     * True will maximize the window
     * False will not maximize the window
     * @return
     */
    public Boolean getBrowserWindowSize() {
        String windowSize = properties.getProperty("windowMaximize");
        if(windowSize != null) return Boolean.valueOf(windowSize);
        return true;
    }

    /**
     * It will return the report configuration file path from Configuration.properties file
     * @return
     */
    public String getReportConfigPath(){
        String reportConfigPath = properties.getProperty("reportConfigPath");
        if(reportConfigPath!= null) return reportConfigPath;
        else throw new AutomationFrameworkException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");
    }

    /**
     * It will return the author name for report from Configuration.properties file
     * @return
     */
    public String getAuthor(){
        String author = properties.getProperty("author");
        if(author!= null) return author;
        else throw new AutomationFrameworkException("Author not specified in the Configuration.properties file for the Key:author");
    }

    /**
     * It will return report name for report from Configuration.properties file
     * @return
     */
    public String getReportName(){
        String reportName = properties.getProperty("reportName");
        if(reportName!=null) return reportName;
        else throw new AutomationFrameworkException("Report Name not specified in the Configuration.properties file for the Key:reportName");
    }

    /**
     * It will return report title for report from Configuration.properties file
     * @return
     */
    public String getReportTitle(){
        String reportTitle = properties.getProperty("reportTitle");
        if(reportTitle!=null) return reportTitle;
        else throw new AutomationFrameworkException("Report Title not specified in the Configuration.properties file for the Key:reportTitle");
    }

    /**
     * It will return time stramp format for report from Configuration.properties file
     * @return
     */
    public String getReportTimeStrampFormat(){
        String reportTimeStrampFormat = properties.getProperty("reportTimeStrampFormat");
        if(reportTimeStrampFormat!=null) return reportTimeStrampFormat;
        else throw new AutomationFrameworkException("Report TimeStrampFormat not specified in the Configuration.properties file for the Key:reportTimeStrampFormat");
    }

    /**
     * It will return the test data path from Configuration.properties file
     * @return
     */
    public String getTestDataPath(){
        String testDataPath = properties.getProperty("testDataPath");
        if(testDataPath!=null) return testDataPath;
        else throw new AutomationFrameworkException("Test Data Path not specified in the Configuration.properties file for the Key:testDataPath");
    }

    /**
     * It will return browser stack username from Configuration.properties file
     * @return
     */
    public String getBrowserStackUsername(){
        String browserStackUsername = properties.getProperty("browserStackUsername");
        if(browserStackUsername!=null) return browserStackUsername;
        else throw  new AutomationFrameworkException("Browser stack username not specified in the Configuration.properties file for the Key:browserStackUsername");
    }

    /**
     * It will return browser stack access key from Configuration.properties file
     * @return
     */
    public String getBrowserStackAccessKey(){
        String browserStackAccessKey = properties.getProperty("browserStackAccessKey");
        if (browserStackAccessKey!=null) return browserStackAccessKey;
        else throw new AutomationFrameworkException("Browser stack access key not specified in the Configuration.properties file for the kwy:browserStackAccessKey");
    }

    /**
     * It will return browser stack url from Configuration.properties file
     * @return
     */
    public String getBrowserStackUrl(){
        String browserStackURL = properties.getProperty("browserStackURL");
        browserStackURL = browserStackURL.replace("$browserStackUsername$", getBrowserStackUsername()).replace("$browserStackAccessKey$", getBrowserStackAccessKey());
        if (browserStackURL!=null) return browserStackURL;
        else throw new AutomationFrameworkException("Browser stack URL not specified in the Configuration.properties file for the Key:browserStackURL");
    }

    /**
     * It will return browser name from Configuration.properties file
     * @return
     */
    public String getBrowserName(){
        String browserName = properties.getProperty("browserName");
        if (browserName!=null) return browserName;
        else throw new AutomationFrameworkException("Browser name not specified in the Configuration.properties file for the Key:browserName");

    }

    /**
     * It will return browser version from Configuration.properties file
     * @return
     */
    public String getBrowserVersion(){
        String browserVersion = properties.getProperty("browserVersion");
        if (browserVersion!=null) return browserVersion;
        else throw new AutomationFrameworkException("Browser version not specified in the Configuration.properties file for the Key:browserVersion");
    }

    /**
     * It will return OS name from Configuration.properties file
     * @return
     */
    public String getOsName(){
        String osName = properties.getProperty("osName");
        if (osName!=null) return osName;
        else throw new AutomationFrameworkException("OS name not specified in the Configuration.properties file for the Key:osName");

    }

    /**
     * It will return OS version from Configuration.properties file
     * @return
     */
    public String getOsVersion(){
        String osVersion = properties.getProperty("osVersion");
        if (osVersion!=null) return osVersion;
        else throw new AutomationFrameworkException("OS version not specified in the Configuration.properties file for the Key:osVersion");
    }

    /**
     * It will return resolution from Configuration.properties file
     * @return
     */
    public String getResolution(){
        String resolution = properties.getProperty("resolution");
        if (resolution!=null) return resolution;
        else throw new AutomationFrameworkException("Resolution not specified in the Configuration.properties file for the Key:resolution");
    }
}
