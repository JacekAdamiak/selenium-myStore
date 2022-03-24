package tests;

import driver.manager.DriverUtils;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.objects.LoginPage;

import static navigation.ApplicationURLs.LOGIN_URL;

public class LoginTest extends TestBase {

    @Issue("DEFECT-12997")
    @TmsLink("ID-2315")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Description("Verify that if the user log in using proper username and password " +
            "his first name and last name are displayed on right side of top menu")
//    @Step("Navigate to page URL: {LOGIN_URL}")
    public void asUserLoginUsingValidLoginAndPassword() {
        DriverUtils.navigateToPage(LOGIN_URL);

        LoginPage loginPage = new LoginPage();
        loginPage.typeIntoUserNameField("janek.bury@webowo.pl")
                .typeIntoPasswordField("JanekBury")
                .clickOnSignInButton().assertThatUserNameIsDisplayed("--Janek Bury");
    }

    @TmsLink("ID-2316")
    @Severity(SeverityLevel.NORMAL)
    @Test
    @Description("Verify that if the user log in using not proper username and password " +
            "warning message \"Authentication failed.\" is displayed")
//    @Step("Navigate to page URL: {LOGIN_URL}")
    public void asUserTryToLoginUsingIncorrectLoginAndPassword() {
        DriverUtils.navigateToPage(LOGIN_URL);

        LoginPage loginPage = new LoginPage();
        loginPage.typeIntoUserNameField("NotExisting.login@webowo.pl")
                .typeIntoPasswordField("NotExistingPassword")
                .clickOnSignInButton()
                .assertThatAuthenticationAlertTextIsDisplayed("Authentication failed.");
    }
}

