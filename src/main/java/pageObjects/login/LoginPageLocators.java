package pageObjects.login;

import org.openqa.selenium.By;

public class LoginPageLocators {

    /**
     * Constructor
     * It will initialize LoginPageLocators instance
     */
    public LoginPageLocators() {
    }

    By txtUsername = By.id("login:usernameDecorate:username");
    By txtPassword = By.id("login:passwordDecorate:password");
    By btnLogin = By.id("login:login");
}
