package pages.SauceDemo.loginpage;

import org.openqa.selenium.WebDriver;
import utitlites.UtilityMethods;

public class LoginPage extends LoginPageLocators{




    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }




    public void login(String username, String password) {

        UtilityMethods.sendKeys(driver.findElement(TXT_USERNAME), username);

        UtilityMethods.sendKeys(driver.findElement(TXT_PASSWORD), password);

        UtilityMethods.click(driver.findElement(BTN_LOGIN));

    }

}
