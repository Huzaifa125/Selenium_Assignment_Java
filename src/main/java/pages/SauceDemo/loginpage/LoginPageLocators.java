package pages.SauceDemo.loginpage;

import org.openqa.selenium.By;

public class LoginPageLocators {

    protected By TXT_USERNAME = By.id("user-name");
    protected By TXT_PASSWORD = By.id("password");
    protected By BTN_LOGIN = By.id("login-button");
    public static By LOGIN_TEXT = By.xpath("//span[@class='title']");
    public static By INVALID_TEXT = By.xpath("//h3[contains(text(),'Epic sadface: Username and password do not match a')]");


}
