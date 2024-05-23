package pages.SauceDemo.dashboardpage;

import org.openqa.selenium.By;

public class DashboardPageLocators {

    public By filter_Dropdown = By.className("product_sort_container");
    public By item_price = By.className("inventory_item_price");
    public By add_to_cart_BTN = By.xpath("//button[text()='Add to cart']");
    public By shopping_cart_link = By.className("shopping_cart_link");
    public By cart_items = By.className("cart_item");



}
