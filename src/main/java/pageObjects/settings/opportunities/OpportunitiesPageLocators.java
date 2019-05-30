package pageObjects.settings.opportunities;

import org.openqa.selenium.By;

public class OpportunitiesPageLocators {

    /**
     * Constructor
     * It will initialize OpportunitiesPageLocators instance
     */
    public OpportunitiesPageLocators() {
    }

    By btnAddMilestone = By.xpath("//button[text()='Add new Milestone']");
    By popupMilestoneForm = By.className("modal-dialog-box");
    By txtName = By.xpath("//*[contains(@class, 'milestone-modal-name')]");
    By txtDescription = By.xpath("//*[contains(@class, 'milestone-modal-description')]");
    By txtProbability = By.xpath("//*[contains(@class, 'milestone-modal-probability')]");
    By txtDaysUntilStale = By.xpath("//*[contains(@class, 'milestone-modal-days-until-stale')]");
    By btnSave = By.xpath("//button[contains(text(), 'Save')]");
    String dynMilestoneName = "//button[text()='$milestoneName$']";
}
