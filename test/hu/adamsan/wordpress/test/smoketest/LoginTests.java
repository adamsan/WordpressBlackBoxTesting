package hu.adamsan.wordpress.test.smoketest;

import static org.junit.Assert.*;

import org.junit.Test;

import hu.adamsan.selenium.framework.pages.DashBoard;

public class LoginTests extends WordpressTest {

    @Test
    public void adminUserCanLogin() {
        assertTrue("Failed to login", DashBoard.isAt());
    }

}
