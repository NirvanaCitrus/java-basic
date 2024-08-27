package day3.method;

public class Person2 {
    String language = "안녕하세요";

    public void greeting1(int language) {
        if (language == 1) {
            System.out.println("안녕하세요.");

        } else if (language == 2) {
            System.out.println("Bonjour");
        } else if (language == 3) {
            System.out.println("Hi");

        }

    }
    public void greeting2 (int language, int times) {
        for (int i = 0; i < times; i++) {
            if (language == 1) {
                System.out.println("안녕하세요.");

            } else if (language == 2) {
                System.out.println("Bonjour");
            } else if (language == 3) {
                System.out.println("Hi");

            }

        }


    }


}
