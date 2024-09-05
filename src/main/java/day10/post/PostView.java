package day10.post;

import java.util.ArrayList;

public class PostView {

    public void printPostList(ArrayList<Post> targetList) {
        System.out.println("==================");
        for (Post post : targetList) {
            System.out.printf("번호 : %d\n", post.getId());
            System.out.printf("제목 : %s\n", post.getTitle());
            System.out.println("작성자 : " + post.getCreator());
            System.out.println("==================");
        }
    }

    public void printPostDetail(Post post) {
        System.out.printf("번호 : %d\n", post.getId());
        System.out.printf("제목 : %s\n", post.getTitle());
        System.out.printf("내용 : %s\n", post.getContent());
        System.out.printf("등록날짜 : %s\n", post.getCreationDate());
        System.out.printf("조회수 : %d\n", post.getLikecount());
    }
}