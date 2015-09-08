package hu.adamsan.selenium.framework.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import hu.adamsan.selenium.framework.selenium.Driver;

public class DashBoard {

    public static boolean isAt() {
        List<WebElement> h1Elements = Driver.INSTANCE.findElements(By.tagName("h1"));
        return h1Elements.stream().anyMatch(el -> el.getText().equals("Dashboard"));
    }

}
