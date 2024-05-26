package webdriver;

import config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
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

    public static void initializeDriverHeadless(String browser) {
        RemoteWebDriver driverInstance;

        switch(browser.toLowerCase()) {
            case "chrome":
//                    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + ConfigReader.getProperty("chrome.driver.path"));
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless"); // Run headless
                chromeOptions.addArguments("--no-sandbox");
                chromeOptions.addArguments("--disable-dev-shm-usage");
                chromeOptions.addArguments("--disable-gpu");
                chromeOptions.addArguments("--window-size=1920,1080");
                chromeOptions.addArguments("--disable-extensions");
                driverInstance = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
//                    System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + ConfigReader.getProperty("firefox.driver.path"));
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--headless"); // Run headless
                firefoxOptions.addArguments("--no-sandbox");
                firefoxOptions.addArguments("--disable-dev-shm-usage");
                firefoxOptions.addArguments("--disable-gpu");
                firefoxOptions.addArguments("--window-size=1920,1080");
                firefoxOptions.addArguments("--disable-extensions");
                driverInstance = new FirefoxDriver(firefoxOptions);
                break;
            case "edge":
//                    System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + ConfigReader.getProperty("edge.driver.path"));
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--headless"); // Run headless
                edgeOptions.addArguments("--no-sandbox");
                edgeOptions.addArguments("--disable-dev-shm-usage");
                edgeOptions.addArguments("--disable-gpu");
                edgeOptions.addArguments("--window-size=1920,1080");
                edgeOptions.addArguments("--disable-extensions");
                driverInstance = new EdgeDriver(edgeOptions);
                break;
            default:
                throw new IllegalArgumentException("Invalid browser specified: " + browser);
        }
        driverInstance.manage().window().maximize();
        setDriver(driverInstance);

    }


    public static WebDriver initializeDriverJenkins(String browser) {
        WebDriver driver = null;

        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "linuxchromedriver");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless");
                driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "linuxgeckodriver");
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--headless");
                driver = new FirefoxDriver(firefoxOptions);
                break;
            case "edge":
                System.setProperty("webdriver.edge.driver", "linuxedgedriver");
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser type: " + browser);
        }
        return driver;

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
