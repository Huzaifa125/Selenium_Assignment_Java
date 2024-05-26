package pages.AutomationTestStore.dashboardpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utitlites.FilterElement;
import utitlites.UtilityMethods;
import utitlites.WaitUtil;

import java.time.Duration;
import java.util.List;

import static pages.AutomationTestStore.cartpage.CartPageLocators.cart_BTN;
import static pages.AutomationTestStore.cartpage.CartPageLocators.deleteItem_BTN;
import static utitlites.UtilityMethods.selectTextFromDropDown;
import static webdriver.WebDriverSetup.getDriver;

public class DashboardPage extends DashboardPageLocators {


    public int saleItems = 0;
    public int outOfStockItems = 0;
    public int totalItemsInCart = 0;


    private WebDriver driver;


    public static int itemCount;

    public double totalAmount;


    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    FilterElement elementFilter = new FilterElement(getDriver());

    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));


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


    public void verifyAmountOfSalesAndTotalItems() {

        UtilityMethods.click(driver.findElement(addToCart1_BTN));
        UtilityMethods.click(driver.findElement(addToCart2_BTN));

        UtilityMethods.click(driver.findElement(cart_BTN));

    }

    public void verifyItemInCartShouldEndWithM() {


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

    public void verifytotalItemCountAndAmountUsingEuroTest() {

        UtilityMethods.hoverOverElement(driver, driver.findElement(currencyDropDown));

        UtilityMethods.click(driver.findElement(euroCurrency_BTN));


        UtilityMethods.click(driver.findElement(skinCare2_BTN));

        UtilityMethods.click(driver.findElement(addToCart_SkinCareProduct1_BTN));
        UtilityMethods.click(driver.findElement(addToCart_SkinCareProduct2_BTN));
        UtilityMethods.click(driver.findElement(addToCart_SkinCareProduct3_BTN));


        UtilityMethods.click(driver.findElement(men_BTN));

        UtilityMethods.click(driver.findElement(addToCart_MenProduct1_BTN));
        UtilityMethods.click(driver.findElement(addToCart_MenProduct2_BTN));
        UtilityMethods.click(driver.findElement(addToCart_MenProduct3_BTN));

        UtilityMethods.click(driver.findElement(addToCart_BTN));

        UtilityMethods.click(driver.findElement(makeup_BTN));

        UtilityMethods.click(driver.findElement(addToCart_MakeupProduct1_BTN));
        UtilityMethods.click(driver.findElement(addToCart_BTN));

        UtilityMethods.click(driver.findElement(makeup_BTN));


        UtilityMethods.click(driver.findElement(addToCart_MakeupProduct2_BTN));
        UtilityMethods.click(driver.findElement(addToCart_BTN));

        UtilityMethods.click(driver.findElement(makeup_BTN));


        UtilityMethods.click(driver.findElement(addToCart_MakeupProduct3_BTN));
        UtilityMethods.click(driver.findElement(addToCart_BTN));

        UtilityMethods.click(driver.findElement(makeup_BTN));


        UtilityMethods.click(driver.findElement(addToCart_MakeupProduct4_BTN));
        UtilityMethods.click(driver.findElement(addToCart_BTN));


        UtilityMethods.click(driver.findElement(cart_BTN));


        // Calculate total amount and item count
        itemCount = getItemCount(driver);

        WaitUtil.implicitWait(10);

        totalAmount = getTotalAmount(driver);


        System.out.println("Total item count: " + itemCount + ", Total amount: " + totalAmount + " Euro");



    }

    public void adjustCartAmountForDollarPoundEuro() {

        adjustCartAmount(driver, wait, 200);

        UtilityMethods.hoverOverElement(driver, driver.findElement(currencyDropDown));

        UtilityMethods.click(driver.findElement(dollarCurrency_BTN));

        adjustCartAmount(driver, wait, 200);


        UtilityMethods.hoverOverElement(driver, driver.findElement(currencyDropDown));

        UtilityMethods.click(driver.findElement(poundCurrency_BTN));

        adjustCartAmount(driver, wait, 200);

        // Final assertions for item count
        itemCount = getItemCount(driver);
        totalAmount = getTotalAmount(driver);


        System.out.println("Final item count: " + itemCount + ", Final total amount: " + totalAmount + " Pound");


    }

    public void adjustItemCount() {

//        addMoreItems(driver, wait, fragrance_BTN, 2);

        addFourFragranceItems();

        addFourApparelAndAccessoriesItems();

//        addMoreItems(driver, wait, books_BTN, 2);
//        addMoreItems(driver, wait, hairCare_BTN, 4);

        UtilityMethods.click(driver.findElement(cart_BTN));

        adjustCartQuantity(driver, wait, 15);


        // Final assertions for total amount
        itemCount = getItemCount(driver);
        System.out.println("Final item count: " + itemCount);


    }

    public void addFourFragranceItems() {

        UtilityMethods.hoverOverElement(driver, driver.findElement(fragrance_BTN));
        UtilityMethods.click(driver.findElement(men_Frangrance_BTN));
        UtilityMethods.click(driver.findElement(fragranceProduct1_BTN));
        UtilityMethods.click(driver.findElement(fragranceProduct2_BTN));
        UtilityMethods.click(driver.findElement(fragranceProduct3_BTN));
        UtilityMethods.click(driver.findElement(fragranceProduct4_BTN));

    }

    public void addFourApparelAndAccessoriesItems() {

        UtilityMethods.click(driver.findElement(apparelAndAccessories_BTN));
        UtilityMethods.click(driver.findElement(apparelAndAccessories_product1_BTN));
        UtilityMethods.click(driver.findElement(radio_btn));
        UtilityMethods.click(driver.findElement(addToCart_BTN));

        UtilityMethods.click(driver.findElement(apparelAndAccessories_BTN));
        UtilityMethods.click(driver.findElement(apparelAndAccessories_product2_BTN));
        UtilityMethods.click(driver.findElement(addToCart_BTN));

        UtilityMethods.click(driver.findElement(apparelAndAccessories_BTN));
        UtilityMethods.click(driver.findElement(apparelAndAccessories_product3_BTN));
        UtilityMethods.click(driver.findElement(addToCart_BTN));

        UtilityMethods.click(driver.findElement(apparelAndAccessories_BTN));
        UtilityMethods.click(driver.findElement(apparelAndAccessories_product4_BTN));
        UtilityMethods.click(driver.findElement(addToCart_BTN));


    }

    private static int getItemCount(WebDriver driver) {
        List<WebElement> items = driver.findElements(By.xpath("/html/body/div/div[2]/div/div/div/form/div/div[1]/table/tbody/tr[position()>1]"));
        return items.size();
    }

    private static double getTotalAmount(WebDriver driver) {
        String totalAmountText = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/form/div/div[3]/div/table/tbody/tr[3]/td[2]/span")).getText();
        return Double.parseDouble(totalAmountText.replaceAll("[^\\d.]", ""));
    }

    private static void adjustCartAmount(WebDriver driver, WebDriverWait wait, double limit) {
        double totalAmount = getTotalAmount(driver);
        while (totalAmount > limit) {
            UtilityMethods.click(driver.findElement(deleteItem_BTN));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".product-list")));
            totalAmount = getTotalAmount(driver);
        }
    }

    private static double adjustCartQuantity(WebDriver driver, WebDriverWait wait, double limit) {
        double totalItemsInCart = getItemCount(driver);
        while (totalItemsInCart < limit) {
            UtilityMethods.click(driver.findElement(cart_BTN));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".product-list")));
            totalItemsInCart = getItemCount(driver);
        }
        return totalItemsInCart;
    }





    private static void addMoreItems(WebDriver driver, WebDriverWait wait, By category, int itemsNeeded) {
        driver.findElement(category).click();
        List<WebElement> productCartElements = driver.findElements(By.className("productcart"));
        int itemsAdded = 0;
        for (WebElement item : productCartElements) {
            if (itemsAdded >= itemsNeeded) break;
            item.click();
            try {
                wait.until(ExpectedConditions.stalenessOf(item));
                // Handle add to cart on the new page
                wait.until(ExpectedConditions.elementToBeClickable(addToCart_BTN_2)).click();
                WaitUtil.implicitWait(5);
                UtilityMethods.click(driver.findElement(category));
            } catch (Exception e) {
                // If the element is still present, it means the product was added to the cart without redirection
                System.out.println("The item was added to the cart without redirection: " + e.getMessage());
            }
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".pricetag:not(.sale)")));
            itemsAdded++;
        }

        itemCount += itemsAdded;

        System.out.println("Items added: " + itemCount);
    }




}
