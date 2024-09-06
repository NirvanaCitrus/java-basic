package day10.userAuthentication;

import day10.miniProject.User;
import day10.miniProject.UserDao;

import java.util.Scanner;

public class UserAuthentication {
    Scanner sc = new Scanner(System.in);
    UserDao userDao = new UserDao();
    User loggedInUser = null;

    public void signUp() {
        System.out.println("회원 가입");
        System.out.println("사용할 아이디를 입력해주세요: ");
        String userId = sc.nextLine();

        if (userDao.isUserIdTaken(userId)) {
            System.out.println("이미 사용중인 아이디 입니다. 다시 시도하세요.");
            return;

        }

        System.out.println("사용할 비밀번호를 입력하세요: ");
        String password = sc.nextLine();

        System.out.println("사용할 닉네임을 입력하세요: ");
        String username = sc.nextLine();

        userDao.addUser(new User(userId, password, username));
        System.out.println("회원 가입이 완료되었습니다.");

    }

    public void login () {
        System.out.println("로그인");
        System.out.println("아이디를 입력해주세요: ");
        String userId = sc.nextLine();
        System.out.println("비밀번호를 입력해주세요: ");
        String password = sc.nextLine();

        User user = userDao.getUserById(userId);
        if (user != null && user.getPassword().equals(password)) {
            loggedInUser = user;
            System.out.println("로그인 성공! " + loggedInUser.getUsername() + "님 환영합니다!");

        } else {
            System.out.println("로그인 실패. 아이디 또는 비밀번호를 확인해주세요.");
        }
    }

    public void logout () {
        loggedInUser = null;
        System.out.println("로그아웃 되었습니다.");
    }

    public User getLoggedInUser () {
        return loggedInUser;
    }


}
