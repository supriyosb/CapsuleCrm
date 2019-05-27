package pageObjects.cases;

import org.openqa.selenium.By;

public class CasePageLocator {

    /**
     * Constructor
     * It will initialize CasePageLocator instance
     */
    public CasePageLocator() {
    }

    By btnAddCase = By.linkText("Add Case");
    By txtPartySearch = By.id("partySearch");
    String dynSearchResult = "//div[@class='searchresult']//*[contains(text(), '$name$')]";
    By txtCaseName = By.id("caseNameDecorate:name");
    By txtTag = By.id("tagsDecorate:tagComboBox");
    By btnAddTag = By.xpath("//input[@value='Add tag']");
    By txtCaseDescription = By.id("caseDescriptionDecorate:description");
    By btnSave = By.id("save");
    By labelCaseName = By.className("entity-details-title");
    By labelCaseOwner = By.xpath("//div[@class='entity-details-party']//a");
    By labelCaseStatus = By.xpath("//div[contains(@class, 'kase-summary-status')]/span");
}
