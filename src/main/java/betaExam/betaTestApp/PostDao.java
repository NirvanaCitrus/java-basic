package betaExam.betaTestApp;

import java.util.ArrayList;

public class PostDao {
    private ArrayList<Post> posts = new ArrayList<>();

    public void addPost (Post post) {
        posts.add(post);

    }

    public void removePost (Post post) {
        posts.remove(post);

    }

    public ArrayList<Post> getAllPosts () {
        return posts;
    }

    public Post findPostById (int id) {
        for (Post post : posts) {
            if (post.getId() == id) {
                return post;

            }

        }
        return null;

    }

    public ArrayList<Post> searchPostKeyword (String keyword) {
        ArrayList<Post> searchedPostList = new ArrayList<>();
        for (Post post : posts) {
            if (post.getTitle().contains(keyword)) {
                searchedPostList.add(post);

            }

        }
        return searchedPostList;

    }
}
