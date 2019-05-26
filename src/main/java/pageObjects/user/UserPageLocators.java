package pageObjects.user;

import org.openqa.selenium.By;

public class UserPageLocators {

    /**
     * Constructor
     * It will initialize UserPageLocators instance
     */
    public UserPageLocators() {
    }

    By linkAddUser = By.partialLinkText("Add Person");
    By txtFirstName = By.id("party:fnDecorate:fn");
    By txtLastName = By.id("party:lnDecorate:ln");
    By txtTag = By.id("party:tagsDecorate:tagComboBox");
    By btnAddTag = By.xpath("//input[@value='Add tag']");
    By txtPhoneNumber = By.xpath("//input[contains(@id,'phnDecorate:number')]");
    By txtEmail = By.xpath("//input[contains(@id,'emlDecorate:nmbr')]");
    By btnSave = By.id("party:save");
    By lablePartyTitle = By.xpath("//span[@class='party-details-title']");
    String dynPartyRow = "//tbody//td//a[text()='$name$']/parent::td/following-sibling::td//a[text()='$email$']/ancestor::td/following-sibling::td//*[text()='$phone$']";
}
