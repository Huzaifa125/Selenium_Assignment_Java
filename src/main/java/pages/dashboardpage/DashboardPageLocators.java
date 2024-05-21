package pages.dashboardpage;

import org.openqa.selenium.By;

public class DashboardPageLocators {


    //region Scenario 1 locators
    protected By APPAREL_ACCESSORIES_BTN = By.xpath("/html/body/div/div[1]/div[1]/section/nav/ul/li[2]/a");
    protected By product_BTN = By.xpath("//div[9]//div[2]//div[3]//a[1]//i[1]");
    protected By addToCart_BTN = By.xpath("//a[normalize-space()='Add to Cart']");
    public static By unitPrice_TXT = By.xpath("/html/body/div/div[2]/div/div/div/form/div/div[1]/table/tbody/tr[2]/td[4]");
    public static By quantity_TXT = By.xpath("/html/body/div/div[2]/div/div/div/form/div/div[1]/table/tbody/tr[2]/td[5]/div/input");
    //endregion


    //region Scenario 2 locators
    protected By APPARELACCESSORIES_CSS_BTN = By.cssSelector("a[href='https://automationteststore.com/index.php?rt=product/category&path=68']");
    protected By shoes_BTN = By.cssSelector("#maincontainer > div > div > div > div > ul > li:nth-child(1) > a > img");
    protected By tshirts_BTN = By.cssSelector("#maincontainer > div > div > div > div > ul > li:nth-child(2) > a > img");
    protected By quantity_CSS_TXT = By.cssSelector("#product_quantity");
    protected By WHITE_SHIRT_BTN = By.cssSelector("div:nth-child(6) div:nth-child(2) a:nth-child(1) img:nth-child(1)");
    protected By options_SELECT = By.cssSelector("#sort");
    protected By addToCart_CSS_BTN = By.cssSelector(".cart");
    protected By singleShoes_BTN = By.cssSelector("div[class='contentpanel'] div:nth-child(1) div:nth-child(2) a:nth-child(1) img:nth-child(1)");
    public static By shoes_Quantity_CSS_TXT = By.cssSelector("#cart_quantity1159decaced08ca7c307cce3840afceda7f");
    public static By shirt_Quantity_CSS_TXT = By.cssSelector("#cart_quantity12180e3a92dbdbee7dcadd3b4b20cf25899");
    public static By shoesName_TXT = By.cssSelector("#cart > div > div.container-fluid.cart-info.product-list > table > tbody > tr:nth-child(3) > td:nth-child(2) > a");
    public static By shirtName_TXT = By.cssSelector("#cart > div > div.container-fluid.cart-info.product-list > table > tbody > tr:nth-child(2) > td:nth-child(2) > a");
    //endregion

    //region Scenario 3 locators
    public static By skinCare_BTN = By.xpath("/html/body/div/div[1]/div[1]/section/nav/ul/li[4]/a");
    public static By sale1 = By.xpath("/html/body/div/div[2]/div/div/div/div/div[3]/div[1]/div[2]/span");
    public static By sale2 = By.xpath("/html/body/div/div[2]/div/div/div/div/div[3]/div[2]/div[2]/span");
    public static By sale3 = By.xpath("/html/body/div/div[2]/div/div/div/div/div[3]/div[6]/div[2]/span");
    public static By outOfStock1 = By.xpath("/html/body/div/div[2]/div/div/div/div/div[3]/div[1]/div[2]/div[3]/span");
    public static By outOfStock2 = By.xpath("/html/body/div/div[2]/div/div/div/div/div[3]/div[3]/div[2]/div[3]/span");
    public By addToCart1_BTN = By.xpath("/html/body/div/div[2]/div/div/div/div/div[3]/div[2]/div[2]/div[3]/a/i");
    public By addToCart2_BTN = By.xpath("/html/body/div/div[2]/div/div/div/div/div[3]/div[4]/div[2]/div[3]/a/i");
    public static By quantity1_TXT = By.xpath("/html/body/div/div[2]/div/div/div/form/div/div[1]/table/tbody/tr[2]/td[5]/div/input");
    public static By quantity2_TXT = By.xpath("/html/body/div/div[2]/div/div/div/form/div/div[1]/table/tbody/tr[3]/td[5]/div/input");

    //endregion

    //region Scenario 4 locators
    public By men_BTN = By.xpath("/html/body/div/div[1]/div[1]/section/nav/ul/li[6]/a");
    public By products_TXT = By.xpath("//a[@class='prdocutname']");
    public By addToCartMen_BTN = By.xpath("/html/body/div/div[2]/div/div[2]/div/div[1]/div/div[2]/div/div/div[2]/form/fieldset/div[5]/ul/li/a");
    public By checkout_BTN = By.xpath("/html/body/div/div[2]/div/div/div/form/div/div[1]/div/a");
    public static By productInCart_TXT = By.xpath("/html/body/div/div[2]/div/div[1]/div/div[2]/table[3]/tbody/tr/td[2]/a");
    //endregion

}
