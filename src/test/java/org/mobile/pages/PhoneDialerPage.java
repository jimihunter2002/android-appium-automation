package org.mobile.pages;

import com.vladsch.flexmark.ast.DelimitedLinkNode;
import io.appium.java_client.pagefactory.AndroidBy;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import java.time.Duration;

import static java.time.temporal.ChronoUnit.SECONDS;

public class PhoneDialerPage extends PageObject {

    @FindBy(className = "android.widget.FrameLayout")
    private WebElementFacade phoneDialerPageLayout;

    @FindBy(accessibilityId = "key pad")
    private WebElementFacade keypadMenu;

    @FindBy(xpath = "//android.widget.TextView[contains(@text, 'To get contact information for places near you, allow access to your location.')]")
    private WebElementFacade dialerPermissionTextArea;

    @FindBy(accessibilityId = "dial")
    private WebElementFacade dialIcon;

    @FindBy(id = "com.android.dialer:id/digits")
    private WebElementFacade phoneNumberTextbox;

    @FindBy(id = "com.android.dialer:id/contactgrid_contact_name")
    private WebElementFacade contactDialerPage;

    @FindBy(accessibilityId = "End call")
    private WebElementFacade endCallIcon;


    public void waitUntilDailerPageAppear(){
//        phoneDialerPageLayout.withTimeoutOf(Duration.of(30, SECONDS)).waitUntilVisible();
        phoneDialerPageLayout.withTimeoutOf(Duration.of(30, SECONDS)).waitUntilEnabled();
    }

    public void clickDialerKeypadMenu() {
        keypadMenu.click();
    }

    public String getTextFromDialerPage() {
        return dialerPermissionTextArea.getText();
    }

    public void waitForDialIconToAppear() {
        dialIcon.withTimeoutOf(Duration.of(30, SECONDS)).waitUntilVisible();
    }

    public void enterPhoneNumberToDial(String phoneNumber) {

        phoneNumberTextbox.sendKeys(phoneNumber);
        dialIcon.click();
    }


    public String getTextContactDialed() {

        return contactDialerPage.getText();
    }

    public void endCall() {
        endCallIcon.click();
    }
    public boolean isContactDialedPresent() {
        this.endCall();
        return contactDialerPage.isCurrentlyVisible();
    }
}
