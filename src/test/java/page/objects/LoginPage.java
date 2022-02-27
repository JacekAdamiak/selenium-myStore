package page.objects;

import driver.manager.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class LoginPage {

    @FindBy(name = "email")
    private WebElement userNameField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(id = "submit-login")
    private WebElement signInButton;

    @FindBy(className = "page-header")
    private WebElement welcomeTextLabel;

    @FindBy(css = "li[class='alert alert-danger']")
    private WebElement authenticationAlertLabel;

    private WebDriver driver;

    public LoginPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public void typeIntoUserNameField(String userName) {
        WaitForElement.waitUntilElementIsVisible(userNameField);
        userNameField.sendKeys(userName);
    }

    public void typeIntoPasswordField(String password) {
        passwordField.sendKeys(password);
    }

    public void clickOnSignInButton() {
        signInButton.submit();
    }

    public String getWelcomeText() {
        WaitForElement.waitUntilElementIsVisible(welcomeTextLabel);
        String welcomeText = welcomeTextLabel.getText();
        return welcomeText;
    }

    public String getAuthenticationAlertText() {
        WaitForElement.waitUntilElementIsVisible(authenticationAlertLabel);
        String authenticationAlertText = authenticationAlertLabel.getText();
        return authenticationAlertText;
    }
}
