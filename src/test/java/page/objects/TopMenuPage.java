package page.objects;

import driver.manager.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class TopMenuPage {

    @FindBy(id = "contact-link")
    private WebElement contactUsLink;

    @FindBy(css = "div[class='user-info'] a")
    private WebElement signInLink;

    @FindBy(css = "span[class='hidden-sm-down']")
    private WebElement userNameLabel;

    public TopMenuPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public void clickOnContactUsLink() {
        WaitForElement.waitUntilElementIsClickable(contactUsLink);
        contactUsLink.click();
    }

    public void clickOnSignInLink() {
        WaitForElement.waitUntilElementIsClickable(signInLink);
        signInLink.click();
    }

    public String getUserName() {
        WaitForElement.waitUntilElementIsVisible(userNameLabel);
        String userName = userNameLabel.getText();
        return userName;
    }


}
