package hu.adamsan.selenium.framework.navigation;

public class LeftNavigation {
    public static class Posts {
        public static class AddNew {
            public static void select() {
                MenuSelector.select("menu-posts", "Add New");
            }
        }

        public static class AllPosts {

            public static void select() {
                MenuSelector.select("menu-posts", "All Posts");
            }
        }
    }

    public static class Pages {
        public static class AllPages {

            public static void select() {
                MenuSelector.select("menu-pages", "All Pages");
            }

        }
    }

}
