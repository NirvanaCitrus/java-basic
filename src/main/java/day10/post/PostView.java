package day10.post;

import day10.miniProject.CommentDao;
import day10.userAuthentication.UserAuthentication;

import java.util.ArrayList;
import java.util.List;

public class PostView {

    private UserAuthentication userAuth;

    public PostView (UserAuthentication userAuth) {
        this.userAuth = userAuth;

    }

    public void printPostList(ArrayList<Post> targetList) {
        System.out.println("==================");
        for (Post post : targetList) {
            System.out.printf("번호 : %d\n", post.getId());
            System.out.printf("제목 : %s\n", post.getTitle());
            System.out.println("조회수 : " + post.getViewcount());
            System.out.println("==================");
        }
    }

    public void printPostDetail(Post post) {
        System.out.printf("번호 : %d\n", post.getId());
        System.out.printf("제목 : %s\n", post.getTitle());
        System.out.printf("내용 : %s\n", post.getContent());
        System.out.printf("등록날짜 : %s\n", post.getFormattedCreationDate());
        System.out.printf("조회수 : %d\n", post.getViewcount());
        System.out.printf("좋아요 : %d\n", post.getLikecount());

        System.out.println("좋아요 상태: ♡ (Not Liked)");

        if (userAuth.getLoggedInUser() != null) {
            String username = userAuth.getLoggedInUser().getUsername();
            if (post.hasUserLiked(username)) {
                System.out.println("좋아요 상태: ♥ (Liked)");

            }

        }


        System.out.println("\n댓글: ");
        if (post.getComments().isEmpty()) {
            System.out.println("댓글이 작성되지 않았습니다.");

        } else {
            for (CommentDao comment : post.getComments()) {
                System.out.println("작성자: " + comment.getUsername());
                System.out.println("댓글 내용: " + comment.getContent());
                System.out.println("작성 날짜: " + comment.getFormattedCreationDate());
                System.out.println("-------------------------------");


            }
        }


    }

    public void printPosts(List<Post> posts) {
        for (Post post : posts) {
            System.out.printf("번호: %d, 제목: %s, 조회수: %d, 좋아요: %d\n", post.getId(), post.getTitle(), post.getViewcount(), post.getLikecount());

        }

    }
}