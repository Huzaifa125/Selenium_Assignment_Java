package utitlites;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.NoSuchElementException;

import static webdriver.WebDriverSetup.getDriver;

public class UtilityMethods {

    public static void sendKeys(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    public static void click(WebElement element) {
        element.click();
    }


    public static String getTextFromElement(WebElement element) {
        if (element == null) {
            throw new IllegalArgumentException("WebElement is null");
        }

        try {
            return element.getText();
        } catch (NoSuchElementException e) {
            System.out.println("The WebElement was not found: " + e.getMessage());
            return null;
        } catch (Exception e) {
            System.out.println("An error occurred while getting text from the WebElement: " + e.getMessage());
            return null;
        }
    }

    public static void selectTextFromDropDown(WebElement element, String value) {
        if (element == null || value == null || value.isEmpty()) {
            throw new IllegalArgumentException("Element or value cannot be null or empty");
        }
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText(value);
    }

    public static void selectValueFromDropDown(WebElement element, String value) {
        if (element == null || value == null || value.isEmpty()) {
            throw new IllegalArgumentException("Element or value cannot be null or empty");
        }
        Select dropdown = new Select(element);
        dropdown.selectByValue(value);
    }


    public static int countElements(By locator) {

        List<WebElement> elements = getDriver().findElements(locator);
        return elements.size();

    }

    public static List<WebElement> getElements(By locator) {

        return getDriver().findElements(locator);

    }


    public static void hoverOverElement(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }



    public static String getLastLetterFromElementText(By locator) {
        WebElement element = getDriver().findElement(locator);
        String text = element.getText().trim();

        if (!text.isEmpty()) {
            return text.substring(text.length() - 1);
        }
        return "";
    }


    public static int countChildElements(WebElement parentElement, By locator) {

        List<WebElement> elements = parentElement.findElements(locator);
        return elements.size();

    }


    public static String getAttribute(WebElement element, String attribute) {
        if (element == null || attribute == null || attribute.isEmpty()) {
            throw new IllegalArgumentException("Element or attribute cannot be null or empty");
        }
        return element.getAttribute(attribute);
    }


    public static void selectDropdownByVisibleText(WebElement element, String visibleText) {
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText(visibleText);
    }
}
