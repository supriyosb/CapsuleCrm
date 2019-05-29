package pageObjects.settings.appearrance;

import org.openqa.selenium.By;

public class AppearancePageLocators {

    /**
     * It will initialize AppearancePageLocators instance
     */
    public AppearancePageLocators() {
    }

    By fileLogoInput = By.id("appearance:uploadDecorate:logoImage");
    By linkSave = By.linkText("Save");
}
