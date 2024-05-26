package utitlites;


import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import webdriver.WebDriverSetup;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static utitlites.ExtentReportManager.test;

public class ExtentTestNGListener extends TestListenerAdapter {


    private WebDriverSetup webDriverSetup = new WebDriverSetup();

    @Override
    public void onTestFailure(ITestResult result) {
        super.onTestFailure(result);
        if (ExtentReportManager.test != null) {
            ExtentReportManager.test.log(Status.FAIL, "<pre>Test Case Failed: " + result.getName() + "\nFailure Message: " + result.getThrowable().getMessage()+ "</pre>");
            captureScreenshot(result.getMethod().getMethodName());
        }
    }

    private void captureScreenshot(String methodName) {
        WebDriver driver = webDriverSetup.getDriver();
        if (driver == null) {
            System.out.println("WebDriver instance is null. Cannot capture screenshot.");
            return;
        }

        try {
            LocalDateTime currentDateTime = LocalDateTime.now();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMMM-dd '('EEEE')' 'TIME_'hh-mm-ss '('a')'");

            String formattedDateTime = currentDateTime.format(formatter);

            // Convert WebDriver object to TakesScreenshot
            TakesScreenshot ts = (TakesScreenshot) driver;
            // Capture screenshot as File
            File srcFile = ts.getScreenshotAs(OutputType.FILE);
            // Specify the destination directory
            String destDir = "screenshots/";
            // Create directory if it does not exist
            File destDirectory = new File(destDir);
            if (!destDirectory.exists()) {
                destDirectory.mkdirs();
            }
            File screenshotFile = new File(destDir + formattedDateTime +methodName + "_failure.png");

            // Copy file to the destination directory with a unique name
            FileUtils.copyFile(srcFile, screenshotFile);
            // Attach screenshot to Extent Report
            test.fail("Screenshot:", MediaEntityBuilder.createScreenCaptureFromPath(screenshotFile.getAbsolutePath()).build());
            System.out.println("Screenshot captured on test failure: " + methodName);
        } catch (IOException e) {
            System.out.println("Failed to capture screenshot: " + e.getMessage());
        }
    }
}
