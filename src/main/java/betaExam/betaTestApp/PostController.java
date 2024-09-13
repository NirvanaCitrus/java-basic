package betaExam.betaTestApp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class PostController {
    private Scanner sc = new Scanner(System.in);
    private PostDao postDao = new PostDao();
    private PostView postView = new PostView();
    private int indexCounter = 4;

    public PostController() {
        Post p1 = new Post(1, "안녕하세요 자바 공부중이에요", "자바 공부 질문", 0, LocalDateTime.now());
        Post p2 = new Post(2, "자바 질문 좀 할게요~", "자바 질문", 0, LocalDateTime.now());
        Post p3 = new Post(3, "정처기 따야되나요?", "정처기 질문", 0, LocalDateTime.now());
        postDao.addPost(p1);
        postDao.addPost(p2);
        postDao.addPost(p3);

    }

    public void add() {
        System.out.println("게시물 제목을 입력하세요: ");
        String title = sc.nextLine();
        System.out.println("게시물 내용을 입력하세요: ");
        String content = sc.nextLine();

        Post post = new Post(indexCounter, title, content, 0, LocalDateTime.now());
        postDao.addPost(post);
        System.out.println("게시물이 등록되었습니다.");
        indexCounter++;
    }

    public void delete() {
        System.out.println("삭제할 게시물 번호를 입력하세요: ");
        int deleteSelect = Integer.parseInt(sc.nextLine());

        Post post = postDao.findPostById(deleteSelect);

        if (post == null) {
            System.out.println("게시물이 존재하지 않습니다");
            return;
        } else {
            postDao.removePost(post);
            System.out.println("게시물이 삭제되었습니다.");

        }


    }

    public void detail() {
        System.out.println("상세보기할 게시물 번호를 입력하세요: ");
        int targetPost = Integer.parseInt(sc.nextLine());

        Post post = postDao.findPostById(targetPost);

        if (post == null) {
            System.out.println("게시물이 존재하지 않습니다.");

        } else {
            postView.printPostDetail(post);

        }

        while (true) {
            System.out.println("상세보기 도구 (1. 댓글 등록, 2. 추천, 3. 수정, 4. 삭제, 5. 목록으로): ");
            int command;

            try {
                command = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("유효한 숫자를 입력하세요.");
                continue;
            }

            if (command == 5) {
                System.out.println("목록으로 돌아갑니다.");
                break;

            } else if (command == 1) {
                System.out.println("댓글 기능");

            } else if (command == 2) {
                System.out.println("추천 기능");

            } else if (command == 3) {
                System.out.println("수정 기능");

            } else if (command == 4) {
                System.out.println("삭제 기능");

            } else {
                System.out.println("존재하지 않는 기능입니다.");
                return;
            }
        }

    }

    public void list() {
        ArrayList<Post> posts = postDao.getAllPosts();

        if (posts.isEmpty()) {
            System.out.println("게시물이 등록되지 않았습니다.");

        }
        postView.printPostList(posts);

    }

    public void update() {
        System.out.println("수정할 게시물 번호를 입력하세요: ");
        int editSelect = Integer.parseInt(sc.nextLine());

        Post post = postDao.findPostById(editSelect);

        if (post == null) {
            System.out.println("게시물이 존재하지 않습니다.");
            return;

        } else {
            System.out.println("수정할 제목을 입력하세요: ");
            String newTitle = sc.nextLine();
            System.out.println("수정할 내용을 입력하세요: ");
            String newContent = sc.nextLine();

            post.setTitle(newTitle);
            post.setContent(newContent);
            System.out.println("게시물 수정이 완료되었습니다.");


        }

    }

    public void search() {
        System.out.println("검색 키워드: ");
        String keyword = sc.nextLine();

        ArrayList<Post> searchedPostList = postDao.searchPostKeyword(keyword);

        if (keyword.isEmpty()) {
            System.out.println("키워드를 입력하세요.");
            return;

        }

        if (searchedPostList.isEmpty()) {
            System.out.println("검색 결과가 없습니다.");
            return;

        } else {
            postView.printPostList(searchedPostList);
        }
    }
}
