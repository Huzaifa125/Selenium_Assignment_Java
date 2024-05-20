package utitlites;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.NoSuchElementException;

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
