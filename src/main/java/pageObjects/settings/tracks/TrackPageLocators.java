package pageObjects.settings.tracks;

import org.openqa.selenium.By;

public class TrackPageLocators {

    /**
     * Constructor
     * It will initialize TrackPageLocators instance
     */
    public TrackPageLocators() {
    }

    By linkAddNewTrack = By.linkText("Add new Track");
    By txtTrackName = By.xpath("//input[contains(@id, 'trackDescriptionDecorate:trackDescription')]");
    By txtTrackTag = By.xpath("//input[contains(@id, 'trackTagDecorate:trackTag')]");
    By txtTaskDecription = By.xpath("//input[contains(@id, 'taskDescriptionDecorate:taskDescription')]");
    By ddCatagory = By.xpath("//span[contains(@class, 'ui-selectmenu-button')]");
    String dynCatagoryItem = "//li[contains(text(),'$catagory$')]";
    By txtTaskDays = By.xpath("//input[contains(@id, 'taskDaysAfterDecorate:taskDaysAfter')]");
    By linkSave = By.linkText("Save");
}
