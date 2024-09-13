package alphaExam.testApp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class PostController {
    private PostDao postDao = new PostDao();
    private PostView postView = new PostView();
    private Scanner sc = new Scanner(System.in);
    private UserControl userControl = new UserControl();
    private CommentDao commentDao = new CommentDao();
    int indexCounter = 4;

    public PostController(UserControl userControl) {
        this.userControl = userControl;

        Post p1 = new Post(1, "자바 공부중", "자바 공부 질문", 0, LocalDateTime.now());
        Post p2 = new Post(2, "자바 프로그램", "자바 요청", 0, LocalDateTime.now());
        Post p3 = new Post(3, "정처기 자격증", "정처기 질문", 0, LocalDateTime.now());
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
            System.out.println("게시물이 존재하지 않습니다.");
            return;

        } else {
            postDao.removePost(post);
            System.out.println("게시물이 삭제되었습니다.");
        }
    }

    public void detail() {
        System.out.println("상세보기할 게시물 번호를 입력하세요: ");
        int detailSelect = Integer.parseInt(sc.nextLine());

        Post post = postDao.findPostById(detailSelect);

        if (post == null) {
            System.out.println("게시물이 존재하지 않습니다.");
            return;

        }
        post.setViewcount(post.getViewcount() + 1);
        postView.printPostDetail(post);

        while (true) {
            System.out.println("상세보기 도구 (1. 댓글 등록, 2. 추천, 3. 수정, 4. 삭제, 5. 목록으로): ");
            int command = Integer.parseInt(sc.nextLine());

            if (command == 1) {
                if (userControl.getLoggedInUser() == null) {
                    System.out.println("댓글을 등록하려면 로그인해야 합니다.");
                    return;

                }
                System.out.println("댓글을 입력하세요: ");
                String reply = sc.nextLine();
                Comment comment = new Comment(reply, userControl.getLoggedInUser().getUsername(), LocalDateTime.now());
                post.addComment(comment);
                System.out.println("댓글이 등록되었습니다.");


            } else if (command == 2) {
                System.out.println("추천 기능");


            } else if (command == 3) {
                if (userControl.getLoggedInUser() == null) {
                    System.out.println("게시물을 수정하려면 로그인해야 합니다.");
                    return;

                }
                System.out.println("수정할 게시물 번호를 입력하세요: ");
                int targetId = Integer.parseInt(sc.nextLine());
                postDao.findPostById(targetId);

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
                    System.out.println("게시물이 수정되었습니다.");

                }
            } else if (command == 4) {
                if (userControl.getLoggedInUser() == null) {
                    System.out.println("게시물을 삭제하려면 로그인해야 합니다.");
                    return;

                }
                System.out.println("삭제할 게시물을 번호를 입력하세요: ");
                int targetId = Integer.parseInt(sc.nextLine());
                postDao.findPostById(targetId);

                if (post == null) {
                    System.out.println("삭제할 게시물이 없습니다.");
                    return;

                }
                postDao.removePost(post);

            } else if (command == 5) {
                System.out.println("목록으로 돌아갑니다.");
                return;

            } else {
                System.out.println("존재하지 않는 기능입니다.");
                continue;
            }
        }

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
        System.out.println("수정할 게시물 번호를 입력하세요: ");
        int targetId = Integer.parseInt(sc.nextLine());

        Post post = postDao.findPostById(targetId);

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
            System.out.println("게시물이 수정되었습니다.");
        }
    }

    public void search() {
        System.out.println("검색 키워드: ");
        String keyword = sc.nextLine().trim();


        if (keyword.isEmpty()) {
            System.out.println("검색어를 입력하세요.");
            return;

        }

        ArrayList<Post> searchedPostList = postDao.searchPostKeyword(keyword);

        if (searchedPostList.isEmpty()) {
            System.out.println("검색 결과가 없습니다.");

        } else {
            postView.printPostList(searchedPostList);
        }

    }
}
