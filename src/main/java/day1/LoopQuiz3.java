package day1;

public class LoopQuiz3 {
    public static void main(String[] args) {

        int a = 12;
        int b = 5;

        int start = Math.min(a, b);
        int end = Math.max(a, b);

        System.out.println("오름차순:");
        for (int i = start; i <= end; i++) {
            System.out.println(i);
            if (i < end) {
                System.out.println(",");

            }

        }
    }
}
