package page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void typeIntoUserNameField(String userName) {
        userNameField.sendKeys(userName);
    }

    public void typeIntoPasswordField(String password) {
        passwordField.sendKeys(password);
    }

    public void clickOnSignInButton() {
        signInButton.submit();
    }

    public String getWelcomeText() {
        String welcomeText = welcomeTextLabel.getText();
        return welcomeText;
    }

    public String getAuthenticationAlertText() {
        String authenticationAlertText = authenticationAlertLabel.getText();
        return authenticationAlertText;
    }

}
