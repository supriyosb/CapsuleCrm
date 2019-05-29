package pageObjects.settings;

import org.openqa.selenium.By;

public class SettingsPageLocators {

    /**
     * Constructor
     * It will initialize SettingsPageLocators instance
     */
    public SettingsPageLocators() {
    }

    By lableSettingsHeader = By.xpath("//span[contains(text(),'Account Settings')]");
    By linkAllOptions = By.xpath("//ul[@class='nav-panel' or @class='settings-nav']//a");
    By labelOptionsHeader = By.xpath("//*[@class='settings-page-header' or @class='page-box-header']");
}
