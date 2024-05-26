package hooks.AutomationTestStore;

import jdk.jfr.Description;
import jdk.jfr.Name;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utitlites.ExtentReportManager;
import webdriver.BrowserStack;

import java.lang.reflect.Method;

import static utitlites.ExtentReportManager.extent;
import static utitlites.ExtentReportManager.test;

public class BrowserStackBaseTest {

    public WebDriver driver;

    @BeforeClass
    public void beforeClass() {

        ExtentReportManager.getInstance();

    }

    @BeforeMethod
    @Parameters({"browser", "os", "osVersion", "browserVersion"})
    public void setUp(Method method,String browser, String os, String osVersion, String browserVersion) {
        BrowserStack.initializeBrowserStackDriver(browser, os, osVersion, browserVersion);
        BrowserStack.getDriver().get("https://automationteststore.com/");

        try {
            test = extent.createTest(method.getName());

            Name testNameAnnotation = method.getAnnotation(Name.class);
            Description testDescriptionAnnotation = method.getAnnotation(Description.class);

            if (testNameAnnotation != null && testDescriptionAnnotation != null) {
                String testName = testNameAnnotation.value();
                String testDescription = testDescriptionAnnotation.value();
                test.info("Test Name: " + testName);
                test.info("Test Description: " + testDescription);
                test.info("Test Browser: " + browser);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void tearDown() {
        BrowserStack.quitDriver();
    }

    @AfterClass
    public void afterClass() {
        ExtentReportManager.flushReport();
    }
}
