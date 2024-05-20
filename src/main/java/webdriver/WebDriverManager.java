package webdriver;

import config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverManager {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();


    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void setDriver(WebDriver driverInstance) {
        driver.set(driverInstance);
    }

    public static void initializeDriver(String browser) {
        WebDriver driverInstance;

            switch(browser.toLowerCase()) {
                case "chrome":
                    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + ConfigReader.getProperty("chrome.driver.path"));
                    driverInstance = new ChromeDriver();
                    break;
                case "firefox":
                    System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + ConfigReader.getProperty("firefox.driver.path"));
                    driverInstance = new FirefoxDriver();
                    break;
                case "edge":
                    System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + ConfigReader.getProperty("edge.driver.path"));
                    driverInstance = new EdgeDriver();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid browser specified: " + browser);
            }
        driverInstance.manage().window().maximize();
        setDriver(driverInstance);

    }


    public static void quitDriver() {
        WebDriver driverInstance = getDriver();
        if (driverInstance != null) {
            driverInstance.quit();
            driver.remove();
        }
    }

}
