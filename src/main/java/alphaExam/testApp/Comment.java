package alphaExam.testApp;

import day10.miniProject.CommentDao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Comment {
    private String content;
    private String username;
    private LocalDateTime creationDate;

    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public Comment (String content, String username, LocalDateTime creationDate) {
        this.content = content;
        this.username = username;
        this.creationDate = creationDate;



    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFormattedDate () {
        return creationDate.format(formatter);
    }

    @Override
    public String toString () {
        return "작성자: " + username + ", 댓글 내용: " + content + ", 작성 날짜: " + getFormattedDate();
    }


}
