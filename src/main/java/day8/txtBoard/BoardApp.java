package day8.txtBoard;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class BoardApp {
    // main 메서드와 findPostById 메서드가 같이 사용해야 하므로 main 밖으로 빼주고 static 붙여줌
    ArrayList<Post> posts = new ArrayList<>();

    public void run() {
        Scanner sc = new Scanner(System.in);

        int latestId = 1;

        while (true) {
            System.out.print("명령어 : ");
            String command = sc.nextLine();

            if (command.equals("exit")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else if (command.equals("add")) {
                System.out.print("게시물 제목을 입력해주세요 : ");
                String title = sc.nextLine();
                System.out.print("게시물 내용을 입력해주세요 : ");
                String body = sc.nextLine();

                Post post = new Post(latestId, title, body);
                posts.add(post);
                System.out.println("게시물이 등록되었습니다.");
                latestId++;

            } else if (command.equals("list")) {

                System.out.println("==================");
                for (Post post : posts) {
                    System.out.printf("번호 : %d\n", post.getId());
                    System.out.printf("제목 : %s\n", post.getTitle());
                    System.out.println("==================");
                }
            } else if (command.equals("update")) {

                System.out.print("수정할 게시물 번호 : ");
                int targetId = Integer.parseInt(sc.nextLine());

                Post post = findPostById(targetId);

                if (post == null) {
                    System.out.println("없는 게시물 번호입니다.");
                    continue;
                }

                System.out.print("수정할 제목 : ");
                String newTitle = sc.nextLine();
                System.out.print("수정할 내용 : ");
                String newBody = sc.nextLine();

                post.setTitle(newTitle);
                post.setContent(newBody);
                System.out.println("수정이 완료되었습니다.");

            } else if (command.equals("delete")) {
                System.out.print("삭제할 게시물 번호 : ");
                int targetId = Integer.parseInt(sc.nextLine());
                Post post = findPostById(targetId);

                if (post == null) {
                    System.out.println("없는 게시물 번호입니다.");
                    continue;
                }

                posts.remove(post);
                System.out.println("삭제가 완료되었습니다.");

            }
        }
    }

    public Post findPostById(int id) {

        // 만약 내가 찾고자 하는 게시물이 없다면?
        for (Post post : posts) {
            if (post.getId() == id) {
                return post; // return을 만나면 메서드는 그 즉시 종료.
            }
        }

        return null; // null은 없다라는 의미
    }
}

//    public String currentDateTime () {
//        LocalDateTime currentDateTime = LocalDateTime.now();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");
//    }
//}
