package day2;

import java.util.Scanner;

public class Introduce {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("이름을 입력해주세요 : ");
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        System.out.println("나이를 입력해주세요: ");
        int num1 = sc.nextInt();
        System.out.println(" 안녕하세요 " + num1 + " 세 " + str1 + " " + str2 + "입니다.");


    }
}
