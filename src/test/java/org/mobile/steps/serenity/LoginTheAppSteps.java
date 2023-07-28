package org.mobile.steps.serenity;

import net.thucydides.core.annotations.Step;
import org.mobile.pages.LoginTheAppPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class LoginTheAppSteps {
    LoginTheAppPage loginTheAppPage;

    @Step
    public void waitForHomePageVisible(){
    loginTheAppPage.waitUntilHomePageAppear();
    }

    @Step
    public void clickLoginScreen() { loginTheAppPage.clickLoginScreen();}

    @Step
    public void inputUsername(String username){
        loginTheAppPage.inputUsername(username);
    }

    @Step
    public void inputPassword(String password) {
        loginTheAppPage.inputPassword(password);
    }

    @Step
    public void clickLoginButton() {
        loginTheAppPage.clickLoginButton();
    }

    @Step
    public void validateUserLoginSuccessfully() {
        assertThat("User is not alice",loginTheAppPage.getTextWithUsernameInScreenArea()
                , equalTo("You are logged in as alice") );
    }

}
