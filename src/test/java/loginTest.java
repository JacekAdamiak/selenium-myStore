import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class loginTest {

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

        WebElement signInLink = driver.findElement(By.cssSelector("div[class='user-info'] a"));
        signInLink.click();

        WebElement welcomeTextLabel = driver.findElement(By.className("page-header"));
        assertEquals(welcomeTextLabel.getText(), "Log in to your account");
    }

    @Test
    public void asUserLoginUsingValidLoginAndPassword() {
        driver.navigate().to("https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=my-account");

        WebElement userNameField =  driver.findElement(By.name("email"));
        userNameField.sendKeys("janek.bury@webowo.pl");

        WebElement passwordField =  driver.findElement(By.name("password"));
        passwordField.sendKeys("JanekBury");

        WebElement signInButton = driver.findElement(By.id("submit-login"));
        signInButton.submit();

        WebElement userNameLabel = driver.findElement(By.cssSelector("span[class='hidden-sm-down']"));
        assertEquals(userNameLabel.getText(), "Janek Bury");
    }

    @Test
    public void asUserTryToLoginUsingIncorrectLoginAndPassword() {
        driver.navigate().to("https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=my-account");

        WebElement userNameField =  driver.findElement(By.name("email"));
        userNameField.sendKeys("NotExisting.login@webowo.pl");

        WebElement passwordField =  driver.findElement(By.name("password"));
        passwordField.sendKeys("NotExistingPassword");

        WebElement signInButton = driver.findElement(By.id("submit-login"));
        signInButton.submit();

        WebElement authenticationAlertLabel = driver.findElement(By.cssSelector("li[class='alert alert-danger']"));
        assertEquals(authenticationAlertLabel.getText(), "Authentication failed.");
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}

