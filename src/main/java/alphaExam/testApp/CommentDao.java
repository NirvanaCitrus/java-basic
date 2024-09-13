package alphaExam.testApp;

import java.util.ArrayList;

public class CommentDao {
    ArrayList<Comment> comments = new ArrayList<>();

    public void addComment (Comment comment) {
        comments.add(comment);

    }

    public void removeComment (Comment comment) {
        comments.remove(comment);

    }
}
