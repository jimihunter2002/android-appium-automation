package org.mobile.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.mobile.steps.serenity.LoginTheAppSteps;
import org.mobile.steps.serenity.PhoneDialerSteps;

public class DefinitionSteps {

    @Steps
    LoginTheAppSteps loginTheAppSteps;

    @Steps
    PhoneDialerSteps phoneDialerSteps;

    @Given("user Open TheApp Application")
    public void userOpenTheAppApplication() {
        loginTheAppSteps.waitForHomePageVisible();
    }

    @When("Click On Login Screen")
    public void clickOnLoginScreen() {
        loginTheAppSteps.clickLoginScreen();
    }

    @And("User type {string} on username password with {string}")
    public void userTypeOnUsernamePasswordWith(String username, String password) {
        loginTheAppSteps.inputUsername(username);
        loginTheAppSteps.inputPassword(password);
        loginTheAppSteps.clickLoginButton();
    }

    @Then("user should be able to see login profile")
    public void userShouldBeAbleToSeeLoginProfile() {
        loginTheAppSteps.validateUserLoginSuccessfully();
    }

    @Given("user launched PhoneDialerApp Application")
    public void userLaunchedPhoneDialerAppApplication() {
        phoneDialerSteps.waitForDialerHomeVisible();
    }


    @When("Click On dialer keypad menu to display numbers")
    public void clickOnDialerKeypadMenuToDisplayNumbers() {
        phoneDialerSteps.clickDialerKeypadMenu();
    }

    @Then("user should be able to see the dial button")
    public void userShouldBeAbleToSeeTheDialButton() {
        phoneDialerSteps.validateUserLaunchedDialerSuccessfully();
    }

    @And("User dial the number {string}")
    public void userDialTheNumber(String phoneNumber) {
        phoneDialerSteps.inputPhoneNumber(phoneNumber);
    }

    @Then("number {string} should be dialed successfully")
    public void numberShouldBeDialedSuccessfully(String phoneNumber) {
        phoneDialerSteps.validatePhonenumberDialedSuccessfully(phoneNumber);
    }

    @And("user ends the call successfully")
    public void userEndsTheCallSuccessfully() {
        phoneDialerSteps.validateUserEndsCallSuccessfully();
    }
}
