package tests;

import driver.manager.DriverUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.objects.LoginPage;

public class LoginTest extends TestBase {

    @Test
    public void asUserLoginUsingValidLoginAndPassword() {
        DriverUtils.navigateToPage("https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=my-account");

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
        DriverUtils.navigateToPage("https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=my-account");

        LoginPage loginPage = new LoginPage();
        String authenticationAlertText = loginPage
                .typeIntoUserNameField("NotExisting.login@webowo.pl")
                .typeIntoPasswordField("NotExistingPassword")
                .clickOnSignInButton()
                .getAuthenticationAlertText();

        Assert.assertEquals(authenticationAlertText, "Authentication failed.");
    }
}

