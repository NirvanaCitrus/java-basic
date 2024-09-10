package day12.testpageApp;

import java.util.Scanner;

public class TestpageApp {
}

class Testpage {
    Scanner sc = new Scanner(System.in);
    PostController postController = new PostController();


    public void Run() {
        while (true) {
            System.out.println("===== 테스트 =====");
            System.out.println("명령어를 입력하세요 (add, list, delete, detail, update, search, exit): ");
            String command = sc.nextLine();

            if (command.equals("exit")) {
                System.out.println("프로그램이 종료됩니다.");
                break;

            } else if (command.equals("add")) {
                postController.add();

            } else if (command.equals("list")) {
                postController.list();

            } else if (command.equals("delete")) {
                postController.delete();

            } else if (command.equals("detail")) {
                postController.detail();

            } else if (command.equals("update")) {
                postController.update();

            } else if (command.equals("search")) {
                postController.search();

            }
        }
    }

}
