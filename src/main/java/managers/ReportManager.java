package managers;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportManager {

    private ExtentHtmlReporter htmlReporter;
    private ExtentReports extentReports;

    public ReportManager() {

    }

    /**
     * It will return ExtentReports instance
     * @return
     */
    public ExtentReports getExtentReports(){
        if(extentReports == null) extentReports = createReport();
        return extentReports;
    }

    /**
     * It will create extent report with all configuration
     * It will return ExtentReports instance after creation
     * @return
     */
    private ExtentReports createReport(){
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + FileReaderManager.getInstance().getConfigReader().getReportConfigPath());
        extentReports = new ExtentReports();
        extentReports.attachReporter(htmlReporter);
        extentReports.setSystemInfo("Environment", FileReaderManager.getInstance().getConfigReader().getEnvironment().toString());
        extentReports.setSystemInfo("Browser", FileReaderManager.getInstance().getConfigReader().getBrowser().toString());
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle(FileReaderManager.getInstance().getConfigReader().getReportTitle());
        htmlReporter.config().setReportName(FileReaderManager.getInstance().getConfigReader().getReportName());
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setTimeStampFormat(FileReaderManager.getInstance().getConfigReader().getReportTimeStrampFormat());
        return extentReports;
    }
}
