package hu.adamsan.wordpress.test.smoketest;

import static org.junit.Assert.*;

import org.junit.Test;

import hu.adamsan.selenium.framework.pages.ListPostsPage;
import hu.adamsan.selenium.framework.pages.NewPostPage;
import hu.adamsan.selenium.framework.pages.PostCreator;
import hu.adamsan.selenium.framework.pages.PostPage;
import hu.adamsan.selenium.framework.pages.PostType;

public class PostTests extends WordpressTest {

    @Test
    public void canCreateSimplePost() {
        PostCreator.createPost();
        assertEquals("New post title is not the same!", PostCreator.getPreviousTitle(), PostPage.getTitle());
        assertEquals("New post body is not the same!", PostCreator.getPreviousBody(), PostPage.getBody());

    }

    @Test
    public void canEditPage() {

        ListPostsPage.goTo(PostType.PAGE);
        String title = "Sample Page";
        ListPostsPage.selectPost(title);

        assertTrue("Not in edit mode!", NewPostPage.isInEditMode());
        assertEquals("Title did not match with expected title!", title, NewPostPage.getTitle());

    }
}
