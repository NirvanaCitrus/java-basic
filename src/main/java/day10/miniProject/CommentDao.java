package day10.miniProject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CommentDao {
    private String content;
    private LocalDateTime creationDate;
    private String username;

    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd ; HH:mm:ss");

    public CommentDao(String username, String content, LocalDateTime creationDate) {
        this.username = username;
        this.content = content;
        this.creationDate = creationDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;

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

    public String getFormattedCreationDate () {
        return creationDate.format(formatter);
    }

@Override
    public String toString () {
        return "작성자 : " + username + ", 댓글 내용: " + content + ", 작성 날짜: " + getFormattedCreationDate();
    }
}
