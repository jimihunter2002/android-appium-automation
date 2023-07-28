package org.mobile.steps.serenity;

import net.thucydides.core.annotations.Step;
import org.mobile.pages.PhoneDialerPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class PhoneDialerSteps {


    PhoneDialerPage phoneDialerPage;

    @Step
    public void waitForDialerHomeVisible() {
        phoneDialerPage.waitUntilDailerPageAppear();
    }

    @Step
    public void clickDialerKeypadMenu() {
        phoneDialerPage.clickDialerKeypadMenu();
    }

    @Step
    public void validateUserLaunchedDialerSuccessfully() {
        phoneDialerPage.waitForDialIconToAppear();
//        assertThat("Phone dialer is not displayed", phoneDialerPage.getTextFromDialerPage()
//                , equalTo("To get contact information for places near you, allow access to your location.") );
    }

    @Step
    public void inputPhoneNumber(String phoneNumber) {
        phoneDialerPage.enterPhoneNumberToDial(phoneNumber);
    }

    @Step
    public void validatePhonenumberDialedSuccessfully(String phoneNumber) {
        assertThat("Wrong contact", phoneDialerPage.getTextContactDialed()
                , equalTo(phoneNumber) );
    }

    @Step
    public void validateUserEndsCallSuccessfully() {
        assertThat("Call did not end properly", phoneDialerPage.isContactDialedPresent(),
                equalTo(false));
    }
}
