package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class LoginPage {

    private Logger logger = LogManager.getLogger(LoginPage.class);

    @FindBy(name = "email")
    private WebElement userNameField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(id = "submit-login")
    private WebElement signInButton;

    @FindBy(className = "page-header")
    private WebElement welcomeTextLabel;

    private WebDriver driver;

    public LoginPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public LoginPage typeIntoUserNameField(String userName) {
        WaitForElement.waitUntilElementIsVisible(userNameField);
        userNameField.sendKeys(userName);
        logger.info("Typed into User Name field: {}", userName);
        return this;
    }

    public LoginPage typeIntoPasswordField(String password) {
        passwordField.sendKeys(password);
        logger.info("Typed into User Password field: {}", password);
        return this;
    }

    public TopMenuPage clickOnSignInButton() {
        signInButton.submit();
        logger.info("Click on SignIn button");
        return new TopMenuPage();
    }

    public String getWelcomeText() {
        WaitForElement.waitUntilElementIsVisible(welcomeTextLabel);
        String welcomeText = welcomeTextLabel.getText();
        logger.info("Returned Welcome text was: {}", welcomeText);
        return welcomeText;
    }


}
