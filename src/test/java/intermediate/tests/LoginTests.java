package intermediate.tests;

import com.aventstack.extentreports.Status;
import hooks.BaseTest;
import hooks.BrowserStackBaseTest;
import jdk.jfr.Description;
import jdk.jfr.Name;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.loginpage.LoginPage;

import static pages.loginpage.LoginPageLocators.*;
import static utitlites.ExtentReportManager.test;
import static utitlites.UtilityMethods.getTextFromElement;
import static webdriver.WebDriverManager.getDriver;


@Listeners(utitlites.ExtentTestNGListener.class)
public class LoginTests extends BrowserStackBaseTest {


    @Test
    @Name("Valid Login Test")
    @Description("Login with valid credentials")
    public void loginTest() {
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.login("jamal123", "123456");

        Assert.assertEquals(getTextFromElement(getDriver().findElement(AFTER_LOGIN_TEXT)), "Hassan Jamal");

        test.log(Status.PASS, "Valid Login Test Pass");

    }

    @Test
    @Name("InValid Login Test")
    @Description("Login with invalid credentials")
    public void invalidLoginTest() {
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.login("jamals123", "123s456");

        Assert.assertEquals(getTextFromElement(getDriver().findElement(after_invalid_login_TXT)), "×\n" +
                "Error: Incorrect login or password provided.");

        test.log(Status.PASS, "Valid Login Test Pass");

    }
}
