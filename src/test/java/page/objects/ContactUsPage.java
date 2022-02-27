package page.objects;

import driver.manager.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class ContactUsPage {

    @FindBy(css = "section[class='form-fields'] div")
    private WebElement contactUsLabel;

    public ContactUsPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public String getContactUsLabelText() {
        WaitForElement.waitUntilElementIsVisible(contactUsLabel);
        String contactUsText = contactUsLabel.getText();
        return contactUsText;
    }
}
