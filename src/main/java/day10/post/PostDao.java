package day10.post;



import day10.miniProject.CommentDao;
import day10.miniProject.User;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

// 창고 관리(Model)
public class PostDao {
    private ArrayList<Post> posts = new ArrayList<>();


    //누군가에게 Post를 넘겨받아서 창고(ArrayList)에 저장 해주는 기능
    public void save(Post post) {
        posts.add(post);
    }

    // 자신이 가지고 있는 창고(ArrayList)의 내용물을 다른 누군가에게 전달.
    public ArrayList<Post> getPosts() {
        return posts;
    }

    // 창고에서 특정 물건을 제거함
    public void delete(Post post) {
        posts.remove(post);

    }

    // keyword가 포함된 Post 만 선별해서 Arraylist로 담아 필요한 누군가에게 제공.
    public ArrayList<Post> getPostByKeyword(String keyword) {
        ArrayList<Post> searchedPostList = new ArrayList<>();
        for (Post post : posts) {
            if (post.getTitle().contains(keyword)) {
                searchedPostList.add(post);
            }
        }
        return searchedPostList;
    }

    public Post findPostById(int id) {

        // 만약 내가 찾고자 하는 게시물이 없다면?

        for (Post post : posts) {
            if (post.getId() == id) {
                return post; // return을 만나면 메서드는 그 즉시 종료.
            }
        }

        return null; // null은 없다라는 의미
    }
}

class Post {
    private int id;
    private String title;
    private String content;
    private LocalDateTime creationDate;
    private int viewcount;
    private int likecount;
    private ArrayList<CommentDao> comments;
    private String creator;

    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd ; HH:mm:ss");

    public Post(int id, String title, String content, LocalDateTime creationDate, int viewcount, String creator) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.creationDate = creationDate;
        this.viewcount = 0;
        this.likecount = 0;
        this.comments = new ArrayList<>();
        this.creator = creator;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public int getViewcount() {
        return viewcount;
    }

    public void setViewcount(int viewcount) {
        this.viewcount = viewcount;
    }

    public int getLikecount() {
        return likecount;
    }

    public void setLikecount(int likecount) {
        this.likecount = likecount;
    }

    public ArrayList<CommentDao> getComments() {
        return comments;
    }

    public void setComments(ArrayList<CommentDao> comments) {
        this.comments = comments;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }
}
