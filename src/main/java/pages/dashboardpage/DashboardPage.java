package pages.dashboardpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utitlites.FilterElement;
import utitlites.UtilityMethods;

import java.util.List;

import static pages.cartpage.CartPageLocators.cart_BTN;
import static utitlites.UtilityMethods.selectTextFromDropDown;
import static webdriver.WebDriverSetup.getDriver;

public class DashboardPage extends DashboardPageLocators {


    public int saleItems = 0;
    public int outOfStockItems = 0;
    public int totalItemsInCart = 0;

    private WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    FilterElement elementFilter = new FilterElement(getDriver());



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


    public void verifyAmountOfSalesAndTotalItems(){


        UtilityMethods.click(driver.findElement(addToCart1_BTN));
        UtilityMethods.click(driver.findElement(addToCart2_BTN));

        UtilityMethods.click(driver.findElement(cart_BTN));

    }

    public void verifyItemInCartShouldEndWithM(){


        UtilityMethods.click(driver.findElement(men_BTN));
        List<WebElement> productsEndingWithM = elementFilter.getElementsWithTextEndingWithM(products_TXT);

        if (!productsEndingWithM.isEmpty()) {
            // Assuming we take the first product that ends with 'M'
            WebElement productToAdd = productsEndingWithM.get(0);
            String productName = productToAdd.getText().trim();

            // Add the product to the cart
            productToAdd.click(); // Navigate to the product detail page
            UtilityMethods.click(driver.findElement(addToCartMen_BTN));

            // Go to the cart and assert the product name
            UtilityMethods.click(driver.findElement(checkout_BTN));
        } else {
            Assert.fail("No product ending with 'M' found in the Men section");
        }


    }


}
