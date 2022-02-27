package tests;

import driver.manager.DriverUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.objects.LoginPage;
import page.objects.TopMenuPage;

public class LoginTest extends TestBase{

    @Test
    public void asUserLoginUsingValidLoginAndPassword() {
        DriverUtils.navigateToPage("https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=my-account");

        LoginPage loginPage = new LoginPage();
        loginPage.typeIntoUserNameField("janek.bury@webowo.pl");
        loginPage.typeIntoPasswordField("JanekBury");
        loginPage.clickOnSignInButton();

        TopMenuPage topMenuPage = new TopMenuPage();
        Assert.assertEquals(topMenuPage.getUserName(), "Janek Bury");
    }

    @Test
    public void asUserTryToLoginUsingIncorrectLoginAndPassword() {
        DriverUtils.navigateToPage("https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=my-account");

        LoginPage loginPage = new LoginPage();
        loginPage.typeIntoUserNameField("NotExisting.login@webowo.pl");
        loginPage.typeIntoPasswordField("NotExistingPassword");
        loginPage.clickOnSignInButton();
        Assert.assertEquals(loginPage.getAuthenticationAlertText(), "Authentication failed.");
    }

}

