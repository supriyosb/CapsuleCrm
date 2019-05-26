import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC01 extends TestBase {

    @Test(priority = 0)
    public void addUserAndAddCase(){

        //Initializing reporter log
        reporter = extentReports.createTest("Launch Application, Add user and Add Case", "To verify application is launching and user is able to perform user addition and case addition");

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
        Assert.assertTrue(flag);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
