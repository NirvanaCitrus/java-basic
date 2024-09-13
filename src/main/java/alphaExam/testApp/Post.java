package alphaExam.testApp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Post {
    private int id;
    private String title;
    private String content;
    private int viewcount;
    private LocalDateTime creationDate;
    private ArrayList<Comment> comments;

    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd ; HH:mm:ss");

    public Post(int id, String title, String content, int viewcount, LocalDateTime creationDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.viewcount = 0;
        this.creationDate = creationDate;
        this.comments = new ArrayList<>();

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

    public int getViewcount() {
        return viewcount;
    }

    public void setViewcount(int viewcount) {
        this.viewcount = viewcount;
    }

    public String getFormattedDate() {
        return creationDate.format(formatter);
    }

    public void addComment (Comment comment) {
        this.comments.add(comment);

    }
}
