package intermediate.tests;

import com.aventstack.extentreports.Status;
import hooks.AutomationTestStore.BaseTest;
import jdk.jfr.Description;
import jdk.jfr.Name;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.AutomationTestStore.cartpage.CartPage;
import pages.AutomationTestStore.dashboardpage.DashboardPage;
import pages.AutomationTestStore.loginpage.LoginPage;
import utitlites.UtilityMethods;

import static java.lang.Integer.parseInt;
import static pages.AutomationTestStore.dashboardpage.DashboardPageLocators.*;
import static utitlites.ExtentReportManager.test;
import static utitlites.UtilityMethods.*;
import static webdriver.WebDriverSetup.getDriver;

@Listeners(utitlites.ExtentTestNGListener.class)
public class TaskFourTests extends BaseTest {




    @Test
    @Name("Scenario 1")
    @Description("Verify item amount and quantity")
    public void verifyItemAmountAndQuantity() {

        DashboardPage dashboardPage = new DashboardPage(getDriver());

        CartPage cartPage = new CartPage(getDriver());

        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.login("jamal123", "123456");

//        setImplicitWait(10);
        cartPage.clearCart();

        dashboardPage.verifyItemAmountAndQuantitySteps();

        Assert.assertEquals(getTextFromElement(getDriver().findElement(unitPrice_TXT)), "$110.00");
        Assert.assertEquals(getAttribute(getDriver().findElement(quantity_TXT),"value"), "1");

        test.log(Status.PASS, "Verify item amount and quantity Test Pass");
    }

    @Test
    @Name("Scenario 2")
    @Description("Verify tshirts and shoes")
    public void verifyTshirtsAndShoes() {

        DashboardPage dashboardPage = new DashboardPage(getDriver());

        CartPage cartPage = new CartPage(getDriver());

        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.login("jamal123", "123456");

//        setImplicitWait(10);

        cartPage.clearCart();

//        setImplicitWait(10);

        dashboardPage.verifyTshirtsAndShoesSteps();

        Assert.assertEquals(getTextFromElement(getDriver().findElement(shoesName_TXT)), "Fiorella Purple Peep Toes");
        Assert.assertEquals(getTextFromElement(getDriver().findElement(shirtName_TXT)), "Designer Men Casual Formal Double Cuffs Grandad Band Collar Shirt Elegant Tie");
        Assert.assertEquals(getAttribute(getDriver().findElement(shoes_Quantity_CSS_TXT),"value"), "2");
        Assert.assertEquals(getAttribute(getDriver().findElement(shirt_Quantity_CSS_TXT),"value"), "3");

        test.log(Status.PASS, "Verify tshirts and shoes Test Pass");

    }

    @Test
    @Name("Scenario 3")
    @Description("Verify amount of sales and total items")
    public void amountOfSalesAndTotalItems() {

        DashboardPage dashboardPage = new DashboardPage(getDriver());

        CartPage cartPage = new CartPage(getDriver());

        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.login("jamal123", "123456");

//        setImplicitWait(10);

        cartPage.clearCart();

//        setImplicitWait(10);

        UtilityMethods.click(getDriver().findElement(skinCare_BTN));

        dashboardPage.saleItems += countElements(sale1);
        dashboardPage.saleItems += countElements(sale2);
        dashboardPage.saleItems += countElements(sale3);

        dashboardPage.outOfStockItems += countElements(outOfStock1);
        dashboardPage.outOfStockItems += countElements(outOfStock2);

        System.out.println("Sale items: "+dashboardPage.saleItems);
        System.out.println("Out of stock items: "+dashboardPage.outOfStockItems);


        dashboardPage.verifyAmountOfSalesAndTotalItems();

        dashboardPage.totalItemsInCart = parseInt(getAttribute(getDriver().findElement(quantity1_TXT),"value")) +
                parseInt(getAttribute(getDriver().findElement(quantity2_TXT),"value"));


        Assert.assertEquals(dashboardPage.saleItems, 2);
        Assert.assertEquals(dashboardPage.outOfStockItems, 2);
        Assert.assertEquals(dashboardPage.totalItemsInCart, 2);
        test.log(Status.PASS, "<pre>Verify amount of sales and total items Test Pass\n Sale Items: "+dashboardPage.saleItems+"\n Out of Stock: "+dashboardPage.outOfStockItems);


    }


    @Test
    @Name("Scenario 4")
    @Description("Verify item in cart should end with M")
    public void itemInCartShouldEndWithM() {

        DashboardPage dashboardPage = new DashboardPage(getDriver());

        CartPage cartPage = new CartPage(getDriver());

        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.login("jamal123", "123456");

//        setImplicitWait(10);

        cartPage.clearCart();

//        setImplicitWait(10);

        dashboardPage.verifyItemInCartShouldEndWithM();

        String lastLetter = getLastLetterFromElementText(productInCart_TXT);


        Assert.assertEquals(lastLetter.toLowerCase(), "m", "The last letter of the text is not 'M'");

        test.log(Status.PASS, "Verify item in cart should end with M Test Pass");

    }


}
