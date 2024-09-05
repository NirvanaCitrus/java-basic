package day10.miniProject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CommentDao {
}

class Comment {
    private String content;
    private LocalDateTime creationDate;

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd ; HH:mm:ss");

    public Comment(String content, LocalDateTime creationDate) {
        this.content = content;
        this.creationDate = creationDate;
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
}