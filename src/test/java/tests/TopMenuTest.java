package tests;

import driver.manager.DriverUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.objects.ContactUsPage;
import page.objects.LoginPage;
import page.objects.TopMenuPage;

public class TopMenuTest extends TestBase{

    @Test
    public void asUserEnterContactUsPage() {
        DriverUtils.navigateToPage("https://prod-kurs.coderslab.pl/");

        TopMenuPage topMenuPage = new TopMenuPage();
        topMenuPage.clickOnContactUsLink();

        ContactUsPage contactUsPage = new ContactUsPage();
        Assert.assertEquals(contactUsPage.getContactUsLabelText(), "CONTACT US");
    }

    @Test
    public void asUserEnterLoginPage() {
        DriverUtils.navigateToPage("https://prod-kurs.coderslab.pl/");

        TopMenuPage topMenuPage = new TopMenuPage();
        topMenuPage.clickOnSignInLink();

        LoginPage loginPage = new LoginPage();
        Assert.assertEquals(loginPage.getWelcomeText(), "Log in to your account");
    }
}
