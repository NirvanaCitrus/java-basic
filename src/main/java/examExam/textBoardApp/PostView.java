package examExam.textBoardApp;

import java.util.ArrayList;

public class PostView {

    public void printPostList (ArrayList<Post> targerList) {
        System.out.println("-----------------------------");
        for (Post post : targerList) {
            System.out.printf("번호: %d\n", post.getId());
            System.out.printf("제목: %s\n", post.getTitle());
            System.out.println("조회수: " + post.getViewcount());

        }

    }

    public void printPostDetail (Post post) {
        System.out.println("-----------------------------");
        System.out.printf("번호: %d\n", post.getId());
        System.out.printf("제목: %s\n", post.getTitle());
        System.out.printf("내용: %s\n", post.getContent());
        System.out.println("등록 날짜: " + post.getFormattedDate());
        System.out.println("조회수: " + post.getViewcount());
    }
}
