package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {

    public static WebDriver getBrowser(BrowserType browserType) {
        switch (browserType) {
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");
                return new FirefoxDriver();
            case CHROME:
                System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
                return new ChromeDriver();
            case IE:
                System.setProperty("webdriver.ie.driver", "src/main/resources/drivers/IEDriverServer.exe");
                return new InternetExplorerDriver();
            default:
                throw new IllegalStateException("Unknow browser type! Please check your configuration.");
        }
    }
}
