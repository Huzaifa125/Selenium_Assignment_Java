package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class BrowserStack {

    private static WebDriver driver;

    public static void initializeBrowserStackDriver(String browser, String os, String osVersion, String browserVersion) {
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName(os);
        browserOptions.setBrowserVersion(browserVersion);

        Map<String, Object> bstackOptions  = new HashMap<>();
            bstackOptions.put("os", os);
            bstackOptions.put("osVersion", osVersion);
            bstackOptions.put("userName", "huzaifasaad_QcTFVi");
            bstackOptions.put("accessKey", "pBXzv1PRWXRimsj8mntz");
            bstackOptions.put("projectName", "BrowserStack Sample2");
            bstackOptions.put("buildName", "bstack-demo");
            bstackOptions.put("sessionName", "Sample Test");
            bstackOptions.put("debug", true);
            bstackOptions.put("networkLogs", true);
            bstackOptions.put("consoleLogs", "info");
        browserOptions.setCapability("bstack:options", bstackOptions);

        try {
            driver = new RemoteWebDriver(new URL("https://hub-cloud.browserstack.com/wd/hub"), browserOptions);
            driver.manage().window().maximize(); // Maximize the browser window
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

}
