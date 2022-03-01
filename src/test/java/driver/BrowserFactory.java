package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

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
            case EDGE:
                System.setProperty("webdriver.edge.driver", "src/main/resources/drivers/msedgedriver.exe");
                return new EdgeDriver();
            case OPERA:
                System.setProperty("webdriver.opera.driver", "src/main/resources/drivers/operadriver.exe");
                return new OperaDriver();
            default:
                throw new IllegalStateException("Unknown browser type! Please check your configuration.");
        }
    }
}
