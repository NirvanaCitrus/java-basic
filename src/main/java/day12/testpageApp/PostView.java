package day12.testpageApp;

import java.util.ArrayList;


// 디스플레이라고 생각하면 편하다.
// 데이터가 어떻게 보여질지 그 설정들을 맞춰가는 곳이다.

public class PostView {
    public void printPostList (ArrayList<Post> targetList) { // Post 를 받는 이유는 Post 에 관한 것들만 출력하게 만드는것.
        System.out.println("----------------------");
        for (Post post : targetList) {
            System.out.printf("번호: %d\n", post.getId());
            System.out.printf("제목: %s\n",post.getTitle());
            System.out.println("조회수: " + post.getViewcount());

        }

    }

    public void printPostDetail(Post post) { // Post 자체를 받는 이유는 여기서도 Post 에 관한 것만 출력하게 만드는것.
        System.out.printf("번호: %d\n", post.getId());
        System.out.printf("제목: %s\n",post.getTitle());
        System.out.printf("내용: %s\n", post.getContent());
        System.out.println("등록 날짜 : " + post.getFormattedTime());
        System.out.println("조회수: " + post.getViewcount());
    }
}
