package tests;

import driver.manager.DriverUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.objects.LoginPage;

import static navigation.ApplicationURLs.LOGIN_URL;

public class LoginTest extends TestBase {

    @Test
    public void asUserLoginUsingValidLoginAndPassword() {
        DriverUtils.navigateToPage(LOGIN_URL);

        LoginPage loginPage = new LoginPage();
        String userName = loginPage
                .typeIntoUserNameField("janek.bury@webowo.pl")
                .typeIntoPasswordField("JanekBury")
                .clickOnSignInButton()
                .getUserName();

        Assert.assertEquals(userName, "Janek Bury");
    }

    @Test
    public void asUserTryToLoginUsingIncorrectLoginAndPassword() {
        DriverUtils.navigateToPage(LOGIN_URL);

        LoginPage loginPage = new LoginPage();
        String authenticationAlertText = loginPage
                .typeIntoUserNameField("NotExisting.login@webowo.pl")
                .typeIntoPasswordField("NotExistingPassword")
                .clickOnSignInButton()
                .getAuthenticationAlertText();

        Assert.assertEquals(authenticationAlertText, "Authentication failed.");
    }
}

