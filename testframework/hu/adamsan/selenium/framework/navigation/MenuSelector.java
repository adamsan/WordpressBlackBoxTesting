package hu.adamsan.selenium.framework.navigation;

import org.openqa.selenium.By;

import hu.adamsan.selenium.framework.selenium.Driver;

public class MenuSelector {

    public static void select(String topLevelMenuId, String submenuLinkText) {
        Driver.INSTANCE.findElement(By.id(topLevelMenuId)).click();
        Driver.INSTANCE.findElement(By.linkText(submenuLinkText)).click();
    }

}