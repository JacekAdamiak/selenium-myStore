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

public class TopMenuPage {

    private Logger logger = LogManager.getLogger(TopMenuPage.class);

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

    @Step("Click on Contact Us link")
    public ContactUsPage clickOnContactUsLink() {
        WaitForElement.waitUntilElementIsClickable(contactUsLink);
        contactUsLink.click();
        logger.info("Clicked on Contact Us link");
        return new ContactUsPage();
    }

    @Step("Click on Sign In link")
    public LoginPage clickOnSignInLink() {
        WaitForElement.waitUntilElementIsClickable(signInLink);
        signInLink.click();
        logger.info("Clicked on Sign In link");
        return new LoginPage();
    }

    @Step("Getting user name from Top Menu: {userName}")
    public TopMenuPage assertThatUserNameIsDisplayed(String userName) {
        logger.info("Checking if User Name: {} was displayed", userName);
        WaitForElement.waitUntilElementIsVisible(userNameLabel);
        AssertWebElement.assertThat(userNameLabel).isDisplayed().hasText(userName);
        return this;
    }

    @Step("Getting authentication alert from Login page: {authenticationAlertText}")
    public TopMenuPage assertThatAuthenticationAlertTextIsDisplayed(String authenticationAlertText) {
        logger.info("Checking if Authentication alert: --- {} --- was displayed", authenticationAlertText);
        WaitForElement.waitUntilElementIsVisible(authenticationAlertLabel);
        AssertWebElement.assertThat(authenticationAlertLabel).isDisplayed().hasText(authenticationAlertText);
        return this;
    }


}
