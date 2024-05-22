package webdriver;

import config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


public class WebDriverSetup {

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
//                    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + ConfigReader.getProperty("chrome.driver.path"));
                    WebDriverManager.chromedriver().setup();
                    driverInstance = new ChromeDriver();
                    break;
                case "firefox":
//                    System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + ConfigReader.getProperty("firefox.driver.path"));
                    WebDriverManager.firefoxdriver().setup();
                    driverInstance = new FirefoxDriver();
                    break;
                case "edge":
//                    System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + ConfigReader.getProperty("edge.driver.path"));
                    WebDriverManager.edgedriver().setup();
                    driverInstance = new EdgeDriver();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid browser specified: " + browser);
            }
        driverInstance.manage().window().maximize();
        setDriver(driverInstance);

    }

    public static void initializeSauceLabsDriver(String browser) {
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 11");
        browserOptions.setBrowserVersion("latest");
        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("username", ConfigReader.getProperty("sauce.username"));
        sauceOptions.put("accessKey", ConfigReader.getProperty("sauce.accessKey"));
        sauceOptions.put("build", "selenium-build-SP8AK");
        sauceOptions.put("name", "<your test name>");
        browserOptions.setCapability("sauce:options", sauceOptions);

        try {
            URL url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
            driver.set(new RemoteWebDriver(url, browserOptions));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }








    public static void quitDriver() {
        WebDriver driverInstance = getDriver();
        if (driverInstance != null) {
            driverInstance.quit();
            driver.remove();
        }
    }

}
