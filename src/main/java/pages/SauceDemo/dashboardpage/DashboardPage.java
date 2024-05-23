package pages.SauceDemo.dashboardpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utitlites.UtilityMethods;

import java.util.List;

import static utitlites.UtilityMethods.*;

public class DashboardPage extends DashboardPageLocators {


    private WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> verifysortItemLowToHigh(){

        selectValueFromDropDown(driver.findElement(filter_Dropdown),"lohi");

        Assert.assertTrue(isSorted(getElements(item_price)), "Items are not sorted from low to high.");

        getElements(item_price).get(0).findElement(add_to_cart_BTN).click();
        getElements(item_price).get(1).findElement(add_to_cart_BTN).click();


        UtilityMethods.click(driver.findElement(shopping_cart_link));

        return driver.findElements(cart_items);
    }

    private boolean isSorted(List<WebElement> prices) {
        for (int i = 0; i < prices.size() - 1; i++) {
            double price1 = Double.parseDouble(prices.get(i).getText().substring(1));
            double price2 = Double.parseDouble(prices.get(i + 1).getText().substring(1));
            if (price1 > price2) {
                return false;
            }
        }
        return true;
    }

}
