package day10.post;

import day10.miniProject.CommentDao;
import day10.miniProject.User;
import day10.miniProject.UserDao;
import day10.userAuthentication.UserAuthentication;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class PostController {

    private Scanner sc = new Scanner(System.in);
    private PostDao postDao = new PostDao();
    private UserAuthentication userAuth; // userAuth 를 이원화 했던 문제를 해결 (09/09)
    private PostView postView;
    private ArrayList<UserDao> users = new ArrayList<>();
    private int latestId = 4;
    private int postsPerPage = 5;
    // new UserAuthentication 을 하게 되면 새 객체가 생겨나 버리게 됨으로 로그인 하는 유저와 postController 를 사용하는 유저가 달라지게 됨.
    // 따라서 userAuth 변수는 homepageApp 에서 이미 받았고 사용되고 있으니 그 정보를 PostController 에서 사용할 수 있게 받아주는게 필요함.


    public PostController(UserAuthentication userAuth) { // <= 여기에 userAuth 를 받아줌으로 PostController 가 생성될때 받아주게 만듬
        // PostController 생성자를 만들때 userAuth 정보를 받지않으면 생성되지 않게 만듬으로 해서 생성자가 만들어질때 강제적으로 userAuth 값을 받을수 밖에 없게 만듬.
        // 이렇게 하면 로그인과 회원가입 할때 받은 정보들을 생성자에서 받아서 쓸수 있게 됨으로 null 값으로 돌아가지 않는다.
        this.userAuth = userAuth;
        postView = new PostView(userAuth);
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
        post.setViewcount(post.getViewcount() + 1);
        // ======
        postView.printPostDetail(post); // 서빙한테 넘겨줌

        while (true) {
            System.out.println("상세보기 기능을 선택해주세요 (1. 댓글 등록, 2. 좋아요, 3. 수정, 4. 삭제 , 5. 목록으로): ");
            int command = Integer.parseInt(sc.nextLine());
            if (command == 1) {
                if (userAuth.getLoggedInUser() == null) {
                    System.out.println("댓글을 등록하려면 먼저 로그인해야 합니다.");
                    return;

                }
                System.out.println("댓글 입력: ");
                String commentContent = sc.nextLine();
                CommentDao comment = new CommentDao(userAuth.getLoggedInUser().getUsername(), commentContent, LocalDateTime.now());
                post.addComment(comment);

            } else if (command == 2) {
                if (userAuth.getLoggedInUser() == null) {
                    System.out.println("좋아요를 누르려면 먼저 로그인해야 합니다.");
                    return;

                }

                String username = userAuth.getLoggedInUser().getUsername();
                boolean isLiked = post.toggleLike(username);

                if (isLiked) {
                    System.out.println("좋아요를 눌렀습니다! (❤)");

                } else {
                    System.out.println("좋아요를 취소했습니다. (♡)");
                }

                System.out.println("현재 좋아요 수: " + post.getLikecount());

            } else if (command == 3) {
                if (userAuth.getLoggedInUser() == null) {
                    System.out.println("게시물을 수정하려면 먼저 로그인 해야됩니다.");
                    return;

                }

                if (!post.getCreator().equals(userAuth.getLoggedInUser().getUsername())) {
                    System.out.println("자신의 게시물만 수정할 수 있습니다.");
                    return;

                }

                System.out.print("수정할 제목 : ");
                String newTitle = sc.nextLine();
                System.out.print("수정할 내용 : ");
                String newBody = sc.nextLine();

                post.setTitle(newTitle);
                post.setContent(newBody);
                System.out.println("수정이 완료되었습니다.");

            } else if (command == 4) {
                if (userAuth.getLoggedInUser() == null) {
                    System.out.println("삭제하려면 로그인해야 합니다.");
                    return;
                }

                if (!post.getCreator().equals(userAuth.getLoggedInUser().getUsername())) {
                    System.out.println("자신의 게시물만 삭제할 수 있습니다.");
                    return;
                }

                postDao.delete(post);
                System.out.println("삭제가 완료되었습니다.");

            } else if (command == 5) {
                System.out.println("목록으로 돌아갑니다.");
                return;

            }

        }


    }

    public void displayPostsForPage (int page) {
        ArrayList<Post> posts = postDao.getPostForPage(page, postsPerPage);
        postView.printPostList(posts);

        int totalPages = postDao.getTotalPages(postsPerPage);
        System.out.printf("Page %d of %d\n", page , totalPages);

    }

    public void Page () {
        int currentPage = 1;
        int totalPages = postDao.getTotalPages(postsPerPage);

        while (true) {
            displayPostsForPage(currentPage);

            System.out.println("Select an option: ");
            System.out.println("1. Next page");
            System.out.println("2. Previous page");
            System.out.println("3. Exit");
            int choice = Integer.parseInt(sc.nextLine());

            if (choice == 1 && currentPage < totalPages) {
                currentPage++;

            } else if (choice == 2 && currentPage > 1) {
                currentPage--;

            } else if (choice == 3) {
                break;

            } else {
                System.out.println("존재하지 않는 옵션입니다.");
            }
        }

    }

    public void sort () {
        System.out.println("정렬 기준을 선택해주세요 (1. 조회수, 2. 번호): ");
        int sortOption = Integer.parseInt(sc.nextLine());

        System.out.println("정렬 순서를 선택해주세요 (1. 오름차순, 2. 내림차순): ");
        int orderOption = Integer.parseInt(sc.nextLine());

        List<Post> posts = postDao.getPosts();

        if (sortOption == 1) {
            if (orderOption == 1) {
                posts.sort(Comparator.comparingInt(Post::getViewcount));

            } else if (orderOption == 2) {
                posts.sort(Comparator.comparingInt(Post::getViewcount).reversed());

            }
        } else if (sortOption == 2) {
            if (orderOption == 1) {
                posts.sort(Comparator.comparingInt(Post::getId));

            } else if (orderOption == 2) {
                posts.sort(Comparator.comparingInt(Post::getId).reversed());

            }

        } else {
            System.out.println("잘못된 옵션입니다.");
            return;
        }

        postView.printPosts(posts);
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

        if (!post.getCreator().equals(userAuth.getLoggedInUser().getUsername())) {
            System.out.println("자신의 게시물만 삭제할 수 있습니다.");
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
            System.out.println("자신의 게시물만 수정할 수 있습니다.");
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
        Post post = new Post(latestId, title, body, LocalDateTime.now(), 0, userAuth.getLoggedInUser().getUsername());
        postDao.save(post);
        System.out.println("게시물이 등록되었습니다.");
        latestId++;
    }


}
