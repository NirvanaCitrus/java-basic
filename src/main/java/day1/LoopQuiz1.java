package day1;

public class LoopQuiz1 {
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            System.out.println(i);

        }

        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);

            }


        }

        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i + ":even");
            } else if (i % 2 != 0)
                System.out.println(i + ":odd");

        }
    }
}
