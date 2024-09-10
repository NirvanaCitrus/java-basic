package day12.testpageApp;

import java.util.ArrayList;

public class PostDao {

    private ArrayList<Post> posts = new ArrayList<>(); // 일종의 데이터 저장소. 데이터를 처리하고 관리하는 모든 로직이 PostDao 안에서 이루어짐 (관리인).
    // 이곳이 end point 가 되어야됨.


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
