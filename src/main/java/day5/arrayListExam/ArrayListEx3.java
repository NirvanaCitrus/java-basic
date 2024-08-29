package day5.arrayListExam;

import java.util.ArrayList;

public class ArrayListEx3 {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.age = 24;
        p1.name = "홍길동";

        Person p2 = new Person();
        p2.age = 30;
        p2.name = "이순신";

        Person p3 = new Person();
        p3.age = 41;
        p3.name = "을지문덕";

        Person p4 = new Person();
        p4.age = 32;
        p4.name = "황진이";

        ArrayList<Person> names = new ArrayList<>();
        names.add(0,p1);
        names.add(1,p2);
        names.add(2,p3);
        names.add(3,p4);

        for (int i = 0; i < names.size(); i++) {
            Person p = names.get(i);
            if (p.age > 30) {
            p.introduce();

            }

        }

        // 2개 이상의 데이터로 표현되는 개념/사물은 무조건 객체로 만들어라.




    }
}
