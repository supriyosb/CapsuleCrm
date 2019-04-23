package base;

import helper.TestContext;
import managers.FileReaderManager;
import org.testng.annotations.*;

import java.io.File;

public class TestBase extends TestContext {

    /**
     * This will execute before class to setup
     * @throws Exception
     */
    @BeforeClass(alwaysRun = true)
    public void setUpClass() throws Exception {

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
    public void afterMethod(){

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
