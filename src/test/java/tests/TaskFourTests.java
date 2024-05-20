package tests;

import com.aventstack.extentreports.Status;
import hooks.BaseTest;
import jdk.jfr.Description;
import jdk.jfr.Name;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.cartpage.CartPage;
import pages.dashboardpage.DashboardPage;
import pages.loginpage.LoginPage;

import static pages.dashboardpage.DashboardPageLocators.*;
import static utitlites.ExtentReportManager.test;
import static utitlites.UtilityMethods.getAttribute;
import static utitlites.UtilityMethods.getTextFromElement;
import static webdriver.WebDriverManager.getDriver;

public class TaskFourTests extends BaseTest {

    LoginTests loginTests = new LoginTests();

    CartPage cartPage = new CartPage(getDriver());

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

        Assert.assertEquals(getTextFromElement(getDriver().findElement(unitPrice_TXT)), "$78.00");
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


}
