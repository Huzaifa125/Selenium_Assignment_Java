package pages.dashboardpage;

import org.openqa.selenium.WebDriver;
import utitlites.UtilityMethods;

import static utitlites.UtilityMethods.selectTextFromDropDown;

public class DashboardPage extends DashboardPageLocators {

    private WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyItemAmountAndQuantitySteps() {


        UtilityMethods.click(driver.findElement(APPAREL_ACCESSORIES_BTN));
        UtilityMethods.click(driver.findElement(product_BTN));
        UtilityMethods.click(driver.findElement(addToCart_BTN));


    }

    public void verifyTshirtsAndShoesSteps() {


        UtilityMethods.click(driver.findElement(APPARELACCESSORIES_CSS_BTN));
        UtilityMethods.click(driver.findElement(tshirts_BTN));
        selectTextFromDropDown(driver.findElement(options_SELECT), "Price Low > High");
        UtilityMethods.click(driver.findElement(WHITE_SHIRT_BTN));
        UtilityMethods.sendKeys(driver.findElement(quantity_CSS_TXT), "3");
        UtilityMethods.click(driver.findElement(addToCart_CSS_BTN));

        UtilityMethods.click(driver.findElement(APPARELACCESSORIES_CSS_BTN));
        UtilityMethods.click(driver.findElement(shoes_BTN));
        selectTextFromDropDown(driver.findElement(options_SELECT), "Rating Highest");
        UtilityMethods.click(driver.findElement(singleShoes_BTN));
        UtilityMethods.sendKeys(driver.findElement(quantity_CSS_TXT), "2");
        UtilityMethods.click(driver.findElement(addToCart_CSS_BTN));

    }


}
