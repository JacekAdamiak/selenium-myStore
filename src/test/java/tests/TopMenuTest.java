package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.objects.ContactUsPage;
import page.objects.LoginPage;
import page.objects.TopMenuPage;

public class TopMenuTest {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
//        System.setProperty("webdriver.gecko.driver","src/main/resources/drivers/geckodriver.exe");
//        driver = new FirefoxDriver();
    }

    @Test
    public void asUserEnterContactUsPage() {
        driver.navigate().to("https://prod-kurs.coderslab.pl/");

        TopMenuPage topMenuPage = new TopMenuPage(driver);
        topMenuPage.clickOnContactUsLink();

//        WebElement contactUsLabel = driver.findElement(By.xpath("//*[@id=\"content\"]/section/form/section/div[1]/div"));
        ContactUsPage contactUsPage = new ContactUsPage(driver);



        System.out.println(contactUsPage.getContactUsLabelText());
        Assert.assertEquals(contactUsPage.getContactUsLabelText(),
                "CONTACT US");
    }

    @Test
    public void asUserEnterLoginPage() {
        driver.navigate().to("https://prod-kurs.coderslab.pl/");

        TopMenuPage topMenuPage = new TopMenuPage(driver);
        topMenuPage.clickOnSignInLink();

        LoginPage loginPage = new LoginPage(driver);
        Assert.assertEquals(loginPage.getWelcomeText(), "Log in to your account");
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
