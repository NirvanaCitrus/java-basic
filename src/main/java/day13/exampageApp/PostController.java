package day13.exampageApp;



import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class PostController {
    private Scanner sc = new Scanner(System.in);
    private PostDao postDao = new PostDao();
    private PostView postView = new PostView();
    private int indexCounter = 4;


    public PostController () {
        Post p1 = new Post(1, "안녕하세요 자바 공부중이에요.","자바 공부 질문", 0, LocalDateTime.now());
        Post p2 = new Post(2, "자바 관련 질문 좀 할게요~", "자바 질문", 0, LocalDateTime.now());
        Post p3 = new Post(3, "정처기 따야 되나요?", "정처기 질문", 0 , LocalDateTime.now());
        postDao.addPost(p1);
        postDao.addPost(p2);
        postDao.addPost(p3);

    }

    public void add () {
        System.out.println("게시물 제목을 입력해주세요: ");
        String title = sc.nextLine();
        System.out.println("게시물 내용을 입력해주세요: ");
        String content = sc.nextLine();

        Post post = new Post(indexCounter,title,content,0, LocalDateTime.now());
        postDao.addPost(post);
        System.out.println("게시물이 등록되었습니다.");
        indexCounter++;
    }

    public void delete () {
        System.out.println("삭제할 게시물 번호를 입력하세요: ");
        int deleteSelect = Integer.parseInt(sc.nextLine());

        Post post = postDao.findPostById(deleteSelect);

        if (post == null) {
            System.out.println("게시물이 존재하지 않습니다.");
            return;

        }

        postDao.removePost(post);
        System.out.println("게시물이 삭제되었습니다.");
    }

    public void list () {
        ArrayList<Post> posts = postDao.getAllPosts();

        if (posts.isEmpty()) {
            System.out.println("게시물이 등록되지 않았습니다.");
            return;

        }
        postView.printPostList(posts);

    }

    public void update () {
        System.out.println("수정할 게시물 번호를 입력하세요: ");
        int updateSelect = Integer.parseInt(sc.nextLine());

        Post post = postDao.findPostById(updateSelect);

        if (post == null) {
            System.out.println("없는 게시물 번호입니다.");
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

    public void search () {
        System.out.println("검색 키워드: ");
        String keyword = sc.nextLine();

        if (keyword.isEmpty()) {
            System.out.println("검색 결과가 없습니다.");
            return;

        }

        ArrayList<Post> searchedPostList = postDao.searchPostKeyword(keyword);
        postView.printPostList(searchedPostList);
    }

    public void detail () {
        System.out.println("상세보기할 게시물 번호를 입력하세요: ");
        int targetPost = Integer.parseInt(sc.nextLine());
        Post post = postDao.findPostById(targetPost);

        if (post == null) {
            System.out.println("게시물이 존재하지 않습니다.");
            return;

        }

        post.setViewcount(post.getViewcount() + 1);
        postView.printPostDetail(post);

    }
}
