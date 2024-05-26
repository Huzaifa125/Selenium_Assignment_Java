package pages.AutomationTestStore.cartpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utitlites.UtilityMethods;

import java.util.List;

public class CartPage extends CartPageLocators {

    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clearCart(){

        UtilityMethods.click(driver.findElement(cart_BTN));
        boolean itemsDeleted = true; // Assume items are present initially

        while (itemsDeleted) {
            List<WebElement> deleteButtons = driver.findElements(deleteItem_BTN);
            if (deleteButtons.isEmpty()) {
                // Handle the case when the delete button is not found
                System.out.println("Delete button not found, exiting the loop...");
                itemsDeleted = false; // Exit the loop
            } else {
                UtilityMethods.click(deleteButtons.get(0)); // Click the first delete button
            }
        }
        // Check if the cart is empty
        boolean isCartEmpty = UtilityMethods.getTextFromElement(driver.findElement(emptyCart_TXT))
                .equals("Your shopping cart is empty!\n" + "Continue");

        Assert.assertTrue(isCartEmpty, "The cart is not empty after removing all items");
    }
}
