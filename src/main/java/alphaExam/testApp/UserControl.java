package alphaExam.testApp;

import java.util.Scanner;

public class UserControl {
    private Scanner sc = new Scanner(System.in);
    private UserDao userDao = new UserDao();
    private User loggedInUser;

    public void signup () {
        System.out.println("------- 회원 가입 -------");
        System.out.println("사용할 아이디를 입력하세요: ");
        String userId = sc.nextLine();
        System.out.println("사용할 비밀번호를 입력하세요: ");
        String password = sc.nextLine();
        System.out.println("사용할 닉네임을 입력하세요: ");
        String username = sc.nextLine();

        User user = new User(userId,password,username);
        userDao.addUser(user);
        System.out.println("회원가입이 완료되었습니다.");
    }

    public void login () {
        System.out.println("아이디를 입력하세요: ");
        String userId = sc.nextLine();
        System.out.println("비밀번호를 입력하세요: ");
        String password = sc.nextLine();

        User user = userDao.getUserById(userId);

        if (user != null && user.getPassword().equals(password)) {
            loggedInUser = user;
            System.out.println("로그인 성공! " + loggedInUser.getUsername() + "님 환영합니다.");

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
