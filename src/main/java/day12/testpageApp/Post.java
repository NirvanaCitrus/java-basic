package day12.testpageApp;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Post {
    private int id;
    private String title;
    private String content;
    private LocalDateTime creationDate;
    private int viewcount;

    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd ; HH:mm:ss");

    public Post (int id, String title, String content, int viewcount, LocalDateTime creationDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.viewcount = 0;
        this.creationDate = creationDate;

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

    public String getFormattedTime () {
        return creationDate.format(formatter);

    }
}
