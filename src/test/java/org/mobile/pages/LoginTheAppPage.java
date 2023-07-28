package org.mobile.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import java.time.Duration;

import static java.time.temporal.ChronoUnit.SECONDS;

public class LoginTheAppPage extends PageObject {

    @FindBy(className = "android.widget.FrameLayout")
    private WebElementFacade homePageLayout;

    @FindBy(accessibilityId = "Login Screen")
    private WebElementFacade loginScreen;

    @FindBy(accessibilityId = "username")
    private WebElementFacade usernameInput;
    @FindBy(accessibilityId = "password")
    private WebElementFacade passwordInput;

    @FindBy(accessibilityId = "loginBtn")
    private WebElementFacade loginButton;

    @FindBy(xpath = "//android.widget.TextView[contains(@text, 'You are logged in as')]")
    private WebElementFacade secretArea;

    public void waitUntilHomePageAppear() {
        homePageLayout.withTimeoutOf(Duration.of(30, SECONDS)).waitUntilVisible();
    }

    public void clickLoginScreen() {
        loginScreen.click();
    }

    public void inputUsername(String username) {
        usernameInput.type(username);
    }

    public void inputPassword(String password) {
        passwordInput.type(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public String getTextWithUsernameInScreenArea() {
        return secretArea.getText();
    }
}
