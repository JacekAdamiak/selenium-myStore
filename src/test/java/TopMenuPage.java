import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TopMenuPage {

    private WebDriver driver;

    public TopMenuPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnSignInLink() {
        WebElement signInLink = driver.findElement(By.cssSelector("div[class='user-info'] a"));
        signInLink.click();
    }

    public String getUserName() {
        WebElement userNameLabel = driver.findElement(By.cssSelector("span[class='hidden-sm-down']"));
        String userName = userNameLabel.getText();
        return userName;
    }


}
