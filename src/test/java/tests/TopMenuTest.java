package tests;

import driver.manager.DriverUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.objects.TopMenuPage;

import static navigation.ApplicationURLs.APPLICATION_URL;

public class TopMenuTest extends TestBase {

    @Test
    public void asUserEnterContactUsPage() {
        DriverUtils.navigateToPage(APPLICATION_URL);

        TopMenuPage topMenuPage = new TopMenuPage();
        String contactUsLabelText = topMenuPage
                .clickOnContactUsLink()
                .getContactUsLabelText();

        Assert.assertEquals(contactUsLabelText, "CONTACT US");
    }

    @Test
    public void asUserEnterLoginPage() {
        DriverUtils.navigateToPage(APPLICATION_URL);

        TopMenuPage topMenuPage = new TopMenuPage();
        String welcomeText = topMenuPage
                .clickOnSignInLink()
                .getWelcomeText();

        Assert.assertEquals(welcomeText, "Log in to your account");
    }
}
