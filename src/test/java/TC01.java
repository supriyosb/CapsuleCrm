import base.TestBase;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC01 extends TestBase {

    @Test(priority = 0)
    public void addUserAndAddCase(){

        //Initializing reporter log
        reporter = extentReports.createTest("Launch Application, Add user and Add Case", "To verify application is launching and user is able to perform user addition and case addition");
        getPageObjectManager().setReporter(reporter);

        //Navigating to login page
        getPageObjectManager().getLoginPage().openApplication();

        //Perform login operation
        getPageObjectManager().getLoginPage().login(model.getUsername(), model.getPassword());

        //Clicking user icon from menu bar
        getPageObjectManager().getHomePage().clickUserIcon();

        //Clicking Add Person link
        getPageObjectManager().getUserPage().clickAddUserButton();

        //Adding person
        getPageObjectManager().getUserPage().addPerson(model);

        //Clicking user icon from menu bar
        getPageObjectManager().getHomePage().clickUserIcon();

        //Verifying newly added person inside table
        boolean flag = getPageObjectManager().getUserPage().verifyNewlyAddedPerson(model);
        if (flag){
            reporter.pass("Newly added person is verified");
        } else {
            reporter.fail("Newly added person is not verified");
        }

        //Clicking case icon from menu bar
        getPageObjectManager().getHomePage().clickCaseIcon();

        //Clicking Add case button
        getPageObjectManager().getCasePage().clickAddCaseButton();

        //Adding one case
        getPageObjectManager().getCasePage().addCase(model);

        //Verify newly added case name
        flag = getPageObjectManager().getCasePage().verifyCaseName(model.getCaseName());
        if (flag){
            reporter.pass("Newly added case name is verified");
        } else {
            reporter.fail("Newly added case name is not verified");
        }

        //Verify newly added case owner
        flag = getPageObjectManager().getCasePage().verifyCaseOwner(model.getFullName());
        if (flag){
            reporter.pass("Newly added case owner is verified");
        } else {
            reporter.fail("Newly added case owner is not verified");
        }

        //Verify newly added case status
        flag = getPageObjectManager().getCasePage().verifyCaseStatus(model.getCaseStatus());
        if (flag){
            reporter.pass("Newly added case status is verified");
        } else {
            reporter.fail("Newly added case status is not verified");
        }

    }
}
