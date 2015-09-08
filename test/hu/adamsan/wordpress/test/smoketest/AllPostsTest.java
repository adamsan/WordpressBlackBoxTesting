package hu.adamsan.wordpress.test.smoketest;

import static org.junit.Assert.*;

import org.junit.Test;

import hu.adamsan.selenium.framework.pages.ListPostsPage;
import hu.adamsan.selenium.framework.pages.PostCreator;
import hu.adamsan.selenium.framework.pages.PostType;

public class AllPostsTest extends WordpressTest {

    // Added posts show up in all posts
    // Can trash post
    @Test
    public void addedPostsShowUp() {
        // go to posts, get postcount and store
        ListPostsPage.goTo(PostType.POST);
        ListPostsPage.storeCount();
        // add a new post
        PostCreator.createPost();
        // go to posts, get new post count
        ListPostsPage.goTo(PostType.POST);
        assertEquals(ListPostsPage.getPreviousCount() + 1, ListPostsPage.getCurrentCount());
        // check for the addded posts,
        assertTrue(ListPostsPage.doesPostExistsWithTitle(PostCreator.getPreviousTitle()));
        // Trash post (clean up)
        ListPostsPage.trashPost(PostCreator.getPreviousTitle());
        assertEquals("Could not trash post", ListPostsPage.getPreviousCount(), ListPostsPage.getCurrentCount());
    }

    // can search post
    @Test
    public void canSearchPosts() {
        // create post
        PostCreator.createPost();
        // go to list posts
        ListPostsPage.goTo(PostType.POST);
        // search for the post
        ListPostsPage.searchForPost(PostCreator.getPreviousTitle());
        // post shows up in result
        assertTrue(ListPostsPage.doesPostExistsWithTitle(PostCreator.getPreviousTitle()));
    }
}
