package hu.adamsan.selenium.framework.pages;

import org.openqa.selenium.By;

import hu.adamsan.selenium.framework.selenium.Driver;

public class CreatePostCommand {

    private String title;
    private String body;

    public CreatePostCommand(String title) {
        this.title = title;
    }

    public CreatePostCommand withBody(String body) {
        this.body = body;
        return this;
    }

    public void publish() {
        Driver.INSTANCE.findElement(By.id("title")).sendKeys(title);

        Driver.INSTANCE.switchTo().frame("content_ifr");
        Driver.INSTANCE.switchTo().activeElement().sendKeys(body);
        Driver.INSTANCE.switchTo().defaultContent();

        Driver.wait(800);

        Driver.INSTANCE.findElement(By.id("publish")).click();

    }

}
