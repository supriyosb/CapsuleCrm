import base.TestBase;
import org.testng.annotations.Test;

public class TC02 extends TestBase {

    @Test(priority = 0)
    public void addUserAndAddCase(){

        //Initializing reporter log
        reporter = extentReports.createTest("Launch Application, Account Settings Related Activity", "To verify application is launching and user is able to perform various activities in account settings");
        getPageObjectManager().setReporter(reporter);

        //Navigating to login page
        getPageObjectManager().getLoginPage().openApplication();

        //Perform login operation
        getPageObjectManager().getLoginPage().login(model.getUsername(), model.getPassword());

        //Navigating to account settings page
        getPageObjectManager().getHomePage().navigateToAccountSettingsOption();

        //Verify header of account settings page
        getPageObjectManager().getSettingsPage().verifyAccountSettingsPageOpened();

        //Verify header sections of each options
        getPageObjectManager().getSettingsPage().verifyHeadersOfEachOptions();

        //Open appearance page
        getPageObjectManager().getSettingsPage().clickLinkOptions(model.getLinkAppearance());

        //Uploading logo file
        getPageObjectManager().getSettingsPage().getAppearancePage().uploadLogo(model.getLogoName());

        //Open user page
        getPageObjectManager().getSettingsPage().clickLinkOptions(model.getLinkUser());

        //Inviting user
        getPageObjectManager().getSettingsPage().getUserPage().inviteUser(model);

        //Verify newly invited user
        getPageObjectManager().getSettingsPage().getUserPage().verifyNewlyInvitedUser(model.getSettingsUserName(), model.getEmail());

        //Open opportunity page
        getPageObjectManager().getSettingsPage().clickLinkOptions(model.getLinkOpportunity());

        //Add new milestone and verify
        getPageObjectManager().getSettingsPage().getOpportunitiesPage().addNewMilestoneAndVerify(model);

        //Open track page
        getPageObjectManager().getSettingsPage().clickLinkOptions(model.getLinkTracks());

        //Adding new track
        getPageObjectManager().getSettingsPage().getTrackPage().addNewTrack(model);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
