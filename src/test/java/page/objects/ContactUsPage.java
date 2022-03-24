package page.objects;

import driver.manager.DriverManager;
import generic.assertions.AssertWebElement;
import io.qameta.allure.Step;
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

    @Step("Getting title text from Contact Us page: {contactUsText}")
    public ContactUsPage assertThatContactUsLabelTextIsDisplayed(String contactUsText) {
        logger.info("Checking if Contact Us text: --- {} --- is displayed", contactUsText);
        WaitForElement.waitUntilElementIsVisible(contactUsLabel);
        AssertWebElement.assertThat(contactUsLabel).isDisplayed().hasText(contactUsText);
        return this;
    }

//    public String getContactUsLabelText() {
//        WaitForElement.waitUntilElementIsVisible(contactUsLabel);
//        String contactUsText = contactUsLabel.getText();
//        logger.info("Returned Contact Us text was: {}", contactUsText);
//        return contactUsText;
//    }

}
