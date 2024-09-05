package day8.miniProject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class MiniProject {
    public static void main(String[] args) {
        Homepage homepage = new Homepage();
        homepage.Start();

    }
}

class Post {
    private int id;
    private String title;
    private String content;
    private LocalDateTime creationDate;
    private int viewcount;
    private int likecount;
    private ArrayList<Comment> comments;
    private String creator;

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd ; HH:mm:ss");

    public Post(int id, String title, String content, LocalDateTime creationDate, String creator) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.creationDate = creationDate;
        this.viewcount = 0;
        this.likecount = 0;
        this.comments = new ArrayList<>();
        this.creator = creator;

    }

    public String getFormattedCreationDate () {
        return creationDate.format(formatter);
    }

    public String getCreator() {
        return creator;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public int getViewcount() {
        return viewcount;
    }

    public void trackViewcount() {
        this.viewcount++;
    }

    public int getLikecount() {
        return likecount;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void trackLikecount() {
        this.likecount++;
    }

    public void addComment(Comment comment) {
        comments.add(comment);

    }
}

class Comment {
    private String content;
    private LocalDateTime creationDate;

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd ; HH:mm:ss");

    public Comment(String content, LocalDateTime creationDate) {
        this.content = content;
        this.creationDate = creationDate;

    }

    public String getContent() {
        return content;
    }

    public String getFormattedCreationDate() {
        return creationDate.format(formatter);
    }
}

class User {
    private String userId;
    private String password;
    private String username;

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public User(String userId, String password, String username) {
        this.userId = userId;
        this.password = password;
        this.username = username;


    }
}

class Homepage {
    Scanner sc = new Scanner(System.in);
    ArrayList<Post> posts = new ArrayList<>();
    ArrayList<User> users = new ArrayList<>();
    User loggedInUser = null;
    int postIdCounter = 1; // 가장 최신의 id값. id값의 고유성을 유지하기 위해 1씩 증가시킬 계획임.

    public Homepage() {
        initializeTestPosts();
    }

    public void Start() {
        while (true) {
            System.out.println("======= Welcome to Satellite =======");
            System.out.println("명령어를 입력해주세요(1. signup, 2. login, 3. board, 4. exit : ");
            String command = sc.nextLine();

            if (command.equals("signup")) {
                signUp();

            } else if (command.equals("login")) {
                login();

            } else if (command.equals("board")) {
                showPosts();

            } else if (command.equals("exit")) {
                System.out.println("See you Again! ");
                break;

            }
        }
    }

    public void signUp() {
        System.out.println("======= 회원 가입 =======");
        System.out.println("사용할 아이디를 입력해주세요 : ");
        String userId = sc.nextLine();

        for (User user : users) {
            if (user.getUserId().equals(userId)) {
                System.out.println("이미 사용중인 아이디입니다. 다시 시도하세요.");
                return;

            }

        }

        System.out.println("사용할 비밀번호를 입력하세요 : ");
        String password = sc.nextLine();

        System.out.println("사용할 닉네임을 입력하세요 : ");
        String username = sc.nextLine();

        User newUser = new User(userId, password, username);
        users.add(newUser);

        System.out.println("Satellite 회원이 되신 것을 축하합니다.");
    }

    public void login() {
        System.out.println("======= 로그인 =======");
        System.out.println("아이디를 입력하세요 : ");
        String userId = sc.nextLine();
        System.out.println("비밀번호를 입력하세요 : ");
        String password = sc.nextLine();

        for (User user : users) {
            if (user.getUserId().equals(userId) && user.getPassword().equals(password)) {
                loggedInUser = user;
                System.out.println("로그인 성공! " + loggedInUser.getUsername() + " 님 환영합니다! ");
                return;

            }

        }
        System.out.println("로그인 실패. 아이디 또는 비밀번호를 확인하세요.");
    }

    public void showPosts() {
        while (true) {
            for (Post post : posts) {
                System.out.println(post.getId() + ") " + post.getTitle() + " - 작성일: " + post.getFormattedCreationDate());


            }
            System.out.println("옵션: 1) detail  2) add  3) logout  4) back to main");
            int command = Integer.parseInt(sc.nextLine());

            if (command == 1) {
                viewPostDetail();
            } else if (command == 2) {
                if (loggedInUser == null) {
                    System.out.println("게시물을 작성하려면 먼저 로그인해야 합니다.");
                    return;
                } else {
                    addPost();
                }
            } else if (command == 3) {
                loggedInUser = null;
                System.out.println("로그아웃되었습니다.");
                return;
            } else if (command == 4) {
                break;
            } else {
                System.out.println("유효하지 않은 명령입니다. 다시 시도하세요.");
            }
        }
    }

    public void addPost() {
        System.out.println("게시물 제목을 입력해주세요 : ");
        String title = sc.nextLine();
        System.out.println("게시물 내용을 입력해주세요 : ");
        String content = sc.nextLine();
        int newId = posts.size() + 1;
        Post newPost = new Post(newId, title, content, LocalDateTime.now(), loggedInUser.getUsername());
        posts.add(newPost);
        System.out.println("게시물이 등록되었습니다.");
    }

    public void viewPostDetail() {
        System.out.println("상세보기 할 게시물 번호를 입력해주세요 : ");
        int id = Integer.parseInt(sc.nextLine());
        boolean found = false;

        for (Post post : posts) {
            if (post.getId() == id) {
                post.trackViewcount();
                System.out.println("게시물 번호 : " + post.getId());
                System.out.println("제목 : " + post.getTitle());
                System.out.println("내용 : " + post.getContent());
                System.out.println("작성일 : " + post.getFormattedCreationDate());
                System.out.println("조회수 : " + post.getViewcount());
                System.out.println("좋아요 : " + post.getLikecount());
                System.out.println("댓글 수 : " + post.getComments().size());
                System.out.println("-----");

                if (!post.getComments().isEmpty()) {
                    System.out.println("===== 댓글 =====");
                    for (Comment comment : post.getComments()) {
                        System.out.println(comment.getContent());
                        System.out.println("작성일: " + comment.getFormattedCreationDate());
                        System.out.println("-------");

                    }

                }
                while (true) {
                    System.out.println("상세보기 기능을 선택해주세요 (1. 댓글 등록, 2. 추천, 3. 수정, 4. 삭제, 5. 목록으로) :");
                    int option = Integer.parseInt(sc.nextLine());

                    if (option == 1) {
                        if (loggedInUser == null) {
                            System.out.println("댓글을 작성하려면 먼저 로그인해야 합니다.");

                        } else {
                            System.out.println("댓글을 입력하세요");
                            String commentContent = sc.nextLine();
                            Comment newComment = new Comment(commentContent, LocalDateTime.now());
                            post.addComment(newComment);
                            System.out.println("댓글이 등록되었습니다.");

                        }

                    } else if (option == 2) {
                        post.trackLikecount();
                        System.out.println("이 게시물을 좋아합니다. 총 추천수: " + post.getLikecount());


                    } else if (option == 3) {
                        if (loggedInUser == null) {
                            System.out.println("게시물을 수정하려면 먼저 로그인해야 합니다.");
                            return;
                        } else if (!post.getCreator().equals(loggedInUser.getUsername())){
                            System.out.println("게시물은 작성자만 수정할 수 있습니다. 본인 계정으로 로그인 해주세요.");
                            return;

                        } else {
                            System.out.println("===== 게시물 수정 =====");
                            System.out.println("기존 제목: " + post.getTitle());
                            System.out.println("새로운 제목을 입력하세요: ");
                            String newTitle = sc.nextLine();
                            System.out.println("새로운 내용을 입력하세요: ");
                            String newContent = sc.nextLine();

                            post.setTitle(newTitle);
                            post.setContent(newContent);

                            System.out.println("게시물이 수정되었습니다.");
                        }

                    } else if (option == 4) {
                        if (loggedInUser == null) {
                            System.out.println("게시물을 삭제하려면 먼저 로그인해야 합니다.");
                            return;


                        } else if (!post.getCreator().equals(loggedInUser.getUsername())){
                            System.out.println("게시물은 작성자만 삭제할 수 있습니다. 본인 계정으로 로그인 해주세요");
                            return;

                        } else {
                            listUserPosts();  // List the user's posts with index numbers
                            System.out.println("삭제할 게시물의 번호를 입력하세요:");
                            int deleteIndex = Integer.parseInt(sc.nextLine()) - 1;

                            int postCount = 0;
                            for (Post p : posts) {
                                if (p.getCreator().equals(loggedInUser.getUsername())) {
                                    if (postCount == deleteIndex) {
                                        deletePost(p);
                                        System.out.println("게시물이 삭제되었습니다.");
                                        break;
                                    }
                                    postCount++;
                                }
                            }
                            break;
                        }

                    } else if (option == 5) {
                        break;

                    } else {
                        System.out.println("유효하지 않은 옵션입니다. 다시 선택하세요.");
                    }
                }
                found = true;
                break;

            }
        }
        if (!found) {
            System.out.println("유효하지 않은 게시물 번호입니다.");
        }
    }

    public void listUserPosts() {
        System.out.println("===== 내가 작성한 게시물 =====");
        int index = 1;
        for (Post post : posts) {
            if (post.getCreator().equals(loggedInUser.getUsername())) {
                System.out.println(index + ". Title: " + post.getTitle() + " (ID: " + post.getId() + ")");
                index++;
            }
        }
        if (index == 1) {
            System.out.println("작성한 게시물이 없습니다.");
        }
    }
    public void deletePost (Post post) {
        posts.remove(post);
    }


    private void initializeTestPosts() {
        String defaultUsername = "TestUser";
        posts.add(new Post(postIdCounter++, "정처기 따야되나요?", "null", LocalDateTime.now(), defaultUsername));
        posts.add(new Post(postIdCounter++, "안녕하세요. 자바 관련 질문입니다.", "자바 관련 질문", LocalDateTime.now(), defaultUsername));
        posts.add(new Post(postIdCounter++, "Dbs 질문입니다.", "질문", LocalDateTime.now(), defaultUsername));
    }
}