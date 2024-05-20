package utitlites;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExtentReportManager {



    public static ExtentReports extent;
    public static ExtentTest test;


    public static ExtentReports getInstance() {
        if (extent == null) {
            LocalDateTime currentDateTime = LocalDateTime.now();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMMM-dd '('EEEE')' 'TIME_'hh-mm-ss '('a')'");

            String formattedDateTime = currentDateTime.format(formatter);

            String reportName = formattedDateTime + "_Report.html";

            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/" + reportName);
            sparkReporter.config().setDocumentTitle("My Test Report");
            sparkReporter.config().setReportName("Test Automation Report");
            sparkReporter.config().setTheme(Theme.DARK);
            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
        }
        return extent;
    }

    public static void flushReport() {
        if (extent != null) {
            extent.flush();
        }
    }

}
