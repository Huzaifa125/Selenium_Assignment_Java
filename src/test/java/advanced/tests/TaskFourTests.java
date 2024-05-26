package advanced.tests;

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

import static pages.AutomationTestStore.dashboardpage.DashboardPage.itemCount;
import static utitlites.ExtentReportManager.test;
import static webdriver.WebDriverSetup.getDriver;

@Listeners(utitlites.ExtentTestNGListener.class)
public class TaskFourTests extends BaseTest {

    @Test
    @Name("Scenario 1")
    @Description("Verify item amount and quantity Test Pass")
    public void totalItemCountAndAmountUsingEuroTest() {

        DashboardPage dashboardPage = new DashboardPage(getDriver());

        CartPage cartPage = new CartPage(getDriver());

        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.login("jamal123", "123456");

        cartPage.clearCart();

        dashboardPage.verifytotalItemCountAndAmountUsingEuroTest();

        Assert.assertEquals(itemCount, 10, "Expected item count is 10 but actual item count is " + itemCount);
        Assert.assertEquals(dashboardPage.totalAmount, 479.95, "Expected total amount is 479.95 but actual total amount is " + dashboardPage.totalAmount);


        dashboardPage.adjustCartAmountForDollarPoundEuro();

        Assert.assertEquals(itemCount, 7, "Expected item count is 7 but actual item count is " + itemCount);
        Assert.assertEquals(dashboardPage.totalAmount, 130.43, "Expected total amount is 130.43 but actual total amount is " + dashboardPage.totalAmount);


        dashboardPage.adjustItemCount();

        Assert.assertEquals(itemCount, 15, "Expected item count is 15 but actual item count is " + itemCount);



        test.log(Status.PASS, "Verify item amount and quantity Test Pass");

    }

}
