package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class TopMenuPage {

    private Logger logger = LogManager.getRootLogger();

    @FindBy(id = "contact-link")
    private WebElement contactUsLink;

    @FindBy(css = "div[class='user-info'] a")
    private WebElement signInLink;

    @FindBy(css = "span[class='hidden-sm-down']")
    private WebElement userNameLabel;

    @FindBy(css = "li[class='alert alert-danger']")
    private WebElement authenticationAlertLabel;

    public TopMenuPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public ContactUsPage clickOnContactUsLink() {
        WaitForElement.waitUntilElementIsClickable(contactUsLink);
        contactUsLink.click();
        logger.info("Clicked on Contact Us link");
        return new ContactUsPage();
    }

    public LoginPage clickOnSignInLink() {
        WaitForElement.waitUntilElementIsClickable(signInLink);
        signInLink.click();
        logger.info("Clicked on Sign In link");
        return new LoginPage();
    }

    public String getUserName() {
        WaitForElement.waitUntilElementIsVisible(userNameLabel);
        String userName = userNameLabel.getText();
        logger.info("Returned User Name was: {}", userName);
        return userName;
    }

    public String getAuthenticationAlertText() {
        WaitForElement.waitUntilElementIsVisible(authenticationAlertLabel);
        String authenticationAlertText = authenticationAlertLabel.getText();
        logger.info("Returned Authentication alert was: {}", authenticationAlertText);
        return authenticationAlertText;
    }


}
