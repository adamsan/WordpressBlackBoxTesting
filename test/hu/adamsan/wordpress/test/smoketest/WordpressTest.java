package hu.adamsan.wordpress.test.smoketest;

import org.junit.After;
import org.junit.Before;

import hu.adamsan.selenium.framework.pages.LoginPage;
import hu.adamsan.selenium.framework.pages.PostCreator;
import hu.adamsan.selenium.framework.selenium.Driver;

/**
 * Base class for all wordpress tests
 * 
 * @author Adamsan
 *
 */
public abstract class WordpressTest {

    private final String ADMIN_USERNAME = "admin";
    private final String ADMIN_PASSWORD = "admin";

    @Before
    public void setUpBeforeClass() throws Exception {
        Driver.init();
        PostCreator.init();
        LoginPage.goTo();
        LoginPage.loginAs(ADMIN_USERNAME).withPassword(ADMIN_PASSWORD).login();
    }

    @After
    public void tearDownAfterClass() throws Exception {
        PostCreator.cleanup();
        Driver.close();
    }

}
