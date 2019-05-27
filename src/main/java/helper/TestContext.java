package helper;

import managers.PageObjectManager;
import managers.ReportManager;
import managers.WebDriverManager;

public class TestContext {
    private WebDriverManager webDriverManager;
    private PageObjectManager pageObjectManager;
    private ReportManager reportManager;

    /**
     * Constructor
     * It will initialize web driver instance with all page objects
     */
    public TestContext(){
        webDriverManager = new WebDriverManager();
        reportManager = new ReportManager();
        pageObjectManager = new PageObjectManager(webDriverManager.getDriver());
    }

    /**
     * It will return the WebDriverManager instance
     * @return
     */
    public WebDriverManager getWebDriverManager() {
        return webDriverManager;
    }

    /**
     * It will return PageObjectManager instance
     * @return
     */
    public PageObjectManager getPageObjectManager() {
        return pageObjectManager;
    }

    /**
     * It will return ReportManager instance
     * @return
     */
    public ReportManager getReportManager() {
        return reportManager;
    }
}
