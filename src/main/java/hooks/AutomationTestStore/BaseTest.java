package hooks.AutomationTestStore;

import jdk.jfr.Description;
import jdk.jfr.Name;
import org.testng.annotations.*;
import utitlites.ExtentReportManager;
import webdriver.WebDriverSetup;

import java.lang.reflect.Method;

import static utitlites.ExtentReportManager.extent;
import static utitlites.ExtentReportManager.test;


public class BaseTest {


    @BeforeClass
    public void beforeClass() {

        ExtentReportManager.getInstance();

    }

    @BeforeMethod
    @Parameters("browser")
    public void setUp(Method method,@Optional String browser) {
        WebDriverSetup.initializeDriver(browser);
        WebDriverSetup.getDriver().get(config.ConfigReader.getProperty("automationteststore.baseUrl"));

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
        WebDriverSetup.quitDriver();
    }

    @AfterClass
    public void afterClass() {
        ExtentReportManager.flushReport();
    }



}
