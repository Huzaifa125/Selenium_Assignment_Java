package advanced.tests;

import com.aventstack.extentreports.Status;
import hooks.SauceDemo.BaseTest;
import jdk.jfr.Description;
import jdk.jfr.Name;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.SauceDemo.dashboardpage.DashboardPage;
import pages.SauceDemo.loginpage.LoginPage;

import java.util.List;

import static pages.SauceDemo.loginpage.LoginPageLocators.LOGIN_TEXT;
import static utitlites.ExtentReportManager.test;
import static utitlites.UtilityMethods.getTextFromElement;
import static utitlites.WaitUtil.implicitWait;
import static webdriver.WebDriverSetup.getDriver;


@Listeners(utitlites.ExtentTestNGListener.class)
public class TaskThreeTests extends BaseTest {

    @Test
    @Name("Scenario 1")
    @Description("Login in with valid username and password")
    public void validLogin() {

        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.login("standard_user", "secret_sauce");


        Assert.assertEquals(getTextFromElement(getDriver().findElement(LOGIN_TEXT)), "Products");

        test.log(Status.PASS, "Valid Login Test Pass");


    }

    @Test
    @Name("Scenario 2")
    @Description("Sort items from low to high")
    public void sortItemLowToHigh() {

        LoginPage loginPage = new LoginPage(getDriver());

        DashboardPage dashboardPage = new DashboardPage(getDriver());


        loginPage.login("standard_user", "secret_sauce");

        implicitWait(5);

        List<WebElement> cartItems = dashboardPage.verifysortItemLowToHigh();

        Assert.assertEquals(cartItems.size(), 2, "Cart items quantity mismatch.");
    }





}
