package pages.AutomationTestStore.loginpage;

import org.openqa.selenium.By;

public class LoginPageLocators {

    protected static By usernameField = By.xpath("/html/body/div/div[2]/div/div/div/div/div[2]/div/form/fieldset/div[1]/div/input");
    protected static By passwordField = By.xpath("/html/body/div/div[2]/div/div/div/div/div[2]/div/form/fieldset/div[2]/div/input");
    protected static By account_BTN = By.xpath("/html/body/div/header/div[1]/div/div[2]/div/div[3]/div/ul/li[2]/a/span");
    protected static By loginButton = By.xpath("/html/body/div/div[2]/div/div/div/div/div[2]/div/form/fieldset/button");
    public static By AFTER_LOGIN_TEXT = By.xpath("//span[@class='subtext']");
    public static By after_invalid_login_TXT = By.xpath("/html/body/div/div[2]/div/div/div/div[1]");

}
