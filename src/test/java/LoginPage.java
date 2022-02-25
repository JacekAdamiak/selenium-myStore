import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void typeIntoUserNameField(String userName) {
        WebElement userNameField =  driver.findElement(By.name("email"));
        userNameField.sendKeys(userName);
    }

    public void typeIntoPasswordField(String password) {
        WebElement passwordField =  driver.findElement(By.name("password"));
        passwordField.sendKeys(password);
    }

    public void clickOnSignInButton() {
        WebElement signInButton = driver.findElement(By.id("submit-login"));
        signInButton.submit();
    }

    public String getWelcomeText(WebDriver driver) {
        WebElement welcomeTextLabel = driver.findElement(By.className("page-header"));
        String welcomeText = welcomeTextLabel.getText();
        return welcomeText;
    }

    public String getAuthenticationAlertText(WebDriver driver) {
        WebElement authenticationAlertLabel = driver.findElement(By.cssSelector("li[class='alert alert-danger']"));
        String authenticationAlertText = authenticationAlertLabel.getText();
        return authenticationAlertText;
    }

}
