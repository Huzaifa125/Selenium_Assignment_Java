package pages.loginpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import utitlites.UtilityMethods;


public class LoginPage extends LoginPageLocators {

    private WebDriver driver;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String username, String password) {
        UtilityMethods.click(driver.findElement(account_BTN));
        UtilityMethods.sendKeys(driver.findElement(usernameField), username);
        UtilityMethods.sendKeys(driver.findElement(passwordField), password);
        UtilityMethods.click(driver.findElement(loginButton));
    }


}
