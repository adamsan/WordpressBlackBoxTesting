package hu.adamsan.selenium.framework.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
    public static WebDriver INSTANCE;

    public static void init() {
        INSTANCE = new FirefoxDriver();
        turnOnWait();
    }

    public static void close() {
        INSTANCE.close();
    }

    public static final String BASE_ADDRESS = "http://localhost/wordpress_test";

    public static void wait(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void noWait(Runnable action) {
        turnOffWait();
        action.run();
        turnOnWait();
    }

    public static void turnOnWait() {
        INSTANCE.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public static void turnOffWait() {
        INSTANCE.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }

}
