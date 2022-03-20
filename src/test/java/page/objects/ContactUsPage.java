package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class ContactUsPage {

    private Logger logger = LogManager.getLogger(ContactUsPage.class);

    @FindBy(css = "section[class='form-fields'] div")
    private WebElement contactUsLabel;

    public ContactUsPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public String getContactUsLabelText() {
        WaitForElement.waitUntilElementIsVisible(contactUsLabel);
        String contactUsText = contactUsLabel.getText();
        logger.info("Returned Contact Us text was: {}", contactUsText);
        return contactUsText;
    }
}
