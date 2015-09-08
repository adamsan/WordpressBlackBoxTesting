package hu.adamsan.selenium.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import hu.adamsan.selenium.framework.selenium.Driver;

public class PostPage {

    public static String getTitle() {
        WebElement title = Driver.INSTANCE.findElement(By.className("entry-title"));
        return (title == null) ? "" : title.getText();
    }

    public static String getBody() {
        WebElement body = Driver.INSTANCE.findElement(By.className("entry-content"));
        return (body == null) ? "" : body.getText();
    }

}
