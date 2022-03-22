package tests;

import driver.manager.DriverUtils;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.objects.LoginPage;
import page.objects.TopMenuPage;

import static navigation.ApplicationURLs.APPLICATION_URL;

public class TopMenuTest extends TestBase {

    @TmsLink("ID-2344")
    @Severity(SeverityLevel.NORMAL)
    @Test
    @Description("Verify that, after clicking the \"Contact us\" link, " +
            "the user will be redirected to the \"CONTACT US\" page. ")
    public void asUserEnterContactUsPage() {
        DriverUtils.navigateToPage(APPLICATION_URL);

        TopMenuPage topMenuPage = new TopMenuPage();
        topMenuPage.clickOnContactUsLink().assertThatContactUsLabelTextIsDisplayed("CONTACT US");
    }

    @Issue("DEFECT-12889")
    @TmsLink("ID-2345")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    @Description("Verify that, after clicking the \"Sign In\" link, " +
            "the user will be redirected to the login page.")
    public void asUserEnterLoginPage() {
        DriverUtils.navigateToPage(APPLICATION_URL);

        TopMenuPage topMenuPage = new TopMenuPage();
        topMenuPage.clickOnSignInLink();

        LoginPage loginPage = new LoginPage();
        loginPage.assertThatWarningMessageIsDisplayed("Log in to your account");

    }
}
