package utitlites;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class FilterElement extends UtilityMethods {

    private WebDriver driver;

    public FilterElement(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getElementsWithTextEndingWithM(By locator) {
        List<WebElement> allElements = driver.findElements(locator);
        List<WebElement> filteredElements = new ArrayList<>();

        for (WebElement element : allElements) {
            String text = element.getText().trim();
            if (text.toLowerCase().endsWith("m")) {
                filteredElements.add(element);
            }
        }

        return filteredElements;
    }







}
