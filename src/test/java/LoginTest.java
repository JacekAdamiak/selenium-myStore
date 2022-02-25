import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
//        System.setProperty("webdriver.gecko.driver","src/main/resources/drivers/geckodriver.exe");
//        driver = new FirefoxDriver();
    }

    @Test
    public void asUserEnterLoginPage() {
        driver.navigate().to("https://prod-kurs.coderslab.pl/");

        TopMenuPage topMenuPage = new TopMenuPage(driver);
        topMenuPage.clickOnSignInLink();

        LoginPage loginPage = new LoginPage(driver);
        assertEquals(loginPage.getWelcomeText(driver), "Log in to your account");
    }

    @Test
    public void asUserLoginUsingValidLoginAndPassword() {
        driver.navigate().to("https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=my-account");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoUserNameField("janek.bury@webowo.pl");
        loginPage.typeIntoPasswordField("JanekBury");
        loginPage.clickOnSignInButton();

        TopMenuPage topMenuPage = new TopMenuPage(driver);
        assertEquals(topMenuPage.getUserName(), "Janek Bury");
    }

    @Test
    public void asUserTryToLoginUsingIncorrectLoginAndPassword() {
        driver.navigate().to("https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=my-account");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoUserNameField("NotExisting.login@webowo.pl");
        loginPage.typeIntoPasswordField("NotExistingPassword");
        loginPage.clickOnSignInButton();
        assertEquals(loginPage.getAuthenticationAlertText(driver), "Authentication failed.");
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}

