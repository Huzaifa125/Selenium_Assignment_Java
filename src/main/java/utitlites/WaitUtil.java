package utitlites;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webdriver.WebDriverManager;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static webdriver.WebDriverManager.getDriver;
import static webdriver.WebDriverManager.setDriver;

public class WaitUtil {

    private static WebDriver driver = new ChromeDriver();

    public static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public WaitUtil(WebDriver driver) {
        setDriver(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Default timeout is 10 seconds
    }

    public static boolean waitUntilElementIsClickable(By locator) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(locator));
            return true;
        }catch (TimeoutException ex){
            return false;
        }
    }

    public static void setImplicitWait(long seconds) {
        getDriver().manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    public boolean isElementVisible(By locator) {
        try {
            WebElement element = getDriver().findElement(locator);
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            System.out.println("Element not found or not visible, continuing with execution...");
        }
        return false;
    }

    public static WebElement waitForElementClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForTextToBePresent(By locator, String text) {
        wait.until(ExpectedConditions.textToBe(locator, text));
    }


}
