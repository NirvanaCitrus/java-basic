package day10.post;



import day10.likeFunction.LikeManager;
import day10.miniProject.CommentDao;
import day10.miniProject.User;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

// 창고 관리(Model)
public class PostDao {
    private ArrayList<Post> posts = new ArrayList<>();
    private List<Post> orderPost = new ArrayList<>();



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

    public ArrayList<Post> getPostForPage (int page,int postsPerPage) {
        int startIndex = (page - 1) * postsPerPage;
        int endIndex = Math.min(startIndex + postsPerPage, posts.size());

        if (startIndex >= posts.size() || startIndex < 0) {
            return new ArrayList<>();

        }
        return new ArrayList<>(posts.subList(startIndex, endIndex));

    }

    public int getTotalPages (int postsPerPage) {
        return (int) Math.ceil((double) posts.size() / postsPerPage);

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
    private ArrayList<CommentDao> comments;
    private String creator;
    private LikeManager likeManager;
    private int likecount;

    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd ; HH:mm:ss");

    public Post(int id, String title, String content, LocalDateTime creationDate, int viewcount, String creator) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.creationDate = creationDate;
        this.viewcount = 0;
        this.comments = new ArrayList<>();
        this.creator = creator;
        this.likeManager = new LikeManager();
    }

    public boolean toggleLike(String username) {
        return likeManager.toggleLike(username);

    }

    public boolean hasUserLiked(String username) {
        return likeManager.hasUserLiked(username);

    }

    public int getLikecount () {
        return likeManager.getLikeCount();
    }

    public void addComment (CommentDao comment) {
        this.comments.add(comment);
        System.out.println("댓글이 추가되었습니다.");

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

    public String getFormattedCreationDate () {
        return creationDate.format(formatter);
    }
}
