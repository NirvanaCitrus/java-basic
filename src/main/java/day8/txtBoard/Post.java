package day8.txtBoard;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

class Post {
    private int id;
    private String title;
    private String content;
    private LocalDate creationDate;
    private LocalTime creationTime;
    private int viewcount;
    private int likecount;
    private ArrayList<String> comments;

    public Post(int id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.creationDate = creationDate;
        this.creationTime = creationTime;
        this.viewcount = 0;
        this.likecount = 0;
        this.comments = new ArrayList<>();

    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public LocalTime getCreationTime() {
        return creationTime;
    }

    public int getViewcount() {

        return viewcount;
    }

    public void trackViewcount() {
        this.viewcount++;
    }

    public int getLikecount() {
        return likecount;
    }

    public ArrayList<String> getComments() {
        return comments;
    }

    public void trackLikecount() {
        this.likecount++;
    }

    public void addComment(String comment) {
        comments.add(comment);

    }
}

