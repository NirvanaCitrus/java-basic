package day10.miniProject;


import day10.post.PostController;
import day10.post.PostDao;
import day10.post.PostView;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class HomepageApp {
}

class Homepage {
    Scanner sc = new Scanner(System.in);
    ArrayList<User> users = new ArrayList<>();
    User loggedInUser = null;
    private static int postIdCounter = 4;
    PostDao postDao = new PostDao();
    PostView postView = new PostView();
    PostController postController = new PostController();


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
                signUp();

            } else if (command.equals("login")) {
                login();

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
                loggedInUser = null;
                System.out.println("로그아웃 되었습니다.");

            }
        }
    }


    private void signUp() {
        System.out.println("회원 가입");
        System.out.println("사용할 아이디를 입력해주세요: ");
        String userId = sc.nextLine();

        for (User user : users) {
            if (user.getUserId().equals(userId)) {
                System.out.println("이미 사용중인 아이디입니다. 다시 시도하세요");
                return;

            }

        }

        System.out.println("사용할 비밀번호를 입력하세요: ");
        String password = sc.nextLine();

        System.out.println("사용할 닉네임을 입력하세요: ");
        String username = sc.nextLine();

        User newUser = new User(userId, password, username);
        users.add(newUser);
        System.out.println("회원 가입이 완료되었습니다.");
    }

    private void login() {
        System.out.println("로그인");
        System.out.println("아이디를 입력하세요: ");
        String userId = sc.nextLine();
        System.out.println("비밀번호를 입력하세요: ");
        String password = sc.nextLine();

        for (User user : users) {
            if (user.getUserId().equals(userId) && user.getPassword().equals(password)) {
                loggedInUser = user;
                System.out.println("로그인 성공! " + loggedInUser.getUsername() + "님 환영합니다.");
                return;

            }

        }
        System.out.println("로그인 실패. 아이디 또는 비밀번호를 확인해주세요.");

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