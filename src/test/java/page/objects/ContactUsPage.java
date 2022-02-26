package page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {

    @FindBy(css = "section[class='form-fields'] div")
    private WebElement contactUsLabel;

    private WebDriver driver;

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getContactUsLabelText() {
        String contactUsText = contactUsLabel.getText();
        return contactUsText;
    }
}
