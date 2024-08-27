package day3;

// 명명 규칙
// 클래스명은 대문자로 시작
// 의미가 바뀔 때 대문자로 구분. 두 단어 이상의 조합으로 이름 지을 때 단어의 앞부분은 대문자.
// 카멜 표기법
// 함수나 변수는 소문자로 시작.
// 상수는 모두 대문자 띄어쓰기는 _.

import java.util.ArrayList;
import java.util.Scanner;

public class NameApp {
    public static void main(String[] args) {
        // 명령어 입력: help
        // add: 이름 입력
        // list: 이름 목록
        // exit: 종료
        // 명령어 입력: add
        // 이름을 입력해주세요: john
        // 나이를 입력해주세요 : 18
        // john이 명부에 저장되었습니다.
        // 명령어 입력 : list
        // ==== 이름 목록 ====
        // 1. john, 18
        // =================

        Scanner sc = new Scanner(System.in);
        String[] nameList = new String[5]; // null 값으로 채워짐.
        int[] ageList = new int[5];
        int count = 0;

        while (true) {
            System.out.println("명령어 입력: ");
            String command = sc.nextLine();

            if (command.equals("exit")) {
                System.out.println("이름 프로그램이 종료됩니다.");
                break;

            } else if (command.equals("add")) {
                if (count < nameList.length) {
                    System.out.println("이름을 입력해주세요: ");
                    String name = sc.nextLine();
                    System.out.println("나이를 입력해주세요: ");
                    int age = Integer.parseInt(sc.nextLine());
                    nameList[count] = name;
                    ageList[count] = age;
                    System.out.println(name + "이 명부에 저장되었습니다.");
                    count++;

                } else {
                    System.out.println("명부가 가득 찼습니다.");
                }


            } else if (command.equals("list")) {
                System.out.println("===== 이름 목록 =====");
                for (int i = 0; i < count; i++) {
                    System.out.println(nameList[i] + "," + ageList[i]);
                }
            } else if (command.equals("help")) {
                System.out.println("add : 이름 입력");
                System.out.println("list : 이름 목록 확인");
                System.out.println("exit : 종료");

            }

        }
        sc.close();
    }
}
