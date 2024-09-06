package day10.post;

import day10.miniProject.User;
import day10.miniProject.UserDao;
import day10.userAuthentication.UserAuthentication;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class PostController {

    private PostDao postDao = new PostDao();
    private PostView postView = new PostView();
    private Scanner sc = new Scanner(System.in);
    private int latestId = 4;
    private ArrayList<UserDao> users = new ArrayList<>();
    private UserAuthentication userAuth = new UserAuthentication();

    public PostController() {
        String loggedInUser = "Test User";

        Post p1 = new Post(1, "안녕하세요 반갑습니다. 자바 공부중이에요.", "냉무", LocalDateTime.now(), 0, loggedInUser);
        Post p2 = new Post(2, "자바 질문좀 할게요~", "냉무", LocalDateTime.now(), 0, loggedInUser);
        Post p3 = new Post(3, "정처기 따야되나요?", "정처기", LocalDateTime.now(), 0, loggedInUser);
        postDao.save(p1);
        postDao.save(p2);
        postDao.save(p3);
    }
    public void detail() {
        System.out.print("상세보기 할 게시물 번호 : ");
        int targetId = Integer.parseInt(sc.nextLine());

        Post post = postDao.findPostById(targetId);  // 창고에서 꺼내서

        // ==== 요리를 한다음
        if (post == null) {
            System.out.println("없는 게시물 번호 입니다.");
            return;
        }
        post.getViewcount();
        // ======
        postView.printPostDetail(post); // 서빙한테 넘겨줌

    }

    public void list() {
        ArrayList<Post> posts = postDao.getPosts();
        postView.printPostList(posts);
    }

    public void search() {
        System.out.print("검색 키워드 : ");
        String keyword = sc.nextLine();

        ArrayList<Post> searchedPostList = postDao.getPostByKeyword(keyword);
        postView.printPostList(searchedPostList);
    }

    public void delete() {
        if (userAuth.getLoggedInUser() == null) {
            System.out.println("삭제하려면 로그인해야 합니다.");
            return;
        }
        System.out.print("삭제할 게시물 번호 : ");
        int targetId = Integer.parseInt(sc.nextLine());
        Post post = postDao.findPostById(targetId);

        if (post == null) {
            System.out.println("없는 게시물 번호입니다.");
            return;
        }

        postDao.delete(post);
        System.out.println("삭제가 완료되었습니다.");

    }
    public void update() {
        if (userAuth.getLoggedInUser() == null) {
            System.out.println("게시물을 수정하려면 먼저 로그인 해야됩니다.");
            return;

        }
        System.out.print("수정할 게시물 번호 : ");
        int targetId = Integer.parseInt(sc.nextLine());

        Post post = postDao.findPostById(targetId);

        if (post == null) {
            System.out.println("없는 게시물 번호입니다.");
            return;
        }

        if (!post.getCreator().equals(userAuth.getLoggedInUser().getUsername())) {
            System.out.println("이 게시물을 수정할 권한이 없습니다.");
            return;

        }

        System.out.print("수정할 제목 : ");
        String newTitle = sc.nextLine();
        System.out.print("수정할 내용 : ");
        String newBody = sc.nextLine();

        post.setTitle(newTitle);
        post.setContent(newBody);
        System.out.println("수정이 완료되었습니다.");
    }

    public void add() {
        if (userAuth.getLoggedInUser() == null) {
            System.out.println("게시물을 작성하려면 로그인해야 합니다.");
            return;
        }
        System.out.print("게시물 제목을 입력해주세요 : ");
        String title = sc.nextLine();
        System.out.print("게시물 내용을 입력해주세요 : ");
        String body = sc.nextLine();
        Post post = new Post(latestId, title, body, LocalDateTime.now(),0, );
        postDao.save(post);
        System.out.println("게시물이 등록되었습니다.");
        latestId++;
    }


}
