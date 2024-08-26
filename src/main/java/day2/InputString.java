package day2;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class InputString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 문자열 입력 받기
        System.out.println("첫번째 값을 입력해주세요 : ");
        String str1 = sc.nextLine();
        System.out.println(str1);

        String str2 = sc.nextLine();
        System.out.println(str2);
    }
}
