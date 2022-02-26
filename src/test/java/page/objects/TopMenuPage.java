package page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TopMenuPage {

    @FindBy(id = "contact-link")
    private WebElement contactUsLink;

    @FindBy(css = "div[class='user-info'] a")
    private WebElement signInLink;

    @FindBy(css = "span[class='hidden-sm-down']")
    private WebElement userNameLabel;

    private WebDriver driver;

    public TopMenuPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnContactUsLink() {
        contactUsLink.click();
    }

    public void clickOnSignInLink() {
        signInLink.click();
    }

    public String getUserName() {
        String userName = userNameLabel.getText();
        return userName;
    }


}
