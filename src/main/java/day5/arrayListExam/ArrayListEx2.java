package day5.arrayListExam;

import java.util.ArrayList;

public class ArrayListEx2 {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();

        names.add(0, "홍길동");
        names.add(1, "이순신");
        names.add(2, "황진이");
        names.add(3, "임꺽정");
        names.add(4, "강감찬");
        names.add(5, "을지문덕");

        System.out.println(names.size());
        System.out.println(names.get(2));
        System.out.println(names.get(3));
        System.out.println(names);
        System.out.println("==========");

        names.remove(0);
        names.remove(0);

        System.out.println(names.get(2));
        System.out.println(names.get(3));
        System.out.println(names);

        names.add(4, "정약용");
        System.out.println(names);

        for (int i = 0; i < names.size(); i++) {
            if (names.get(i).equals("임꺽정")) {
                names.set(i, "신사임당");

            }
            if (names.get(i).equals("을지문덕")) {
                names.set(i, "유관순");

            }
            String name = names.get(i);
            System.out.println(name);

        }

        System.out.println(names.get(0));
        System.out.println(names.get(1));
        System.out.println(names.get(3));

    }
}
