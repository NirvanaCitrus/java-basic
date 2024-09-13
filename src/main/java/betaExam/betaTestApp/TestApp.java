package betaExam.betaTestApp;

import java.util.Scanner;

public class TestApp {
    private Scanner sc = new Scanner(System.in);
    private PostController postController = new PostController();

    public void Run () {
        while (true) {
            System.out.println("======= 평가입니다 =======");
            System.out.println("명령어를 입력하세요 (add, delete, detail, list, update, search, exit): ");
            String command = sc.nextLine();

            if (command.equals("exit")) {
                System.out.println("프로그램을 종료합니다.");
                break;

            } else if (command.equals("add")) {
                postController.add();

            } else if (command.equals("delete")) {
                postController.delete();

            } else if (command.equals("detail")) {
                postController.detail();

            } else if (command.equals("list")) {
                postController.list();

            } else if (command.equals("update")) {
                postController.update();

            } else if (command.equals("search")) {
                postController.search();

            } else {
                System.out.println("존재하지 않는 기능입니다.");
                continue;
            }
        }
    }
}
