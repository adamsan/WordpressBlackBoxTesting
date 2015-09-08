package hu.adamsan.selenium.framework.pages;

import java.util.Random;

public class PostCreator {
    private static final String TITLE = "Test post, title ";
    private static String title;
    private static final String BODY = "Test post, body ";
    private static String body;
    private static final Random random = new Random();
    private static int number;

    public static void createPost() {
        NewPostPage.goTo();
        NewPostPage.createPost(createTitle()).withBody(createBody()).publish();
    }

    public static String getPreviousTitle() {
        return title;
    }

    public static String getPreviousBody() {
        return body;
    }

    private static String createTitle() {
        if (number == 0) {
            number = random.nextInt(100) + 1;
        }
        title = TITLE + number;
        return title;
    }

    private static String createBody() {
        if (number == 0) {
            number = random.nextInt(100) + 1;
        }
        body = BODY + number;
        return body;
    }

    public static void init() {
        title = null;
        body = null;
        number = 0;

    }

    public static void cleanup() {
        if (title != null) {
            ListPostsPage.trashPost(title);
        }
        init();
    }

}
