package day10.miniProject;


import day10.post.PostController;
import day10.post.PostDao;
import day10.post.PostView;
import day10.userAuthentication.UserAuthentication;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class HomepageApp {
}

class Homepage {
    Scanner sc = new Scanner(System.in);
    PostDao postDao = new PostDao();
    PostView postView = new PostView();
    PostController postController = new PostController();
    UserAuthentication userAuth = new UserAuthentication();


    public void Run() {
        while (true) {
            System.out.println("======= Satellite =======");
            System.out.println("명령어를 입력하세요 (signup, login, add, list, update, delete, detail, search, logout, exit): ");
            String command = sc.nextLine();

            if (command.equals("exit")) {
                System.out.println("See you again!");
                break;
//                각 기능을 함수화 ->
//
//                        - 가독성이 좋아지고 재활용성
//                - 지역변수(함수에서만 사용하고 버림)
//                        - 외부에 영향을 최소화
            } else if (command.equals("signup")) {
                userAuth.signUp();

            } else if (command.equals("login")) {
                userAuth.login();

            } else if (command.equals("add")) {
                postController.add();

            } else if (command.equals("list")) {
                postController.list();

            } else if (command.equals("update")) {
                postController.update();

            } else if (command.equals("delete")) {
                postController.delete();

            } else if (command.equals("detail")) {
                postController.detail();

            } else if (command.equals("search")) {
                postController.search();

            } else if (command.equals("logout")) {
                userAuth.logout();

            }
        }
    }



    public String getCurrentDateTime() {
        // 현재 날짜와 시간 가져오기
        LocalDateTime currentDateTime = LocalDateTime.now();
        // 원하는 포맷 지정하기
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");
        // 포맷 적용하여 출력하기
        String formattedDateTime = currentDateTime.format(formatter);
        return formattedDateTime;
    }
}