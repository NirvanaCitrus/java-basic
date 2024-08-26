package day2;

public class DoubleLoop {
    public static void main(String[] args) {
        // while, for


        // 구구단 2단 만들기

        for (int dan = 2; dan <= 9; dan++) {
            for (int j = 1; j <= 9; j++) {
                if (j % 2 == 0) {
                    int result = dan * j;
                    System.out.println(dan + "X" + j + "=" + result);

                }

            }

        }


        // 짝수곱 출력하기
        int limit = 10;

        for (int dan = 4; dan <= 20; dan++) {
            if (dan % 2 != 0) {
                for (int gop = 4; gop <= limit; gop++) {
                    if (gop % 2 == 0) {
                        System.out.println(dan + "X" + gop + "=" + (dan * gop));

                    }

                }

            }

        }

        // 삼각형 만들기
        int y = 5;
        int star = 0;
        for (int i = 0; i < y; i++) {
            if (i <= y/2 - 1) {
                star++;
            } else {
                star--;
            }
            for (int j = 0; j < star; j++) {
                System.out.print("*");

            }
            System.out.println();

        }
    }


}
