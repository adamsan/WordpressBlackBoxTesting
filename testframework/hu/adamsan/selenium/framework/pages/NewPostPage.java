package hu.adamsan.selenium.framework.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import hu.adamsan.selenium.framework.navigation.LeftNavigation;
import hu.adamsan.selenium.framework.selenium.Driver;

public class NewPostPage {

    public static void goTo() {

        LeftNavigation.Posts.AddNew.select();

    }

    public static CreatePostCommand createPost(String title) {
        return new CreatePostCommand(title);
    }

    public static void goToNewPost() {
        WebElement message = Driver.INSTANCE.findElement(By.id("message"));
        List<WebElement> links = message.findElements(By.tagName("a"));
        WebElement newPostLink = links.get(0);
        newPostLink.click();

    }

    public static boolean isInEditMode() {
        // Icon has been removed from wordpress
        // return Driver.INSTANCE.findElement(By.id("icon-edit-pages")) != null;
        WebElement h1 = Driver.INSTANCE.findElement(By.tagName("h1"));
        System.out.println(h1);
        return h1.getText().startsWith("Edit Page");
    }

    public static String getTitle() {
        WebElement title = Driver.INSTANCE.findElement(By.id("title"));
        return (title == null) ? "" : title.getAttribute("value");
    }

}
