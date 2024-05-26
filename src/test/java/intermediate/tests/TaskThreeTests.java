package intermediate.tests;

import com.aventstack.extentreports.Status;
import hooks.SauceDemo.BaseTest;
import jdk.jfr.Description;
import jdk.jfr.Name;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.SauceDemo.loginpage.LoginPage;

import static pages.SauceDemo.loginpage.LoginPageLocators.INVALID_TEXT;
import static pages.SauceDemo.loginpage.LoginPageLocators.LOGIN_TEXT;
import static utitlites.ExtentReportManager.test;
import static utitlites.UtilityMethods.getTextFromElement;
import static webdriver.WebDriverSetup.getDriver;

@Listeners(utitlites.ExtentTestNGListener.class)
public class TaskThreeTests extends BaseTest {



    @Test
    @Name("Scenario 1")
    @Description("Login in with invalid username and password")
    public void inValidLogin() {

        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.login("standard_user", "secrt_sauce");


        Assert.assertEquals(getTextFromElement(getDriver().findElement(INVALID_TEXT)), "Epic sadface: Username and password do not match any user in this service");

        test.log(Status.PASS, "InValid Login Test Pass");


    }



    @Test
    @Name("Scenario 2")
    @Description("Login in with valid username and password")
    public void validLogin() {

        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.login("standard_user", "secret_sauce");


        Assert.assertEquals(getTextFromElement(getDriver().findElement(LOGIN_TEXT)), "Products");

        test.log(Status.PASS, "Valid Login Test Pass");


    }





}
