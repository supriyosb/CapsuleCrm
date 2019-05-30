package pageObjects.settings.tags;

import org.openqa.selenium.By;

public class TagsPageLocators {

    /**
     * Constructor
     * It will initialize TagsPageLocators instance
     */
    public TagsPageLocators() {
    }

    By linkAddNewTag = By.linkText("Add new Tag");
    By txtTagName = By.xpath("//input[contains(@id, 'tagNameDecorate:tagName')]");
    By btnSave = By.xpath("//input[@value='Save']");
    String dynTagDelete = "//a[text()='$tagName$']/ancestor::td/following-sibling::td//a[text()='Delete']";
    By deleteTagConf = By.xpath("//input[@value='Delete tag']");
    By deletePopup = By.id("deleteTagModal");
}
