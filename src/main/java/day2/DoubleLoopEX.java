package day2;

public class DoubleLoopEX {
    public static void main(String[] args) {

        int y = 5;
        int star = 0;

        if (y % 2 == 1) {
            for (int i = 0; i < y; i++) {
                if (i <= y / 2) {
                    star++;

                }

            }
        }
    }
}
