package day1;

public class LoopQuiz2 {
    public static void main(String[] args) {
        int time = 74;
        int score = 0;

        int sonEntrytime = 80;

        if (sonEntrytime <= 90) {
            score++;
            System.out.println("Goal score at minute: " + sonEntrytime + "! Current score: " + score);


        }

        for (int minute = sonEntrytime + 5; minute < 90; minute += 5) {
            score++;
            System.out.println("Goal score at minute: " + minute + "! Current score: " + score);

        }
        System.out.println("Final score for team A: " + score);


    }
}
