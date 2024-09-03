package day8.miniProject;

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

    public Post (int id, String title, String context) {
        this.id = id;
        this.title = title;
        this.context = context;

    }
    public int getId () {
        return id;
    }
    public String getTitle () {
        return title;
    }
    public String getContext () {
        return context;
    }
    public void setTitle (String title) {
        this.title = title;
    }
    public void setContext (String context) {
        this.context = context;
    }
}

class Homepage {
    Scanner sc = new Scanner(System.in);
    ArrayList<String> titles = new ArrayList<>();
    ArrayList<String> contexts = new ArrayList<>();

    public void Start() {
        while (true) {
            System.out.println("===== 홈페이지 =====");
            System.out.println("명령어를 입력해주세요: ");
            String command = sc.nextLine();

            if (command.equals("exit")) {
                System.out.println("프로그램을 종료합니다.");
                break;

            } else if (command.equals("add")) {
                System.out.println("게시물 제목을 입력해주세요 : ");
                String title = sc.nextLine();
                titles.add(title);
                System.out.println("게시물 내용을 입력해주세요 : ");
                String context = sc.nextLine();
                contexts.add(context);
                System.out.println("게시물이 등록되었습니다.");

            } else if (command.equals("list")) {
                for (int i = 0; i < titles.size(); i++) {
                    System.out.println("게시물 번호: " + (i + 1));
                    System.out.println("제목 : " + titles.get(i));
                    System.out.println("내용 : " + contexts.get(i));

                }

            } else if (command.equals("update")) {
                System.out.println("수정할 게시물 번호를 입력하세요");
                int index = Integer.parseInt(sc.nextLine()) - 1;

                if (index >= 0 && index < titles.size()) {
                    System.out.println("기존 제목: " + titles.get(index));
                    System.out.println("새로운 제목을 입력하세요: ");
                    String newTitle = sc.nextLine();
                    titles.set(index, newTitle);

                    System.out.println("기존 내용: " + contexts.get(index));
                    System.out.println("새로운 내용을 입력하세요: ");
                    String newContext = sc.nextLine();
                    contexts.set(index, newContext);

                    System.out.println((index + 1) + "번 게시물이 수정되었습니다.");

                } else {
                    System.out.println("없는 게시물 번호입니다.");
                    continue;
                }


            } else if (command.equals("delete")) {
                System.out.println("삭제할 게시물 번호를 입력하세요: ");
                int index = Integer.parseInt(sc.nextLine()) - 1;

                if (index >= 0 && index < titles.size()) {
                    titles.remove(index);
                    contexts.remove(index);
                    System.out.println((index + 1) + "번 게시물이 삭제되었습니다.");
                }

            }
        }
    }
}