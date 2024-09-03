package day8.miniProject;

import java.time.LocalDate;
import java.time.LocalTime;
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
    private String context;
    private LocalDate creationDate;
    private LocalTime creationTime;

    public Post(int id, String title, String context, LocalDate creationDate, LocalTime creationTime) {
        this.id = id;
        this.title = title;
        this.context = context;
        this.creationDate = creationDate;
        this.creationTime = creationTime;

    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContext() {
        return context;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContext(String context) {
        this.context = context;
    }
    public LocalDate getCreationDate () {
        return creationDate;
    }
    public LocalTime getCreationTime () {
        return creationTime;
    }
}

class Homepage {
    Scanner sc = new Scanner(System.in);
    ArrayList<Post> posts = new ArrayList<>();
    int postIdCounter = 1; // 가장 최신의 id값. id값의 고유성을 유지하기 위해 1씩 증가시킬 계획임.

    public void Start() {
        while (true) {
            System.out.println("===== 홈페이지 =====");
            System.out.println("명령어를 입력해주세요: ");
            String command = sc.nextLine();

            if (command.equals("exit")) {
                System.out.println("프로그램을 종료합니다.");
                break;

            } else if (command.equals("add")) {
                System.out.println("게시물 제목을 입력해주세요: ");
                String title = sc.nextLine();
                System.out.println("게시물 내용을 입력해주세요: ");
                String content = sc.nextLine();

                Post newPost = new Post(postIdCounter, title, content, LocalDate.now(), LocalTime.now());
                posts.add(newPost);

                System.out.println(postIdCounter + "번 게시물이 등록되었습니다.");
                postIdCounter++;

            } else if (command.equals("list")) {
                for (Post post : posts) {
                    System.out.println("게시물 번호: " + post.getId());
                    System.out.println("제목: " + post.getTitle());
                    System.out.println("-----");

                }

            } else if (command.equals("update")) {
                System.out.println("수정할 게시물 번호를 입력하세요");
                int id = Integer.parseInt(sc.nextLine());
                boolean found = false;

                for (Post post : posts) {

                    if (post.getId() == id) {
                        System.out.println("기존 제목: " + post.getTitle());
                        System.out.println("새로운 제목을 입력하세요: ");
                        String newTitle = sc.nextLine();
                        post.setTitle(newTitle);

                        System.out.println("기존 내용: " + post.getContext());
                        System.out.println("새로운 내용을 입력하세요: ");
                        String newContext = sc.nextLine();
                        post.setContext(newContext);

                        System.out.println(id + "번 게시물이 수정되었습니다.");
                        found = true;
                        break;
                    }
                    if (!found) {
                        System.out.println("없는 게시물 번호입니다.");

                    }
                }
            } else if (command.equals("delete")) {
                System.out.println("삭제할 게시물 번호를 입력하세요: ");
                int id = Integer.parseInt(sc.nextLine());
                boolean found = false;

                for (Post post : posts) {
                    if (post.getId() == id) {
                        posts.remove(post);
                        System.out.println(id + "번 게시물이 삭제되었습니다.");
                        found = true;
                        break;
                    }
                }
            } else if (command.equals("detail")) {
                System.out.println("상세보기 할 게시물 번호를 입력해주세요 : ");
                int id = Integer.parseInt(sc.nextLine());
                boolean found = false;

                for (Post post : posts) {
                    if (post.getId() == id) {
                        System.out.println("게시물 번호 : " + post.getId());
                        System.out.println("제목 : " + post.getTitle());
                        System.out.println("내용 : " + post.getContext());
                        System.out.println("작성일 : " + post.getCreationDate() + "/ " + post.getCreationTime());
                        System.out.println("-----");
                        found = true;
                        break;


                    }
                }

            }
        }
    }
}