package hu.adamsan.selenium.framework.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import hu.adamsan.selenium.framework.navigation.LeftNavigation;
import hu.adamsan.selenium.framework.selenium.Driver;

public class ListPostsPage {

    private static int count;
    private static List<WebElement> rows;

    public static void goTo(PostType type) {
        switch (type) {
        case PAGE:
            LeftNavigation.Pages.AllPages.select();
            break;
        case POST:
            LeftNavigation.Posts.AllPosts.select();
            break;
        default:
            throw new RuntimeException("Should not reached here, have you covered all the enum cases?");
        }
    }

    public static void selectPost(String string) {
        WebElement postLink = Driver.INSTANCE.findElement(By.linkText("Sample Page"));
        postLink.click();
    }

    public static void storeCount() {
        count = getCurrentCount();
    }

    public static int getPreviousCount() {
        return count;
    }

    public static int getCurrentCount() {
        String displayNumText = Driver.INSTANCE.findElement(By.className("displaying-num")).getText();
        return Integer.parseInt(displayNumText.split(" ")[0]);
    }

    public static boolean doesPostExistsWithTitle(String title) {
        return !Driver.INSTANCE.findElements(By.linkText(title)).isEmpty();
    }

    public static void trashPost(String title) {
        Driver.noWait(() -> rows = Driver.INSTANCE.findElements(By.tagName("tr")));
        for (WebElement row : rows) {
            List<WebElement> links = row.findElements(By.linkText(title));
            if (links.size() > 0) {
                Actions action = new Actions(Driver.INSTANCE);
                action.moveToElement(links.get(0));
                action.perform();
                row.findElement(By.className("submitdelete")).click();
                return;
            }
        }
    }

    public static void searchForPost(String searchString) {
        WebElement searchBox = Driver.INSTANCE.findElement(By.id("post-search-input"));
        searchBox.sendKeys(searchString);

        WebElement submit = Driver.INSTANCE.findElement(By.id("search-submit"));
        submit.click();
    }
}
