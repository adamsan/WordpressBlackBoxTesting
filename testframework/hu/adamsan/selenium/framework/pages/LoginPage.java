package hu.adamsan.selenium.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import hu.adamsan.selenium.framework.selenium.Driver;

public class LoginPage {

    private static final String LOGIN_PAGE = Driver.BASE_ADDRESS + "/wp-login.php";

    public static void goTo() {
        Driver.INSTANCE.navigate().to(LOGIN_PAGE);
        WebDriverWait wait = new WebDriverWait(Driver.INSTANCE, 5);
        com.google.common.base.Predicate<WebDriver> p = driver -> {
            return driver.switchTo().activeElement().getAttribute("id").equals("user_login");
        };
        wait.until(p);

    }

    public static LoginCommand loginAs(String username) {
        return new LoginCommand(username);
    }

}
