package day2;

import java.util.Scanner;

public class InputEx2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("구구단");

        int dan = sc.nextInt();

        for (int i = 2; i <= 9; i++) {
            System.out.println(dan + " X " + i + " = " + (dan*i));


        }
        sc.close();
    }

}
