package day2;

import java.util.Scanner;

public class InputExam {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 반복문 추가 문법
        // 반복문 강제 종료: break
        // 반복문 강제도 다음 회차 넘기기 : continue


//        for(int i = 0; i <= 10; i++) {
//            if(i == 5) {
//                //break; // 강제 종료
//                //continue; // 다음 회차로 넘기기
//
//
//            }
//            System.out.println(i);
//
//        }

        while(true) {
            System.out.println("값을 입력해주세요: ");
            int num = sc.nextInt();

            if (num == 0) {// num 이 0이면 if 문 실행
                break;
            }
            System.out.println("당신이 입력한 값은 : " + num);

        }

        System.out.println("프로그램이 종료되었습니다");
    }
}
