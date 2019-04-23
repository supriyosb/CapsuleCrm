package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import dataProviders.DataModel;
import dataReader.parser.DataParser;
import dataReader.parser.ExcelParser;
import helper.TestContext;
import managers.FileReaderManager;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestBase extends TestContext {

    public ExtentReports extentReports;
    public ExtentTest reporter;
    public DataModel model;

    /**
     * This will execute before class to setup
     * @throws Exception
     */
    @BeforeClass(alwaysRun = true)
    public void setUpClass() throws Exception {
        extentReports = getReportManager().getExtentReports();
        try(InputStream inputStream = new FileInputStream(System.getProperty("user.dir") + FileReaderManager.getInstance().getConfigReader().getTestDataPath())) {
            model = ExcelParser.toModelList(DataParser.fromXls(inputStream, 0), DataModel.class).get(0);
        }
    }

    /**
     * This will execute after class to clear all instance of execution
     */
    @AfterClass
    public void tearDown(){
        getWebDriverManager().closeDriver();
    }

    /**
     * This will execute before method
     */
    @BeforeMethod
    public void beforeMethod(){

    }

    /**
     * This will execute after method
     */
    @AfterMethod
    public void getResult(ITestResult result) throws IOException {
        if(result.getStatus() == ITestResult.FAILURE) {
            String temp = Utility.getScreenshot(getWebDriverManager().getDriver());
            reporter.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED ", ExtentColor.RED));
            reporter.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
        }
        else if(result.getStatus() == ITestResult.SUCCESS) {
            reporter.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED ", ExtentColor.GREEN));
        }
        else {
            reporter.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" SKIPPED ", ExtentColor.ORANGE));
            reporter.skip(result.getThrowable());
        }
    }

    /**
     * This will execute before test method
     */
    @BeforeTest
    public void beforeTest(){

    }

    /**
     * This will execute after execution of test method got completed
     */
    @AfterTest
    public void afterTest(){
        extentReports.flush();
    }

    /**
     * This will execute before suite
     */
    @BeforeSuite
    public void beforeSuite(){

    }

    /**
     * This will execute after suite
     */
    @AfterSuite
    public void afterSuite(){

    }
}
