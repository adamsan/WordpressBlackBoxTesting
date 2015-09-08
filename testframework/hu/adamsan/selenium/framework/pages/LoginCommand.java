package hu.adamsan.selenium.framework.pages;

import org.openqa.selenium.By;

import hu.adamsan.selenium.framework.selenium.Driver;

public class LoginCommand {

    private String username;
    private String password;

    public LoginCommand(String username) {
        this.username = username;
    }

    public LoginCommand withPassword(String password) {
        this.password = password;
        return this;
    }

    public void login() {
        Driver.INSTANCE.findElement(By.id("user_login")).sendKeys(username);
        Driver.INSTANCE.findElement(By.id("user_pass")).sendKeys(password);
        Driver.INSTANCE.findElement(By.id("wp-submit")).click();
    }
}
