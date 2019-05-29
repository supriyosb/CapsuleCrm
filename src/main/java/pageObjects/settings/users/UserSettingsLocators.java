package pageObjects.settings.users;

import org.openqa.selenium.By;

public class UserSettingsLocators {

    /**
     * Constructor
     * It will initialize UserSettingsLocators instance
     */
    public UserSettingsLocators() {
    }

    By btnAddNewUser = By.linkText("Add new User");
    By txtFirstName = By.id("register:firstnameDecorate:firstName");
    By txtLastname = By.id("register:lastNameDecorate:lastName");
    By txtEmail = By.id("register:emailDecorate:email");
    By txtUsername = By.id("register:usernameDecorate:username");
    By btnInviteUser = By.id("register:save");
    By linkDeleteUser = By.linkText("Delete user");
    By linkDeletePopup = By.linkText("Delete");
    String dynUser = "//td[contains(text(),'$username$')]/following-sibling::td[contains(text(),'$email$')]";
}
