package examExam.textBoardApp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;


public class PostController {
    private Scanner sc = new Scanner(System.in);
    private PostDao postDao = new PostDao();
    private PostView postView = new PostView();
    private int indexCounter = 4;

    public PostController() {
        Post p1 = new Post(1, "안녕하세요 자바 공부중이에요.", "자바 공부", 0, LocalDateTime.now());
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
        int deleteSelect;

        try {
            deleteSelect = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("번호를 입력하세요");
            return;
        }

        Post post = postDao.findPostById(deleteSelect);

        if (post == null) {
            System.out.println("게시물이 존재하지 않습니다.");
            return;

        }

        postDao.removePost(post);
        System.out.println("게시물이 삭제되었씁니다. ");
    }

    public void detail() {
        System.out.println("상세보기할 게시물 번호를 입력하세요: ");
        int detailSelect = getParsedInt(sc.nextLine(), -1); // 없는것은 대부분 -1로 표현.

        // try - catch 를 최대한 사용 안하는게 좋다.
        // 예외 상황을 최대한 안만드는게 좋다는 얘기.
        // 몇가지 상황을 제외하고는 try - catch 사용안하고 if로 처리 다 가능함.

        if(detailSelect == -1) {
            return;

        }


        Post post = postDao.findPostById(detailSelect);

        if (post == null) {
            System.out.println("게시물이 존재하지 않습니다.");
            return;

        }

        post.setViewcount(post.getViewcount() + 1);
        postView.printPostDetail(post);
    }

    public void list() {
        ArrayList<Post> posts = postDao.getAllPosts();

        if (posts.isEmpty()) {
            System.out.println("게시물이 등록되지 않았습니다.");
            return;

        }

        postView.printPostList(posts);
    }

    public void update() {
        System.out.println("수정할 게시물을 번호를 입력하세요: ");
        int targetId = getParsedInt(sc.nextLine(),-1);


        Post post = postDao.findPostById(targetId);

        if (post == null) {
            System.out.println("게시물이 존재하지 않습니다.");
            return;

        }

        System.out.println("수정할 제목을 입력하세요: ");
        String newTitle = sc.nextLine();
        System.out.println("수정할 내용을 입력하세요: ");
        String newContent = sc.nextLine();

        post.setTitle(newTitle);
        post.setContent(newContent);
        System.out.println("게시물이 수정되었습니다.");
    }

    public void search() {
        System.out.println("검색 키워드: ");
        String keyword = sc.nextLine();

        if (keyword.isEmpty()) {
            System.out.println("검색 결과가 없습니다.");

        }

        ArrayList<Post> searchedPostList = postDao.searchPostByKeyword(keyword);
        postView.printPostList(searchedPostList);
    }

    public int getParsedInt(String value, int defaultValue) {
        try {
            int parsedInt = Integer.parseInt(value);
            return parsedInt;

        } catch (NumberFormatException e) {
            System.out.println("숫자만 입력해주세요.");

        }
        return defaultValue;
    }
}
