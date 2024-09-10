package day12.testpageApp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class PostController {
    private Scanner sc = new Scanner(System.in);
    private PostDao postDao = new PostDao();
    private int indexCounter = 4;
    private PostView postView = new PostView();

    // 동작으로 이루어지는 메소드들, 여기에서는 데이터를 따로 받을 필요가 없다.(받으면 이원화가 일어나서 아무것도 안된다).
    // 관리인(postDao)가 데이터를 넘겨주고, 여기서 처리하는 것들을 받아서 저장도 해준다.
    // 따라서 컨트롤에서 신경써야 될것들은 동작을 위한 함수를 짜는것.

    public PostController () {
        Post p1 = new Post(1,"안녕하세요 자바 공부중이에요.","자바 공부",0,LocalDateTime.now());
        Post p2 = new Post(2,"자바 관련 질문 좀 할게요!","자바 질문",0, LocalDateTime.now());
        Post p3 = new Post(3,"정처기 따야 되나요?","정처기 질문",0, LocalDateTime.now());
        postDao.addPost(p1);
        postDao.addPost(p2);
        postDao.addPost(p3);
    }

    public void add () {
        System.out.println("게시물 제목을 입력해주세요: ");
        String title = sc.nextLine();
        System.out.println("게시물 내용을 입력해주세요: ");
        String content = sc.nextLine();

        Post post = new Post(indexCounter, title, content, 0, LocalDateTime.now());
        postDao.addPost(post);
        System.out.println("게시물이 등록되었습니다.");
        indexCounter++;
    }

    public void list () {
        ArrayList<Post> posts = postDao.getAllPosts();
        postView.printPostList(posts);
    }

    public void update () {
        System.out.println("수정할 게시물 번호를 입력하세요: ");
        int selectUpdate = Integer.parseInt(sc.nextLine());

        Post post = postDao.findPostById(selectUpdate);

        if (post == null) {
            System.out.println("게시물이 존재하지 않습니다.");
            return;

        } else {
            System.out.println("수정할 게시물 제목: ");
            String newTitle = sc.nextLine();
            System.out.println("수정할 게시물 내용: ");
            String newContent = sc.nextLine();

            post.setTitle(newTitle);
            post.setContent(newContent);
            System.out.println("게시물 수정이 완료되었습니다.");
        }
    }

    public void delete () {
        System.out.println("삭제할 게시물 번호를 입력하세요: ");
        int deleteSelect = Integer.parseInt(sc.nextLine());

        Post post = postDao.findPostById(deleteSelect);

        if (post == null) {
            System.out.println("게시물이 존재하지 않습니다.");
            return;

        } else {
            postDao.removePost(post);
            System.out.println("게시물이 삭제되었습니다.");
        }
    }

    public void detail () {
        System.out.println("상세보기할 게시물 번호: ");
        int targetId = Integer.parseInt(sc.nextLine());
        Post post = postDao.findPostById(targetId);

        if (post == null) {
            System.out.println("게시물이 존재하지 않습니다.");
            return;

        }

        post.setViewcount(post.getViewcount() + 1);
        postView.printPostDetail(post);
    }

    public void search () {
        System.out.println("검색 키워드 입력: ");
        String keyword = sc.nextLine();

        if (keyword == null) {
            System.out.println("검색 결과가 존재하지 않습니다.");
            return;

        }

        ArrayList<Post> searchedPostList = postDao.searchPostKeyword(keyword);
        postView.printPostList(searchedPostList);
    }
}
