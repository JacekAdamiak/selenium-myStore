package page.objects;

import driver.manager.DriverManager;
import generic.assertions.AssertWebElement;
import io.qameta.allure.Step;
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

    @Step("Type into User Name Field {userName}")
    public LoginPage typeIntoUserNameField(String userName) {
        WaitForElement.waitUntilElementIsVisible(userNameField);
        userNameField.sendKeys(userName);
        logger.info("Typed into User Name field: {}", userName);
        return this;
    }

    @Step("Type into Password Field {password}")
    public LoginPage typeIntoPasswordField(String password) {
        passwordField.sendKeys(password);
        logger.info("Typed into User Password field: {}", password);
        return this;
    }

    @Step("Click on SignIn Button")
    public TopMenuPage clickOnSignInButton() {
        signInButton.submit();
        logger.info("Click on SignIn button");
        return new TopMenuPage();
    }

    @Step("Getting warning message from Login Page: {warningMessage}")
    public LoginPage assertThatWarningMessageIsDisplayed(String warningMessage) {
        logger.info("Checking if warning message: {} is displayed", warningMessage);
        WaitForElement.waitUntilElementIsVisible(welcomeTextLabel);
        AssertWebElement.assertThat(welcomeTextLabel).isDisplayed().hasText(warningMessage);
        return this;
    }

//    public String getWelcomeText() {
//        WaitForElement.waitUntilElementIsVisible(welcomeTextLabel);
//        String welcomeText = welcomeTextLabel.getText();
//        logger.info("Returned Welcome text was: {}", welcomeText);
//        return welcomeText;
//    }



}
