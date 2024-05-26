package utitlites;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static webdriver.WebDriverSetup.*;

public class WaitUtil {


    private static WebDriver driver;
    private static WebDriverWait wait;

    public WaitUtil(WebDriver driver, WebDriverWait wait) {
        WaitUtil.driver = driver;
        WaitUtil.wait = wait;
    }

    public static void implicitWait(long seconds) {
        getDriver().manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    public static WebElement waitForElementToBeClickable(By locator, int timeout) {
        try {
            return new WebDriverWait(driver, Duration.ofSeconds(timeout))
                    .until(ExpectedConditions.elementToBeClickable(locator));
        } catch (Exception e) {
            System.out.println("Element not clickable: " + e.getMessage());
            return null;
        }
    }



    public WebElement waitForElementToBeVisible(By locator, int timeout) {
        try {
            return new WebDriverWait(driver, Duration.ofSeconds(timeout))
                    .until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e) {
            System.out.println("Element not visible: " + e.getMessage());
            return null;
        }
    }


    public static WebElement waitForElementClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForTextToBePresent(By locator, String text) {
        wait.until(ExpectedConditions.textToBe(locator, text));
    }


}
