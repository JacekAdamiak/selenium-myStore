package configuration;

import driver.BrowserType;

public class LocalWebDriverProperties {

    public static String getFirefoxWebDriverLocation() {
        return ConfigurationProperties.getProperties().getProperty("firefox.driver.location");
    }
    public static String getChromeWebDriverLocation() {
        return ConfigurationProperties.getProperties().getProperty("chrome.driver.location");
    }
    public static String getInternetExplorerDriverLocation() {
        return ConfigurationProperties.getProperties().getProperty("ie.driver.location");
    }
    public static String getEdgeDriverLocation() {
        return ConfigurationProperties.getProperties().getProperty("edge.driver.location");
    }
    public static String getOperaDriverLocation() {
        return ConfigurationProperties.getProperties().getProperty("opera.driver.location");
    }
}
